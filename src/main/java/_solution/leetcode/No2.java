package _solution.leetcode;

class No2 {

	// Definition for singly-linked list.
	private static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode next = res;
		// 第一个节点特殊处理
		int t = l1.val + l2.val;
		res.val = t % 10;
		int up = t / 10;

		while (l1.next != null || l2.next != null) {
			int i1 = l1.next == null ? 0 : l1.next.val;
			int i2 = l2.next == null ? 0 : l2.next.val;
			next.next = new ListNode((i1 + i2 + up) % 10);
			up = (i1 + i2 + up) / 10;
			if (l1.next != null) {
				l1 = l1.next;
			}
			if (l2.next != null) {
				l2 = l2.next;
			}
			next = next.next;
		}

		if (up > 0) {
			next.next = new ListNode(up);
		}

		return res;
	}

	public static void main(String[] args) {
		No2 no2 = new No2();
		ListNode l1 = new ListNode(9,
				new ListNode(9,
						new ListNode(9,
								new ListNode(9,
										new ListNode(9
												, new ListNode(9,
												new ListNode(9)))))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

		no2.addTwoNumbers(l1, l2);
	}
}
