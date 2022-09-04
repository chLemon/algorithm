package codinginterviews;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No40 {
    /*
    输入整数数组 arr ，
    找出其中最小的 k 个数。
    例如，输入4、5、1、6、2、7、3、8这8个数字，
    则最小的4个数字是1、2、3、4。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }

        //大顶堆的方法
//        Queue<Integer> queue = new PriorityQueue<>((a, b)->(b-a));
//        for (int i : arr) {
//            if (queue.size()<k){
//                queue.offer(i);
//            }else{
//                if (queue.peek()>i){
//                    queue.poll();
//                    queue.offer(i);
//                }
//            }
//        }
//
//        int[] result = new int[queue.size()];
//        int i =0;
//        for (Integer integer : queue) {
//            result[i] = integer;
//            i++;
//        }
//
//        return result;

        //快排的方法
        int lo = 0;
        int hi = arr.length-1;

        partition(arr, lo, hi, k);

        return Arrays.copyOf(arr, k);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void partition(int[] arr, int lo, int hi, int k) {
        int lborder = lo;
        int rborder = hi;
        int x = arr[lo];
        while (lo < hi) {
            while (x <= arr[hi]&&lo<hi) {
                hi--;
            }
            //此时，arr[hi]<x
            swap(arr, lo, hi);

            while (arr[lo] <= x&&lo<hi) {
                lo++;
            }
            swap(arr, hi, lo);
            //此时基准点x位于lo
        }

        //此时，lo=hi
        if (lo == k-1) {
            //刚刚好
            return;
        } else if (lo < k) {
            partition(arr, lo + 1, rborder, k);
        } else {
            //k<lo
            partition(arr, lborder, lo - 1, k);
        }
    }

    @Test
    public void test() {
        getLeastNumbers(new int[]{3,2,1},2);
    }
}
