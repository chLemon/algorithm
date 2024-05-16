package _solution.leetcode;

class No4 {

	public static void main(String[] args) {
		System.out.println(new No4().findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}
		// n1 < n2
		int m = nums1.length;
		int n = nums2.length;
		int left = 0;
		int right = m;
		int INF = 0x3f3f3f;
		while (left <= right) {
			int i = left + (right - left) / 2;
			int j = (m + n) / 2 - i;
			int a = i - 1 >= 0 ? nums1[i - 1] : -INF;
			int b = i < m ? nums1[i] : INF;
			int c = j - 1 >= 0 ? nums2[j - 1] : -INF;
			int d = j < n ? nums2[j] : INF;


			int leftMax = Math.max(a, c);
			int rightMin = Math.min(b, d);

			if (leftMax <= rightMin) {
				// 答案
				if (((m + n) & 1) == 1) {
					// 奇数
					return rightMin;
				} else {
					return (leftMax + rightMin) / 2.0;
				}
			} else {
				if (a > c) {
					// i <-
					right = i;
				} else if (a < c) {
					left = i + 1;
				} else {
					if (b < d) {
						// i ->
						left = i + 1;
					} else {
						right = i;
					}
				}
			}
		}
		return 0;
	}

}
