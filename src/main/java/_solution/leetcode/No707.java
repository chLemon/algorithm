package _solution.leetcode;

class No707 {

    /*
    实现 MyLinkedList 类：

MyLinkedList() 初始化 MyLinkedList 对象。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     */

    public static void main(String[] args) {
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        No707 no = new No707();
        MyLinkedList list = no.new MyLinkedList();
        // [[],[1],[3],[1,2],[1],[0],[0]]
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        // 1 2 3
        int i = list.get(1);
        System.out.println(i);
        list.deleteAtIndex(0);
        int i1 = list.get(0);
        System.out.println(i1);
    }

    class MyLinkedList {

        /*
        单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。

        如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
         */
        class Node {
            int val;
            Node next;

            public Node() {

            }

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node(int val) {
                this.val = val;
            }
        }

        Node head = new Node();
        int size;

        private Node getNode(int index) {
            if (index == -1) {
                return head;
            }
            if (index < 0 || index > size - 1) {
                return null;
            }
            Node res = head;
            for (int i = 0; i < index + 1; i++) {
                res = res.next;
            }
            return res;
        }

        public MyLinkedList() {
        }

        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        public void addAtHead(int val) {
            this.head.next = new Node(val, head.next);
            this.size++;
        }

        public void addAtTail(int val) {
            Node node = getNode(size - 1);
            node.next = new Node(val);
            this.size++;
        }

        // void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
        // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
        // 如果 index 比长度更大，该节点将 不会插入 到链表中。

        public void addAtIndex(int index, int val) {
            Node pre = getNode(index - 1);
            if (pre == null) {
                return;
            }
            pre.next = new Node(val, pre.next);
            this.size++;
        }

        //void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
        public void deleteAtIndex(int index) {
            Node pre = getNode(index - 1);
            if (pre == null || pre.next == null) {
                return;
            }
            Node next = pre.next.next;
            pre.next = next;
            this.size--;
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
