import json
import random
import re
import urllib.request
from dataclasses import dataclass, field
from datetime import date
from html.parser import HTMLParser
from pathlib import Path

from flask import Flask, render_template, jsonify

SOLUTION_DIR = Path(__file__).parent.parent / "solution"
PROGRESS_FILE = Path(__file__).parent / "review.json"
PROBLEM_CACHE_FILE = Path(__file__).parent / "problem_cache.json"


@dataclass
class Question:
    rel_path: str
    web_link: str
    complexity: str
    tags: list[str]
    code: str
    title: str = ""
    difficulty: str = ""
    description: str = ""


class _HTMLStripper(HTMLParser):
    def __init__(self):
        super().__init__()
        self._parts: list[str] = []

    def handle_data(self, data):
        self._parts.append(data)

    def get_text(self):
        return "".join(self._parts)


def strip_html(html: str) -> str:
    s = _HTMLStripper()
    s.feed(html)
    return s.get_text().strip()


def load_problem_cache() -> dict:
    if PROBLEM_CACHE_FILE.exists():
        return json.loads(PROBLEM_CACHE_FILE.read_text(encoding="utf-8"))
    return {}


def save_problem_cache(cache: dict):
    PROBLEM_CACHE_FILE.write_text(
        json.dumps(cache, ensure_ascii=False, indent=2), encoding="utf-8"
    )


def extract_slug(web_link: str) -> str:
    m = re.search(r"/problems/([^/]+)", web_link)
    return m.group(1) if m else ""


def fetch_problem_info(slug: str) -> dict:
    query = """
    query questionDetail($titleSlug: String!) {
        question(titleSlug: $titleSlug) {
            translatedTitle
            translatedContent
            difficulty
        }
    }
    """
    body = json.dumps({"query": query, "variables": {"titleSlug": slug}}).encode()
    req = urllib.request.Request(
        "https://leetcode.cn/graphql/",
        data=body,
        headers={"Content-Type": "application/json"},
    )
    with urllib.request.urlopen(req, timeout=10) as resp:
        data = json.loads(resp.read())
    q = data["data"]["question"]
    content = strip_html(q["translatedContent"] or "")
    if len(content) > 200:
        content = content[:200] + "..."
    return {
        "title": q["translatedTitle"] or "",
        "difficulty": q["difficulty"] or "",
        "description": content,
    }


def enrich_question(q: Question, cache: dict):
    slug = extract_slug(q.web_link)
    if not slug:
        return
    if slug in cache:
        info = cache[slug]
    else:
        try:
            info = fetch_problem_info(slug)
            cache[slug] = info
            save_problem_cache(cache)
        except Exception as e:
            print(f"警告：获取题目信息失败 {slug}: {e}")
            return
    q.title = info["title"]
    q.difficulty = info["difficulty"]
    q.description = info["description"]


def parse_question(filepath: Path) -> Question:
    text = filepath.read_text(encoding="utf-8")
    lines = text.splitlines()
    if len(lines) < 3:
        raise ValueError(f"{filepath}: 需要至少 3 行注释")

    link_line = lines[0].lstrip("#").strip()
    if link_line.startswith("题目链接:"):
        link_line = link_line.removeprefix("题目链接:").strip()

    complex_line = lines[1].lstrip("#").strip()
    if complex_line.startswith("时空复杂度:"):
        complex_line = complex_line.removeprefix("时空复杂度:").strip()

    tag_line = lines[2].lstrip("#").strip()
    if tag_line.startswith("Tags:"):
        tag_line = tag_line.removeprefix("Tags:").strip()
    tags = [t.strip() for t in tag_line.replace("，", ",").split(",") if t.strip()]

    code_start = 3
    if len(lines) > 3 and lines[3].strip() == "":
        code_start = 4
    code = "\n".join(lines[code_start:])

    return Question(
        rel_path=str(filepath.relative_to(SOLUTION_DIR)).replace("\\", "/"),
        web_link=link_line,
        complexity=complex_line,
        tags=tags,
        code=code,
    )


def load_all_questions() -> list[Question]:
    questions = []
    for f in sorted(SOLUTION_DIR.rglob("*.py")):
        try:
            questions.append(parse_question(f))
        except Exception as e:
            print(f"警告：跳过 {f.name}: {e}")
    return questions


def load_progress() -> dict:
    if PROGRESS_FILE.exists():
        return json.loads(PROGRESS_FILE.read_text(encoding="utf-8"))
    return {"reviewed": {}}


def save_progress(progress: dict):
    PROGRESS_FILE.write_text(
        json.dumps(progress, ensure_ascii=False, indent=2), encoding="utf-8"
    )


def mark_reviewed(rel_path: str):
    progress = load_progress()
    today = date.today().isoformat()
    entry = progress["reviewed"].get(rel_path, {"count": 0, "last_reviewed": ""})
    entry["count"] += 1
    entry["last_reviewed"] = today
    progress["reviewed"][rel_path] = entry
    save_progress(progress)


def get_daily_questions(questions: list[Question]) -> tuple[Question, Question]:
    progress = load_progress()
    reviewed = progress.get("reviewed", {})

    by_tag: dict[str, list[Question]] = {}
    for q in questions:
        for tag in q.tags:
            by_tag.setdefault(tag, []).append(q)

    today_str = date.today().isoformat()
    rng = random.Random(today_str)

    tags = list(by_tag.keys())
    rng.shuffle(tags)

    q1 = _pick_one(by_tag[tags[0]], reviewed, rng)

    q2 = None
    for tag in tags[1:]:
        candidates = [q for q in by_tag[tag] if q.rel_path != q1.rel_path]
        if candidates:
            q2 = _pick_one(candidates, reviewed, rng)
            break

    if q2 is None:
        others = [q for q in questions if q.rel_path != q1.rel_path]
        q2 = _pick_one(others, reviewed, rng)

    return q1, q2


def _pick_one(
    candidates: list[Question], reviewed: dict, rng: random.Random
) -> Question:
    unreviewed = [q for q in candidates if q.rel_path not in reviewed]
    pool = unreviewed if unreviewed else candidates
    return rng.choice(pool)


app = Flask(__name__)
questions = load_all_questions()
problem_cache = load_problem_cache()


@app.route("/")
def index():
    q1, q2 = get_daily_questions(questions)
    enrich_question(q1, problem_cache)
    enrich_question(q2, problem_cache)
    progress = load_progress()
    return render_template(
        "index.html", q1=q1, q2=q2, reviewed=progress.get("reviewed", {})
    )


@app.route("/question/<path:rel_path>")
def question_page(rel_path):
    q = next((q for q in questions if q.rel_path == rel_path), None)
    if not q:
        return "未找到", 404
    enrich_question(q, problem_cache)
    progress = load_progress()
    reviewed_info = progress.get("reviewed", {}).get(rel_path)
    return render_template("question.html", q=q, reviewed_info=reviewed_info)


@app.route("/api/complete/<path:rel_path>", methods=["POST"])
def complete(rel_path):
    mark_reviewed(rel_path)
    return jsonify({"ok": True})


@app.route("/progress")
def progress_page():
    progress_data = load_progress()
    reviewed = progress_data.get("reviewed", {})
    total = len(questions)
    done = len(reviewed)
    return render_template(
        "progress.html",
        questions=questions,
        reviewed=reviewed,
        total=total,
        done=done,
    )


if __name__ == "__main__":
    app.run(debug=True, port=5000)
