# https://leetcode.cn/problems/watering-plants-ii/description/
# O(n) O(1)
# 模拟 相向双指针
class Solution:

    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        count, a, b = 0, 0, len(plants) - 1
        a_remain, b_remain = capacityA, capacityB
        while a < b:
            # a 和 b 分别浇水
            # a浇水
            if a_remain < plants[a]:
                count += 1
                a_remain = capacityA
            a_remain -= plants[a]
            a += 1
            # b浇水
            if b_remain < plants[b]:
                count += 1
                b_remain = capacityB
            b_remain -= plants[b]
            b -= 1
        if a == b and max(a_remain, b_remain) < plants[a]:
            count+=1
        return count
