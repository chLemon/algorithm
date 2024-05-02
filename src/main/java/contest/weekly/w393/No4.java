package contest.weekly.w393;

import java.util.Arrays;

class No4 {

    public static void main(String[] args) {
        No4 no = new No4();
        System.out.println(no.minimumValueSum(new int[]{1, 2, 3, 4},
                new int[]{2}));
//{2,3,5,7,7,7,5}
//{0,7,5}
//{1,2,3,4}
//{2}
    }

    int minValue = Integer.MAX_VALUE;
    int[] res;

    public int minimumValueSum(int[] nums, int[] andValues) {
        res = new int[andValues.length];

        dfs(-1, nums, 0, andValues, 0);
        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    private void dfs(int preSum, int[] nums, int numStart, int[] andValues, int andLayer) {
        if (andLayer == andValues.length) {
            if (numStart != nums.length) {
                return;
            }
            // 已经处理完成，找到了一个答案
            minValue = Math.min(minValue, Arrays.stream(res).sum());
            return;
        }
        // 开始处理 andLayer 层
        int andValue = andValues[andLayer];

        while (numStart < nums.length) {
            numStart = findNext(preSum, nums, numStart, andValue);
            if (numStart == -1) {
                // 非法
                return;
            }
            if (nums.length - numStart < andValues.length - andLayer - 1) {
                return;
            }

            preSum = andValue;
            // 如果找到了一个还可以的，开始下一层
            res[andLayer] = nums[numStart - 1];
            dfs(-1, nums, numStart, andValues, andLayer + 1);
            // 有可能是合法 或者 非法return上来的，numStart继续后移，找有没有符合的
        }
    }

    private int findNext(int preSum, int[] nums, int numStart, int andValue) {
        // numStart还没有加入preSum
        preSum &= nums[numStart++];
        while (numStart < nums.length && preSum != andValue) {
            preSum &= nums[numStart++];
        }
        return preSum == andValue ? numStart : -1;
    }
}
