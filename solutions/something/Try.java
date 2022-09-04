package something;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

public class Try {

	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			mouseRun();
		}
		System.out.println("res平均值为" + res.stream().reduce(Integer::sum).orElse(0) * 1.0 / res.size());
		System.out.println("res最大值为" + res.stream().max(Comparator.comparingInt(o -> o)));
		// 输出 16
	}


	static void mouseRun() {
		int mouse = 1;
		Random r = new Random();
		while (r.nextDouble() < 0.94) {
			mouse++;
		}
		System.out.println(mouse);
		res.add(mouse);
	}
}
