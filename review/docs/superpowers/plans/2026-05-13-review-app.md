# 算法复习 Web 应用实现计划

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**目标：** 构建一个 Flask Web 应用，每天推荐算法题目，支持渐进式揭示和复习进度追踪。

**架构：** 单文件 Flask 应用，递归扫描整个 `solution/` 目录（不仅仅是 `leetcode/`）动态加载所有 `.py` 文件。新增题目会自动被加载，无需改代码。JSON 文件存储复习进度，Jinja2 模板渲染页面。

**技术栈：** Flask, Jinja2, Python 标准库 (json, pathlib, random)

---

### 任务 1：项目设置 & 题目解析器

**文件：**
- 创建：`review/app.py`
- 创建：`review/requirements.txt`

- [ ] **步骤 1：创建 requirements.txt**

```
flask>=3.0
```

- [ ] **步骤 2：安装依赖**

运行：`pip install -r requirements.txt`

- [ ] **步骤 3：编写 Question 数据类和解析器**

在 `app.py` 中编写解析器。题目文件有两种注释格式：

格式 A（旧版）：
```python
# https://leetcode.cn/problems/xxx/
# O(n) O(1)
# 同向双指针
```

格式 B（新版）：
```python
# 题目链接: https://leetcode.cn/problems/xxx/description/
# 时空复杂度: O(n) O(1)
# Tags: 同向双指针
```

```python
import json
import random
from dataclasses import dataclass
from datetime import date
from pathlib import Path

SOLUTION_DIR = Path(__file__).parent.parent / "solution"
PROGRESS_FILE = Path(__file__).parent / "review.json"


@dataclass
class Question:
    rel_path: str        # 相对于 solution/ 的路径，如 "leetcode/lc3.py"
    web_link: str
    complexity: str
    tags: list[str]
    code: str


def parse_question(filepath: Path) -> Question:
    text = filepath.read_text(encoding="utf-8")
    lines = text.splitlines()
    if len(lines) < 3:
        raise ValueError(f"{filepath}: 需要至少 3 行注释")

    # 解析链接（第 0 行）
    link_line = lines[0].lstrip("#").strip()
    if link_line.startswith("题目链接:"):
        link_line = link_line.removeprefix("题目链接:").strip()

    # 解析复杂度（第 1 行）
    complex_line = lines[1].lstrip("#").strip()
    if complex_line.startswith("时空复杂度:"):
        complex_line = complex_line.removeprefix("时空复杂度:").strip()

    # 解析标签（第 2 行）
    tag_line = lines[2].lstrip("#").strip()
    if tag_line.startswith("Tags:"):
        tag_line = tag_line.removeprefix("Tags:").strip()
    tags = [t.strip() for t in tag_line.replace("，", ",").split(",") if t.strip()]

    # 代码从第 3 行开始（跳过空行）
    code_start = 3
    if len(lines) > 3 and lines[3].strip() == "":
        code_start = 4
    code = "\n".join(lines[code_start:])

    return Question(
        rel_path=str(filepath.relative_to(SOLUTION_DIR)),
        web_link=link_line,
        complexity=complex_line,
        tags=tags,
        code=code,
    )


def load_all_questions() -> list[Question]:
    """递归扫描 SOLUTION_DIR 下所有 .py 文件，新增题目自动加载。"""
    questions = []
    for f in sorted(SOLUTION_DIR.rglob("*.py")):
        try:
            questions.append(parse_question(f))
        except Exception as e:
            print(f"警告：跳过 {f.name}: {e}")
    return questions
```

- [ ] **步骤 4：手动测试解析器**

运行：`python -c "from app import load_all_questions; qs = load_all_questions(); print(f'加载了 {len(qs)} 道题'); print(qs[0])"`

预期：`加载了 117 道题` 和一个 Question 对象。

- [ ] **步骤 5：提交**

```bash
cd D:\chen\algorithm\review
git add app.py requirements.txt
git commit -m "feat: 添加题目解析器"
```

---

### 任务 2：进度追踪

**文件：**
- 修改：`review/app.py`

- [ ] **步骤 1：添加进度读写函数**

