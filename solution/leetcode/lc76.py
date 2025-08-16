# 题目链接: https://leetcode.cn/problems/minimum-window-substring/description/
# 时空复杂度: O(|∑|m + n) O(|∑|) 优化后时间可以到 O(m + n)
# Tags: 同向双指针，变量维护小于的个数

from collections import Counter


class Solution:
    def sol1(self, s: str, t: str) -> str:
        cnt_t = Counter(t)
        cnt_sub = Counter()

        left = 0
        ans_l, ans_r = -1, len(s)
        for right, x in enumerate(s):
            cnt_sub[x] += 1
            while cnt_sub >= cnt_t:
                if ans_r - ans_l > right - left:
                    ans_l, ans_r = left, right
                cnt_sub[s[left]] -= 1
                left += 1
        return "" if ans_l < 0 else s[ans_l : ans_r + 1]

    def sol2(self, s: str, t: str) -> str:
        cnt_t = Counter(t)
        less_than_t = len(cnt_t)
        cnt_sub = Counter()

        left = 0
        ans_l, ans_r = -1, len(s)
        for right, x in enumerate(s):
            cnt_sub[x] += 1
            if cnt_sub[x] == cnt_t[x]:
                less_than_t -= 1  # 从小到相等
            while less_than_t <= 0:
                if ans_r - ans_l > right - left:
                    ans_l, ans_r = left, right
                y = s[left]
                if cnt_sub[y] == cnt_t[y]:
                    less_than_t += 1  # 要从相等变小
                cnt_sub[y] -= 1
                left += 1
        return "" if ans_l < 0 else s[ans_l : ans_r + 1]

    def sol3(self, s: str, t: str) -> str:
        # 2个 Counter 可以合并为 1个
        # cnt = cnt_t - cnt_s
        cnt = Counter(t)
        less_than_t = len(cnt)

        left = 0
        ans_l, ans_r = -1, len(s)
        for right, x in enumerate(s):
            cnt[x] -= 1 # 加入一个新的字母
            if cnt[x] == 0:
                less_than_t -= 1  # 从小到相等
            while less_than_t <= 0:
                if ans_r - ans_l > right - left:
                    ans_l, ans_r = left, right
                y = s[left]
                if cnt[y] == 0:
                    less_than_t += 1  # 要从相等变小
                cnt[y] += 1
                left += 1
        return "" if ans_l < 0 else s[ans_l : ans_r + 1]

    def minWindow(self, s: str, t: str) -> str:
        return self.sol3(s, t)
