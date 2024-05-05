package _solution.leetcode;

class No4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 先用二分法的思路：
		/*
		 一个长度为m, 一个位n, 总长度 m + n
		 奇数，中位数是第m+n/2 +1 个
		 偶数，中位数是 m+n/2 与 m+n/2 +1 的平均数
		 记为k
		 找到第k小的数
		 */
		int k = (nums1.length + nums2.length) / 2;
		int base1 = 0, base2 = 0;
		while (k > 1) {
			int index1 = base1 + k / 2 - 1;
			int i = index1 <= nums1.length ? nums1[index1] : Integer.MAX_VALUE;
			int index2 = base2 + k / 2 - 1;
			int j = index1 <= nums2.length ? nums2[index2] : Integer.MAX_VALUE;
			if (i <= j) {
				// num1里前k/2个数都可以抛弃
				base1 = base1 + k / 2;
			} else {
				base2 = base2 + k / 2;
			}
			k -= k / 2;
		}
		if (((nums1.length + nums2.length) & 1) == 1) {
			// 奇数
			if (nums1[base1] < nums2[base2]) {
				return Math.max(nums2[base2], base1 + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[base1 + 1]);
			} else if (nums1[base1] == nums2[base2]) {
				return nums1[base1];
			} else {
				return Math.max(nums1[base2], base1 + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[base1 + 1]);
			}
		} else {
			// 偶数
			if (nums1[base1] < nums2[base2]) {
				return (nums1[base1] + Math.min((base1 + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[base1 + 1]), nums2[base2])) / 2.0;
			} else if (nums1[base1] == nums2[base2]) {
				return nums1[base1];
			} else {
				return (nums2[base1] + Math.min((base2 + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[base2 + 1]), nums1[base1])) / 2.0;
			}
		}

	}

}
