package _solution.leetcode;

import java.util.Arrays;
import java.util.Random;

public class No912 {

    int[] tmp;
    Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No912().sortArray(new int[]{5, 2, 3, 1})));
    }

    /* ------------ 快速排序，堆排序，归并排序 ------------- */
    public int[] sortArray(int[] nums) {
        // 归并排序
//        tmp = new int[nums.length];
//        mergeSort(nums, 0, nums.length);
        // 快速排序
//        quickSort(nums, 0, nums.length);
        // 堆排序
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        // 建堆，大顶堆
        heapify(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            // 最大值归位
            swap(nums, i, 0);
            // 对新放在首位的值进行下滤
            siftDown(nums, 0, i);
        }
    }

    private void heapify(int[] nums) {
        // 0 12 3456 父节点 i - 1 / 2; 
        // 自下而上的下滤
        // 最后一个元素的父节点是  n - 1 - 1 / 2 = n / 2 - 1，则 n / 2 往后都没有父节点
        for (int i = nums.length / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
    }

    private void siftDown(int[] nums, int i, int end) {
        // 大顶堆
        // 子节点 *2 + 1 , *2 + 2
        while (i * 2 + 1 < end || i * 2 + 2 < end) {
            // 有子节点，需要下滤
            // 当子节点的最大值，小于当前值，需要交换
            int child1 = i * 2 + 1;
            int child2 = i * 2 + 2;
            int max = child2 >= end ? nums[child1] :
                    Math.max(nums[child1], nums[child2]);
            if (nums[i] >= max) {
                break;
            }
            // 和 有效，且 较大的值交换
            int c = child2 >= end ? child1
                    : (nums[child1] < nums[child2] ? child2 : child1);
            swap(nums, i, c);
            // 继续考察
            i = c;
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l + 1 >= r) return;
        int mid = l + r >>> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid, r);
        if (nums[mid - 1] <= nums[mid]) return;
        for (int i = l; i < r; i++) {
            tmp[i] = nums[i];
        }
        int i = l;
        int j = mid;
        for (int k = l; k < r; k++) {
            if (i >= mid) break;
            if (j >= r) {
                nums[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
            }
        }
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l + 1 >= r) return;
        int ran = random.nextInt(r - l);
        swap(nums, l, l + ran);
        int x = nums[l];
        int m = l + 1;
        for (int k = l + 1; k < r; k++) {
            if (nums[k] < x) {
                swap(nums, m++, k);
            }
        }
        swap(nums, l, m - 1);   // 轴点就位
        quickSort(nums, l, m - 1);
        quickSort(nums, m, r);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


}
