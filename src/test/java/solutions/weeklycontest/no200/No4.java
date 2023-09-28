package solutions.weeklycontest.no200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No4 {
    //最后没通过，有点问题
    /*
    你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。

    一条 合法路径 定义如下：

    选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
    从左到右遍历当前数组。
    如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
    得分定义为合法路径中不同数字的和。

    请你返回所有可能合法路径中的最大得分。

    由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
     */
    int[] nums1;
    int[] nums2;

    public int maxSum(int[] nums1, int[] nums2) {
        Long sum = 0L;
        HashMap<Integer, Integer> commonsN1 = new HashMap<>();
        HashMap<Integer, Integer> commonsN2 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> commons = new ArrayList<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                commonsN2.put(nums2[i], i);
                commons.add(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (commons.contains(nums1[i])) {
                commonsN1.put(nums1[i], i);
            }
        }

        if (commons.isEmpty()) {
            long n1Sum = 0L;
            for (int i = 0; i < nums1.length; i++) {
                n1Sum += nums1[i];
            }
            long n2Sum = 0L;
            for (int i = 0; i < nums2.length; i++) {
                n2Sum += nums2[i];
            }

            sum = Math.max(n1Sum, n2Sum);

            return (int) (sum % (1e9 + 7));
        }

        //贪心
        Integer firstValue = commons.get(0);
        Integer preN1Index = commonsN1.get(firstValue);
        Integer preN2Index = commonsN2.get(firstValue);
        Long n1FirstSum = 0L;
        for (int i = 0; i < preN1Index; i++) {
            n1FirstSum += nums1[i];
        }
        Long n2FirstSum = 0L;
        for (int i = 0; i < preN2Index; i++) {
            n2FirstSum += nums2[i];
        }
        long maxFirst = Math.max(n1FirstSum, n2FirstSum);
        sum += maxFirst;

        for (int i = 1; i < commons.size(); i++) {
            Integer value = commons.get(i);
            Integer n1Index = commonsN1.get(value);
            Integer n2Index = commonsN2.get(value);

            if (n1Index - preN1Index > n2Index - preN2Index) {
                //n1的数量多
                for (int j = preN1Index; j < n1Index; j++) {
                    sum += nums1[j];
                }
            } else {
                //n2的数量多 一样的放哪边都可以
                for (int j = preN2Index; j < n2Index; j++) {
                    sum += nums2[j];
                }
            }
            preN1Index = n1Index;
            preN2Index = n2Index;
        }

        //此时最后一个节点和最后一点节点没有+
        int lastValue = commons.get(commons.size() - 1);
        sum += lastValue;
        //最后一点
        int lastValueN1Index = commonsN1.get(lastValue);
        int lastValueN2Index = commonsN2.get(lastValue);
        Long n1LastSum = 0L;
        for (int i = lastValueN1Index + 1; i < nums1.length; i++) {
            n1LastSum += nums1[i];
        }
        Long n2LastSum = 0L;
        for (int i = lastValueN2Index + 1; i < nums2.length; i++) {
            n2LastSum += nums2[i];
        }
        long max = Math.max(n1LastSum, n2LastSum);
        sum += max;

        return (int) (sum % (1e9 + 7));

    }

    @Test
    public void test() {
        maxSum(new int[]{5, 7, 14, 15, 18, 20}, new int[]{1, 7, 11});
    }
}
