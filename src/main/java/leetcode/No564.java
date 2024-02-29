package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No564 {

	public void test() {
		String s = nearestPalindromic("100");
		System.out.println(s);
	}


	public String nearestPalindromic(String n) {
		long selfNumber = Long.parseLong(n), ans = -1;
		List<Long> candidates = getCandidates(n);
		// 每一个看谁是最近的
		for (long candidate : candidates) {
			// 自己不行
			if (candidate != selfNumber) {
				// ans还没定 || 候选的更近 || 一样近但是更小
				if (ans == -1 ||
						Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
						Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
					ans = candidate;
				}
			}
		}
		return Long.toString(ans);
	}

	public List<Long> getCandidates(String n) {
		int len = n.length();
		// 直接加入 100000...0001 和 999...999
		List<Long> candidates = new ArrayList<Long>() {{
			add((long) Math.pow(10, len - 1) - 1);
			add((long) Math.pow(10, len) + 1);
		}};

		// 自己的前半段，这里用的是  (len + 1)/2    ：奇数：包括中间，偶数前半段
		long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));


		for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
			// -1 自己 +1
			StringBuffer sb = new StringBuffer();
			String prefix = String.valueOf(i);
			sb.append(prefix);

			StringBuffer suffix = new StringBuffer(prefix).reverse();
			// 偶数就取全部，奇数取去掉第一个的
			sb.append(suffix.substring(len & 1));
			String candidate = sb.toString();
			candidates.add(Long.parseLong(candidate));
		}
		return candidates;
	}
}
