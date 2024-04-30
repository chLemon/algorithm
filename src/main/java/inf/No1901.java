package inf;

class No1901 {

    public static void main(String[] args) {
        new No1901().findPeakGrid(new int[][]{{10, 20, 40, 50, 60, 70}, {1, 4, 2, 3, 500, 80}});
    }

    public int[] findPeakGrid(int[][] mat) {
        // 找到每一行的最大值，然后缩小行的范围
        // 对于每一行，标记某个峰值及其的下面是蓝色，上面是红色
        // nums.length - 1是蓝色
        int left = 0;
        int right = mat.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int maxIndex = findMaxIndex(mat[mid]);
            if (mat[mid][maxIndex] <= mat[mid + 1][maxIndex]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return new int[]{left, findMaxIndex(mat[left])};
    }

    private int findMaxIndex(int[] nums) {
        int index = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}
