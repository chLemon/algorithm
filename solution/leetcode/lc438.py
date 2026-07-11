# 题目链接: https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
# 时空复杂度:
# Tags:

from collections import Counter
from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_cnt = Counter(p)
        s_cnt = Counter()
        ans = []

        for i, c in enumerate(s):
            s_cnt[c] += 1
            left = i - len(p) + 1
            if left < 0:
                continue
            if s_cnt == p_cnt:
                ans.append(left)
            s_cnt[s[left]] -= 1
        return ans
