package something;

import java.math.BigDecimal;
import java.net.URLDecoder;

public class Dis {

	public static void main(String[] args) {
		BigDecimal p = new BigDecimal("0.94");
		BigDecimal res = new BigDecimal("1");
		for (int i = 1; i <= 100000000; i++) {
			BigDecimal px = p.pow(i).multiply(new BigDecimal("0.06"));
			res = res.add(px.multiply(new BigDecimal(i + 1)));
		}
		System.out.println(res);
	}
}
