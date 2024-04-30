package inf;

import java.util.Arrays;

class No2517 {

    public static void main(String[] args) {
        System.out.println(new No2517().maximumTastiness(new int[]{1, 1, 1, 1, 1}, 5));
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        // 二分结果
        int min = 0;
        // 答案可能的最大值
        long dis = price[0] + price[price.length - 1];
        int max = (int) (dis / (k - 1)) + 1;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, price, k)) {
                // 如果mid有结果，考虑放大
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        // 循环不变量：min-1 true, max false
        // 不变性：min - 1 一定是满足的; max一定不满足
        return min - 1;
    }

    private boolean check(int mid, int[] price, int k) {
        int x0 = price[0];
        k--;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - x0 >= mid) {
                x0 = price[i];
                k--;
                if (k <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
