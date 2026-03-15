# 题目链接: https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/
# 时空复杂度: O(mn*(mn)!)
# Tags:

from itertools import permutations
from math import inf


# 暴力：全排列后匹配
class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        from_ = []
        to = []
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                if v > 1:
                    from_.extend([(i, j)] * (v - 1))
                elif v < 1:
                    to.append((i, j))
        # 全排列计算
        min_cost = inf
        for f in permutations(from_):
            cost = 0
            for (x1, y1), (x2, y2) in zip(f, to):
                cost += abs(x1 - x2) + abs(y1 - y2)
            min_cost = min(min_cost, cost)
        return int(min_cost)
