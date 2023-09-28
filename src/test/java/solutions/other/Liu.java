package solutions.other;

public class Liu {

	public static void main(String[] args) {
		Rabbit rabbit = new Rabbit();
		int[][] s = new int[][] {
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 }
		};
		rabbit.F(5, 5, s);
	}

}
