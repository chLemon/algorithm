package _solution.leetcode;

import java.util.Arrays;

class No706 {

    class MyHashMap {

        int[] nodes = new int[1_000_000 + 5];

        public MyHashMap() {
            Arrays.fill(nodes, -1);
        }

        public void put(int key, int value) {
            nodes[key] = value;
        }

        public int get(int key) {
            return nodes[key];
        }

        public void remove(int key) {
            nodes[key] = -1;
        }
    }

}
