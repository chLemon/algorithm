# 算法复习 Web 应用设计

## 概述

基于 `solution/` 目录下所有算法题目的复习工具，每天推荐 2 道不同分类的题目，支持渐进式揭示和进度追踪。目录中的题目会持续更新，应用自动加载新题目。

## 技术栈

- Flask + Jinja2 模板
- JSON 文件存储复习进度
- 纯 CSS + 少量 JS

## 核心功能

### 1. 每日推荐
- 递归扫描整个 `solution/` 目录，动态加载所有 `.py` 文件
- 用日期作种子，同一天刷新题目不变
- 从不同 tag 中各抽一题
- 优先推荐未复习过的题目

### 2. 渐进式揭示
答题页分三步揭示：
1. 只显示 LeetCode 链接 → 回忆思路
2. 点击"看看提示" → 显示复杂度和标签
3. 点击"查看代码" → 显示完整代码

### 3. 复习进度追踪
- 记录每道题的复习次数和最后复习时间
- 进度页显示整体统计

## 文件结构

```
review/
├── app.py              # Flask 主应用
├── templates/
│   ├── base.html       # 基础模板
│   ├── index.html      # 首页（今日题目）
│   ├── question.html   # 答题页（渐进揭示）
│   └── progress.html   # 进度页
├── static/
│   └── style.css       # 样式
└── review.json          # 复习记录（自动创建）
```

## 数据结构

### 题目（从 .py 文件解析）
```python
class Question:
    rel_path: str       # 相对于 solution/ 的路径，如 "leetcode/lc3.py"
    web_link: str       # LeetCode 链接
    complexity: str     # 时空复杂度
    tags: list[str]     # 标签列表
    code: str           # 完整代码
```

### 复习记录（review.json）
```json
{
  "reviewed": {
    "leetcode/lc3.py": {"count": 2, "last_reviewed": "2026-05-13"},
    "leetcode/lc42.py": {"count": 1, "last_reviewed": "2026-05-12"}
  }
}
```

## 路由设计

| 路由 | 方法 | 说明 |
|------|------|------|
| `/` | GET | 首页，显示今日 2 道题目 |
| `/question/<path:rel_path>` | GET | 答题页，渐进式揭示 |
| `/api/complete/<path:rel_path>` | POST | 标记题目已复习 |
| `/progress` | GET | 进度页 |

## 每日推荐算法

1. 收集所有题目的 tag（按逗号分割）
2. 用 `hash(日期字符串)` 选第一个 tag
3. 从该 tag 的题目中随机选一题（优先未复习的）
4. 从剩余 tag 中再选一题，确保分类不同
5. 如果题目不够，放宽分类限制
