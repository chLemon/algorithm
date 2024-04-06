package leetcode;

class No504 {

	/**
	 * 可以优化的地方：
	 * 1. do... while... 可以不写前面的 ==0判断
	 * 2. 负号可以直接append到后面，reverse完就去前面了
	 * @param num
	 * @return
	 */
	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		}
		boolean neg = false;
		if (num < 0) {
			neg = true;
			num = -num;
		}
		StringBuilder builder = new StringBuilder();
		while (num != 0) {
			builder.append(num % 7);
			num /= 7;
		}

		if (neg) {
			return "-" + builder.reverse().toString();
		} else {
			return builder.reverse().toString();
		}
	}


	public void test() {
		String s1 = convertToBase7(100);
		System.out.println(s1);

		String s2 = convertToBase7(-7);
		System.out.println(s2);

		String s3 = convertToBase7(0);
		System.out.println(s3);
	}
}
