package leetcode;

class No705 {

    class MyHashSet {

        int[] node = new int[1_000_005];

        public MyHashSet() {
        }

        public void add(int key) {
            node[key] = 1;
        }

        public void remove(int key) {
            node[key] = 0;
        }

        public boolean contains(int key) {
            return node[key] == 1;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
