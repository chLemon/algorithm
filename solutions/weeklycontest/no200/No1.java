package weeklycontest.no200;

public class No1 {
    /*
    给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。

    如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。

    0 <= i < j < k < arr.length
    |arr[i] - arr[j]| <= a
    |arr[j] - arr[k]| <= b
    |arr[i] - arr[k]| <= c
    其中 |x| 表示 x 的绝对值。

    返回 好三元组的数量 。
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int first = arr[i] - arr[j];
                    if (Math.abs(first) <= a) {
                        int second = arr[j] - arr[k];
                        if (Math.abs(second) <= b) {
                            int third = arr[i] - arr[k];
                            if (Math.abs(third) <= c){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
