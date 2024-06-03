package _solution.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class No380 {

    public static void main(String[] args) {
        RandomizedSet set = new No380().new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        set.getRandom();
    }

    class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2 * (int) 1e5 + 5];
        // [0, idx)
        int idx = 0;
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            arr[idx++] = val;
            map.put(val, idx - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int oldIndex = map.get(val);
            arr[oldIndex] = arr[--idx];
            map.put(arr[oldIndex], oldIndex);
            map.remove(val);
            return true;
        }

        private void swap(int a, int b) {
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        public int getRandom() {
            return arr[random.nextInt(idx)];
        }
    }

}
