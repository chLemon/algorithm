# 题目链接: https://leetcode.cn/problems/count-number-of-texts/
# 时空复杂度:
# Tags:

MOD = 1_000_000_007

f = [1, 1, 2, 4]
g = [1, 1, 2, 4]

for i in range(3, 10**5 + 1):
    f.append((f[-1] + f[-2] + f[-3]) % MOD)
    g.append((g[-1] + g[-2] + g[-3] + g[-4]) % MOD)


class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        ans = 1

        count = 0
        for i, x in enumerate(pressedKeys):
            count += 1
            if i == len(pressedKeys) - 1 or x != pressedKeys[i + 1]:
                ans = ans * (g[count] if x in "79" else f[count]) % MOD
                count = 0
        return ans
