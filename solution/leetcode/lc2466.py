# 题目链接: https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
# 时空复杂度:
# Tags:

MOD = int(10e9 + 7)

class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        f = [1] + [0] * high

        for i in range(1, high + 1):
            f[i] = ((f[i - one] if i - one > 0 else 10) + (f[i - zero] if i - zero > 0 else 1)) % MOD

        ans = 0
        for i in range(low, high+1):
            ans = (ans + f[i]) % MOD
        return ans

