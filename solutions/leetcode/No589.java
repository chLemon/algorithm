package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class No589 {


	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	;


	public List<Integer> preorder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		preorder(root, res);

		return res;
	}

	private void preorder(Node root, List<Integer> res) {
		if (root == null) {
			return;
		}
		// 根
		res.add(root.val);
		// 左右
		if (root.children != null && !root.children.isEmpty()) {
			for (Node child : root.children) {
				preorder(child, res);
			}
		}
	}
	
	// 迭代
	public List<Integer> preorder2(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		preorder(root, res);

		return res;
	}

@Test
	public void test(){
		String a = "";
		swap(a);
		System.out.println(a);
	}
	void swap(String a){
		a = "123";
	}
}
