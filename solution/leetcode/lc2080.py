# 题目链接: https://leetcode.cn/problems/range-frequency-queries/description/
# 时空复杂度: init O(n) O(n) query O(log n)
# Tags: idx数组二分查找

from collections import defaultdict
from typing import List
from bisect import bisect_left


class RangeFreqQuery:

    # 组织出，key: 数字，value: 下标数组
    # query 就是，value 里在 [left, right] 里有几个
    def __init__(self, arr: List[int]):
        self.pos = defaultdict(list)
        for i, x in enumerate(arr):
            self.pos[x].append(i)

    def query(self, left: int, right: int, value: int) -> int:
        idx_arr = self.pos[value]
        return bisect_left(idx_arr, right + 1) - bisect_left(idx_arr, left)


# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)
