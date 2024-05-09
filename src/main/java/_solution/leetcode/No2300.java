package _solution.leetcode;

import java.util.Arrays;

class No2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long target = success / spell;
            if (success % spell != 0) {
                target++;
            }
            int index = binarySearch(potions, target);
            res[i] = potions.length - index;
        }
        return res;
    }

    // 第一个或者应该插入的位置
    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
