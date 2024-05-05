package _solution.programmercarl;

class No27 {

    public static void main(String[] args) {
        No27 no = new No27();
        no.removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    public int removeElement(int[] nums, int val) {
        if (val > 50) return nums.length;
        int replace = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[replace++] = nums[i];
            }
        }
        return replace;
    }

}
