package codinginterviews;

import codinginterviews.domain.No36.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
public class No36 {
    /*
    输入一棵二叉搜索树，
    将该二叉搜索树转换成一个排序的循环双向链表。
    要求不能创建任何新的节点，
    只能调整树中节点指针的指向。
     */
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null){return null;}
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        inOrder(node.right);
    }
}

