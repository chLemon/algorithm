package leetcode;

class No941 {

    public static void main(String[] args) {
        No941 no = new No941();
        boolean b = no.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        System.out.println(b);
    }

    // 还可以双指针
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        if (arr[1] <= arr[0] || arr[arr.length - 1] >= arr[arr.length - 2]) return false;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (flag) {
                if (diff >= 0) {
                    return false;
                } else {
                    // do nothing
                }
            } else {
                if (diff > 0) {
                    // do nothing
                } else if (diff == 0) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

}