```python
def load_progress() -> dict:
    if PROGRESS_FILE.exists():
        return json.loads(PROGRESS_FILE.read_text(encoding="utf-8"))
    return {"reviewed": {}}


def save_progress(progress: dict):
    PROGRESS_FILE.write_text(json.dumps(progress, ensure_ascii=False, indent=2), encoding="utf-8")


def mark_reviewed(rel_path: str):
    progress = load_progress()
    today = date.today().isoformat()
    entry = progress["reviewed"].get(rel_path, {"count": 0, "last_reviewed": ""})
    entry["count"] += 1
    entry["last_reviewed"] = today
    progress["reviewed"][rel_path] = entry
    save_progress(progress)
```

- [ ] **步骤 2：测试进度函数**

运行：`python -c "from app import mark_reviewed, load_progress; mark_reviewed('leetcode/lc3.py'); print(load_progress())"`

预期：包含 `leetcode/lc3.py` 条目的 JSON。测试完后删除 `review.json`。

- [ ] **步骤 3：提交**

```bash
git add app.py
git commit -m "feat: 添加进度追踪"
```

---

### 任务 3：每日推荐算法

**文件：**
- 修改：`review/app.py`

- [ ] **步骤 1：添加每日推荐函数**

```python
def get_daily_questions(questions: list[Question]) -> tuple[Question, Question]:
    """从不同标签中选 2 道题，用日期作种子保证同一天结果不变。"""
    progress = load_progress()
    reviewed = progress.get("reviewed", {})

    # 按标签分组
    by_tag: dict[str, list[Question]] = {}
    for q in questions:
        for tag in q.tags:
            by_tag.setdefault(tag, []).append(q)

    # 用今天的日期作随机种子
    today_str = date.today().isoformat()
    rng = random.Random(today_str)

    tags = list(by_tag.keys())
    rng.shuffle(tags)

    # 从第一个标签选一题，优先未复习的
    q1 = _pick_one(by_tag[tags[0]], reviewed, rng)

    # 从不同标签选第二题
    q2 = None
    for tag in tags[1:]:
        candidates = [q for q in by_tag[tag] if q.rel_path != q1.rel_path]
        if candidates:
            q2 = _pick_one(candidates, reviewed, rng)
            break

    # 兜底：如果没有不同标签的题，随便选一题
    if q2 is None:
        others = [q for q in questions if q.rel_path != q1.rel_path]
        q2 = _pick_one(others, reviewed, rng)

    return q1, q2


def _pick_one(candidates: list[Question], reviewed: dict, rng: random.Random) -> Question:
    """优先选未复习过的题目。"""
    unreviewed = [q for q in candidates if q.rel_path not in reviewed]
    pool = unreviewed if unreviewed else candidates
    return rng.choice(pool)
```

- [ ] **步骤 2：测试推荐算法**

运行：`python -c "from app import load_all_questions, get_daily_questions; qs = load_all_questions(); a, b = get_daily_questions(qs); print(f'题目1: {a.rel_path} 标签={a.tags}'); print(f'题目2: {b.rel_path} 标签={b.tags}')"`

预期：两道不同标签（或至少不同路径）的题目。

- [ ] **步骤 3：提交**

```bash
git add app.py
git commit -m "feat: 添加每日推荐算法"
```

---

### 任务 4：基础模板 & 样式

**文件：**
- 创建：`review/templates/base.html`
- 创建：`review/static/style.css`

- [ ] **步骤 1：创建 base.html**

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{% block title %}温故而知新{% endblock %}</title>
    <link rel="stylesheet" href="{{ url_for('static', filename='style.css') }}">
</head>
<body>
    <nav>
        <a href="/">今日题目</a>
        <a href="/progress">复习进度</a>
    </nav>
    <main>
        {% block content %}{% endblock %}
    </main>
