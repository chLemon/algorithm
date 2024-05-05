package _solution.contest.biweekly.w128;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class No2 {

    public static void main(String[] args) {
        No2 no = new No2();
        System.out.println(no.minRectanglesToCoverPoints(new int[][]{
                {2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}
        }, 1));
        System.out.println(no.minRectanglesToCoverPoints(new int[][]{
                {0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}
        }, 2));
        System.out.println(no.minRectanglesToCoverPoints(new int[][]{
                {2, 3}, {1, 2}
        }, 0));
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Set<Integer> xs = new TreeSet<>();
        for (int[] point : points) {
            xs.add(point[0]);
        }

        List<Integer> ps = new ArrayList<>(xs);

        int count = 0;
        int nextBound = -1;
        for (int i = 0; i < ps.size(); i++) {
            if (nextBound < ps.get(i)) {
                count++;
                nextBound = ps.get(i) + w;
            }
        }

        return count;
    }

}
