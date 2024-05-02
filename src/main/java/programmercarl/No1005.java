package programmercarl;

import java.util.Arrays;

class No1005 {

    public static void main(String[] args) {
        No1005 no = new No1005();
        System.out.println(no.largestSumAfterKNegations(new int[]{4, -5, 4, -5, 9, 4, 5}, 1));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 根据绝对值排序写起来更方便

        // 分类讨论
        // 如果数组里有负数，将负数变为正数；如果有多余的k，则消耗在绝对值最小的数上（原0，负，正均可能）
        // 否则，则消耗在绝对值最小的数上
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] >= 0) {
                break;
            }
            nums[i] = -nums[i];
            k--;
        }
        if (k == 0) {
            return Arrays.stream(nums).sum();
        }
        // 仍有k，nums全部非负，i处为0点附近
        if ((k & 1) == 1) {
            int minIndex;
            if (i == nums.length) {
                minIndex = i - 1;
            } else if (i == 0) {
                minIndex = i;
            } else {
                minIndex = nums[i] > nums[i - 1] ? i - 1 : i;
            }
            nums[minIndex] = -nums[minIndex];
        }
        return Arrays.stream(nums).sum();
    }

}