</body>
</html>
```

- [ ] **步骤 2：创建 style.css**

```css
* { margin: 0; padding: 0; box-sizing: border-box; }
body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif; background: #f5f5f5; color: #333; }
nav { background: #2c3e50; padding: 1rem 2rem; display: flex; gap: 2rem; }
nav a { color: #ecf0f1; text-decoration: none; font-size: 1.1rem; }
nav a:hover { color: #3498db; }
main { max-width: 800px; margin: 2rem auto; padding: 0 1rem; }
.card { background: white; border-radius: 8px; padding: 1.5rem; margin-bottom: 1.5rem; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
.card h2 { margin-bottom: 1rem; color: #2c3e50; }
.btn { display: inline-block; padding: 0.6rem 1.2rem; border: none; border-radius: 6px; cursor: pointer; font-size: 1rem; text-decoration: none; }
.btn-primary { background: #3498db; color: white; }
.btn-primary:hover { background: #2980b9; }
.btn-secondary { background: #95a5a6; color: white; }
.btn-secondary:hover { background: #7f8c8d; }
.tag { display: inline-block; background: #e8f4f8; color: #2980b9; padding: 0.2rem 0.6rem; border-radius: 4px; font-size: 0.85rem; margin-right: 0.5rem; }
pre { background: #2c3e50; color: #ecf0f1; padding: 1rem; border-radius: 6px; overflow-x: auto; line-height: 1.5; }
code { font-family: "Fira Code", "Consolas", monospace; }
.reveal-btn { margin: 1rem 0; }
.hidden { display: none; }
.progress-bar { background: #ecf0f1; border-radius: 4px; height: 20px; overflow: hidden; margin: 1rem 0; }
.progress-fill { background: #27ae60; height: 100%; transition: width 0.3s; }
.stat { font-size: 2rem; font-weight: bold; color: #2c3e50; }
.stat-label { color: #7f8c8d; font-size: 0.9rem; }
```

- [ ] **步骤 3：提交**

```bash
git add templates/base.html static/style.css
git commit -m "feat: 添加基础模板和样式"
```

---

### 任务 5：Flask 路由

**文件：**
- 修改：`review/app.py`

- [ ] **步骤 1：在 app.py 末尾添加 Flask 应用和路由**

```python
from flask import Flask, render_template, jsonify

app = Flask(__name__)

questions = load_all_questions()


@app.route("/")
def index():
    q1, q2 = get_daily_questions(questions)
    progress = load_progress()
    return render_template("index.html", q1=q1, q2=q2, reviewed=progress.get("reviewed", {}))


@app.route("/question/<path:rel_path>")
def question_page(rel_path):
    q = next((q for q in questions if q.rel_path == rel_path), None)
    if not q:
        return "未找到", 404
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
    return render_template("progress.html", questions=questions, reviewed=reviewed, total=total, done=done)


if __name__ == "__main__":
    app.run(debug=True, port=5000)
```

- [ ] **步骤 2：提交**

```bash
git add app.py
git commit -m "feat: 添加 Flask 路由"
```

---

### 任务 6：首页模板

**文件：**
- 创建：`review/templates/index.html`

- [ ] **步骤 1：创建 index.html**

```html
{% extends "base.html" %}
{% block title %}今日题目 - 温故而知新{% endblock %}

{% block content %}
<h1>今日复习</h1>

<div class="card">
    <h2>回忆题</h2>
    <p>先回忆这道题的思路，再点击查看</p>
    <p><strong>标签：</strong>
        {% for tag in q1.tags %}<span class="tag">{{ tag }}</span>{% endfor %}
    </p>
    <a href="/question/{{ q1.rel_path }}" class="btn btn-primary">开始回忆</a>
    {% if q1.rel_path in reviewed %}
    <span style="margin-left: 1rem; color: #27ae60;">已复习 {{ reviewed[q1.rel_path].count }} 次</span>
    {% endif %}
</div>

<div class="card">
    <h2>动手题</h2>
    <p>动手写这道题的代码</p>
    <p><strong>标签：</strong>
        {% for tag in q2.tags %}<span class="tag">{{ tag }}</span>{% endfor %}
    </p>
    <a href="/question/{{ q2.rel_path }}" class="btn btn-primary">开始做题</a>
    {% if q2.rel_path in reviewed %}
    <span style="margin-left: 1rem; color: #27ae60;">已复习 {{ reviewed[q2.rel_path].count }} 次</span>
    {% endif %}
</div>
{% endblock %}
```

- [ ] **步骤 2：提交**

```bash
git add templates/index.html
git commit -m "feat: 添加首页模板"
```

---

### 任务 7：答题页模板（渐进式揭示）

**文件：**
- 创建：`review/templates/question.html`

- [ ] **步骤 1：创建 question.html**

```html
{% extends "base.html" %}
{% block title %}{{ q.rel_path }} - 温故而知新{% endblock %}

{% block content %}
<div class="card">
    <h2>{{ q.rel_path }}</h2>

    <!-- 第一步：始终显示链接 -->
    <p><a href="{{ q.web_link }}" target="_blank">打开 LeetCode 题目</a></p>

    {% if reviewed_info %}
    <p style="color: #27ae60;">已复习 {{ reviewed_info.count }} 次，上次：{{ reviewed_info.last_reviewed }}</p>
    {% endif %}

    <!-- 第二步：点击显示复杂度和标签 -->
    <div class="reveal-btn">
        <button class="btn btn-secondary" onclick="document.getElementById('hints').classList.remove('hidden'); this.style.display='none'">看看提示</button>
    </div>
    <div id="hints" class="hidden">
        <p><strong>时空复杂度：</strong>{{ q.complexity }}</p>
        <p><strong>标签：</strong>
            {% for tag in q.tags %}<span class="tag">{{ tag }}</span>{% endfor %}
        </p>
    </div>

    <!-- 第三步：点击显示代码 -->
    <div class="reveal-btn">
        <button class="btn btn-secondary" onclick="document.getElementById('code').classList.remove('hidden'); this.style.display='none'">查看代码</button>
    </div>
    <div id="code" class="hidden">
        <pre><code>{{ q.code }}</code></pre>
    </div>

    <!-- 标记已复习 -->
    <div style="margin-top: 2rem;">
        <button class="btn btn-primary" onclick="markDone('{{ q.rel_path }}')">标记已复习</button>
        <span id="done-msg" style="margin-left: 1rem; color: #27ae60; display: none;">已记录</span>
    </div>
</div>

<a href="/" class="btn btn-secondary">返回今日题目</a>

<script>
function markDone(path) {
    fetch('/api/complete/' + encodeURIComponent(path), {method: 'POST'})
        .then(r => r.json())
        .then(() => {
            document.getElementById('done-msg').style.display = 'inline';
        });
}
</script>
{% endblock %}
```

- [ ] **步骤 2：提交**

```bash
git add templates/question.html
git commit -m "feat: 添加答题页模板（渐进式揭示）"
```

---

### 任务 8：进度页模板

**文件：**
- 创建：`review/templates/progress.html`

- [ ] **步骤 1：创建 progress.html**

```html
{% extends "base.html" %}
{% block title %}复习进度 - 温故而知新{% endblock %}

{% block content %}
<h1>复习进度</h1>

<div class="card">
    <div style="display: flex; gap: 3rem;">
        <div>
            <div class="stat">{{ done }}</div>
            <div class="stat-label">已复习</div>
        </div>
        <div>
            <div class="stat">{{ total }}</div>
            <div class="stat-label">总题数</div>
        </div>
        <div>
            <div class="stat">{{ "%.0f"|format(done / total * 100 if total else 0) }}%</div>
            <div class="stat-label">完成率</div>
        </div>
    </div>
    <div class="progress-bar">
        <div class="progress-fill" style="width: {{ (done / total * 100) if total else 0 }}%"></div>
    </div>
</div>

<div class="card">
    <h2>已复习的题目</h2>
    {% for rel_path, info in reviewed.items() %}
    <p>
        <strong>{{ rel_path }}</strong>
        <span style="color: #7f8c8d; margin-left: 1rem;">{{ info.count }} 次 · {{ info.last_reviewed }}</span>
    </p>
    {% else %}
    <p>还没有复习过任何题目，快去开始吧！</p>
    {% endfor %}
</div>

<div class="card">
    <h2>未复习的题目 ({{ total - done }})</h2>
    {% for q in questions %}
        {% if q.rel_path not in reviewed %}
        <p>{{ q.rel_path }}
            {% for tag in q.tags %}<span class="tag">{{ tag }}</span>{% endfor %}
        </p>
        {% endif %}
    {% endfor %}
</div>
{% endblock %}
```

- [ ] **步骤 2：提交**

```bash
git add templates/progress.html
git commit -m "feat: 添加进度页模板"
```

---

### 任务 9：运行验证

- [ ] **步骤 1：启动应用**

运行：`cd D:\chen\algorithm\review && python app.py`

预期：Flask 启动在 http://127.0.0.1:5000

- [ ] **步骤 2：浏览器测试**

打开 http://127.0.0.1:5000 — 验证：
- 显示两道不同题目
- 点击题目 → 渐进式揭示正常工作
- 点击"标记已复习" → 显示成功消息
- 访问 /progress → 统计已更新

- [ ] **步骤 3：最终提交**

```bash
git add -A
git commit -m "feat: 完成算法复习 Web 应用"
```
