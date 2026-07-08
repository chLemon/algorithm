# 题目链接: https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
# 时空复杂度:
# Tags:

class Solution:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)
        for word in strs:
            sorted_s = ''.join(sorted(word))
            d[sorted_s].append(word)
        return list(d.values())
