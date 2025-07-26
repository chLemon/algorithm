# https://leetcode.cn/problems/longest-substring-without-repeating-characters/
# O(n) O(128)
# 同向双指针

from collections import Counter


class Solution:
    def counterVersion(self, s: str) -> int:
        ans = left = 0
        cnt = Counter() # hashmap key: char, value: int
        for right, c in enumerate(s):
            cnt[c] += 1
            while cnt[c] > 1:
                cnt[s[left]] -= 1
                left += 1
            ans = max(ans, right - left + 1)
        return ans

    def setVersion(self, s:str) -> int:
        # 每次都是在一个满足条件的串的基础上，新放入一个元素。所以如果有重复元素，一定是和新加入的元素相同的
        ans = left = 0
        occurred = set()
        for right, c in enumerate(s):
            while c in occurred:
                occurred.remove(s[left])
                left += 1
            occurred.add(c)
            ans = max(ans, right - left + 1)
        return ans

    def lengthOfLongestSubstring(self, s: str) -> int:
        return self.setVersion(s)
