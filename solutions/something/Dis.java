package something;

import java.math.BigDecimal;
import java.net.URLDecoder;

public class Dis {

	public static void main(String[] args) {
		double p = 0.94;
		double res = 1;
		for (int i = 1; i <= 10000_0000; i++) {
			if (i % 10000 == 0) {
				System.out.println("#" + i / 10000);
			}
			double px = Math.pow(p, i) * 0.06;
			res = res + (px * (i + 1));
		}
		System.out.println(res);
		// 17.6066666...
	}
}
