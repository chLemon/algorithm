package _solution.sword_to_offer;

class No11 {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，
    我们称之为数组的旋转。
    输入一个递增排序的数组的一个旋转，
    输出旋转数组的最小元素。
    例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

     */

    public int minArray(int[] numbers) {
        /*
        思路：
        遍历O(n)
        有序说明可以到O(logn)
         */
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mi = (start + end) / 2;
            //要和右边的比
            if (numbers[mi] > numbers[end]) {
                start = mi + 1;//没这个+1就会死循环
            } else if (numbers[mi] < numbers[end]) {
                end = mi;
            } else if (numbers[mi] == numbers[end]) {
                end--;
            }
        }
        return numbers[start];
    }

    public void Test() {
/*
测试用例：
递增排序的数组的最小元素

数组：null，有没有重复值（最小元素是否唯一），全重复和有重复，不旋转的原数组
 */
        int[] array = new int[]{2, 2, 2, 0, 1};
        int result = minArray(array);
        System.out.println(result);

    }
}
