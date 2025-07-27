# https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/
# O(n) O(1)
# 同向双指针

class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        left = ans = 0
        pos = -1
        # 这里 right 可以直接从1开始，这样会简洁一点
        for right, x in enumerate(s):
            if right > 0 and x == s[right - 1]:
                # 新引入了重复子串
                if pos >= 0:
                    left = pos
                pos = right
            ans = max(ans, right - left + 1)
        return ans