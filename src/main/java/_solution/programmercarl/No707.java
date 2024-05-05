package _solution.programmercarl;

class No707 {

    public static void main(String[] args) {
        MyLinkedList list = new No707().new MyLinkedList();
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtTail(5);
        list.get(5);
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {

        Node pre = new Node(-1);
        int size = 0;

        public MyLinkedList() {
        }

        private Node node(int index) {
            if (index < -1 || index >= size) return null;
            Node cur = pre;
            for (int i = 0; i < index + 1; i++) {
                if (cur == null) return null;
                cur = cur.next;
            }
            return cur;
        }

        public int get(int index) {
            Node node = node(index);
            return node == null ? -1 : node.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            Node node = node(index - 1);
            if (node == null) return;
            Node next = node.next;
            node.next = new Node(val, next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) return;
            Node node = node(index - 1);
            if (node == null) return;
            node.next = node.next.next;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}
