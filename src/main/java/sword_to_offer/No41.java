package sword_to_offer;

import java.util.PriorityQueue;
import java.util.Queue;

class No41 {
    /*
    如何得到一个数据流中的中位数？
    如果从数据流中读出奇数个数值，
    那么中位数就是所有数值排序之后位于中间的数值。
    如果从数据流中读出偶数个数值，
    那么中位数就是所有数值排序之后中间两个数的平均值。
     */

    class MedianFinder {
        //一个大顶堆，一个小顶堆，各装一半

        //小顶堆里放大的一半，大顶堆里放小的一半
        Queue<Integer> bigHeap = new PriorityQueue<>((a,b)->(b-a));
        Queue<Integer> smallHeap = new PriorityQueue<>();
        boolean odd = false;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (odd){
                smallHeap.offer(num);
                bigHeap.offer(smallHeap.poll());
            }else {
                bigHeap.offer(num);
                smallHeap.offer(bigHeap.poll());
            }

            odd = !odd;
            //奇数的时候小顶堆多一个
        }

        public double findMedian() {
            if (odd) {
                return smallHeap.peek();
            } else {
                return (bigHeap.peek() + smallHeap.peek()) / 2.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */














    /*
    例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
