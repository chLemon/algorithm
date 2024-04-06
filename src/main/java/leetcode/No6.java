package leetcode;

class No6 {

	/**
	 * 数据量也不大，最简单的当然是直接按照题目意思排一下
	 * 时间复杂度 2O(n)
	 * 空间复杂度 O(n^2)
	 * <p>
	 * 映射去做空间 O(1)，时间 O(n)
	 */

	// 直接模拟
	public String convert(String s, int numRows) {
		if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		int colNum = (s.length() / (numRows + numRows - 2) + 1) * 2;
		// 注意一下等于2的情况

		char[][] tem = new char[colNum][numRows];

		boolean down = true;
		int p = 0, q = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			tem[p][q] = c;

			// 需要改变方向的2种情况：向下触底
			if (down && q == numRows - 1) {
				if (numRows == 2) {
					p++;
					q = 0;
				} else {
					p++;
					q--;
					down = false;
				}
			} else if (!down && q == 1) {
				// 向上触顶
				p++;
				q--;
				down = true;
			} else {
				if (down) {
					q++;
				} else {
					q--;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tem[0].length; i++) {
			for (int j = 0; j < tem.length; j++) {
				char c = tem[j][i];
				if (c != 0) {
					builder.append(c);
				}
			}
		}
		return builder.toString();
	}


	public void test() {
		String s = convert("PAYPALISHIRING", 3);
		System.out.println(s);
	}

}
