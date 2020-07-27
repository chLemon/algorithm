package offer;

import org.junit.Test;

public class No40 {
    /*
    输入整数数组 arr ，
    找出其中最小的 k 个数。
    例如，输入4、5、1、6、2、7、3、8这8个数字，
    则最小的4个数字是1、2、3、4。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
        }
        for (int i : arr) {
            for (int j = 0; j < k; j++) {
                if (i < result[j]) {
                    for (int l = k - 1; l > j; l--) {
                        result[l] = result[l - 1];
                    }
                    result[j] = i;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] ints = getLeastNumbers(new int[]{1, 2, 3, 4, 5, 6}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
