package other;

import util.JacksonUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Rabbit {

	List<String> res = new ArrayList<>();
	Stack<int[]> path = new Stack<>();
	int m;
	int n;
	int[][] map;

	public void F(int m, int n, int[][] map) {
		this.m = m;
		this.n = n;
		this.map = map;
		int[] start = new int[] { 0, 0 };
		findPath(start);
	}

	public void findPath(int[] node) {
		if (node[0] == m - 1 && node[1] == n - 1) {
			// 找到了结果
			path.push(node);
			System.out.println(JacksonUtil.writeValueAsString(path));
			path.pop();
			return;
		}
		// 判断当前点的合法性
		if (node[0] < 0 || node[0] >= m || node[1] < 0 || node[1] >= n
				|| map[node[1]][node[0]] == 1) {
			// 不合法
			return;
		}
		path.push(node);

		// 先右
		findPath(new int[] { node[0] + 1, node[1] });
		// 后下
		findPath(new int[] { node[0], node[1] + 1 });
		path.pop();
	}

}
