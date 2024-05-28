package _solution.leetcode;

import java.util.PriorityQueue;

class No295 {

    class MedianFinder {

        // 让l多1个
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> right = new PriorityQueue<>();


        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                if (left.size() == 0) {
                    left.offer(num);
                } else if (num > right.peek()) {
                    left.offer(right.poll());
                    right.offer(num);
                } else {
                    left.offer(num);
                }
            } else {
                if (num < left.peek()) {
                    right.offer(left.poll());
                    left.offer(num);
                } else {
                    right.offer(num);
                }
            }

        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            }
            return left.peek() + 0.0;
        }
    }

}
