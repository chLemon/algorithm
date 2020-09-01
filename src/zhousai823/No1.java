package zhousai823;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No1 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n];
        count[rounds[0]-1]++;
        for (int i = 0; i < rounds[0]; i++) {
            count[i]++;
        }
        for (int i = 1; i < rounds.length; i++) {
            addCount(count, rounds[i - 1], rounds[i], n);
        }
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                result.add(i + 1);
            }
        }

        return result;
    }

    private void addCount(int[] count, int start, int end, int n) {
        //前不计入，后计入
        //不涉及到n的情况
        if (end > start) {
            for (int i = start; i < end; i++) {
                count[i]++;
            }
        } else if (end == start) {
            for (int i = 0; i < count.length; i++) {
                count[i]++;
            }
        } else {
            for (int i = start; i < n; i++) {
                count[i]++;
            }
            for (int i = 0; i < end; i++) {
                count[i]++;
            }
        }
    }

    @Test
    public void test() {
        List<Integer> list = mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2});
        System.out.println(list);
    }

}
