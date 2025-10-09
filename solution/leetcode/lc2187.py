# 题目链接: https://leetcode.cn/problems/minimum-time-to-complete-trips/description/
# 时空复杂度: O(n logU) U 为 least * totalTrips + 1 - least + 1，O(1)
# Tags: 二分答案


class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        least = min(time)
        # 答案在 least 到 least * totalTrips 之间
        l, r = least - 1, least * totalTrips + 1
        # l 恒为 False，r 恒为 True
        while l + 1 < r:
            m = (l + r) // 2
            # m 时间下，可以完成的旅途数量
            if sum(m // t for t in time) >= totalTrips:
                # 可以完成，时间可以再少一点
                r = m
            else:
                l = m
        return r
