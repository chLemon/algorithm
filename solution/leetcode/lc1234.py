# 题目链接: https://leetcode.cn/problems/replace-the-substring-for-balanced-string/description/
# 时空复杂度: O(4n) O(4)
# Tags: 同向双指针 TODO 重写一下

from collections import Counter


class Solution:
    def balancedString(self, s: str) -> int:
        m = len(s) // 4
        cnt = Counter(s)
        if len(cnt) == 4 and min(cnt.values()) == m:
            return 0

        left = 0
        ans = len(s)
        for right, x in enumerate(s):
            cnt[x] -= 1
            while max(cnt.values()) <= m:
                # 越短越合法（求最长）的滑窗一般写外面，越长越合法（求最短）的滑窗一般写里面
                ans = min(ans, right - left + 1)
                cnt[s[left]] += 1
                left += 1
        return ans
