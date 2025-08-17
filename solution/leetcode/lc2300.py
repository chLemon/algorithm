# 题目链接: https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/
# 时空复杂度: O((m + n) log m) O(1)
# Tags: 二分查找

import bisect


class Solution:
    def successfulPairs(
        self, spells: List[int], potions: List[int], success: int
    ) -> List[int]:
        potions.sort()
        n = len(potions)
        return [n - bisect.bisect_left(potions, (success - 1) // x + 1) for x in spells]
