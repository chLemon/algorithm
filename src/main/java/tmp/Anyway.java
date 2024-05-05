package tmp;

import java.util.Arrays;
import java.util.HashMap;

public class Anyway {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 0, 5}, 1)));
    }

    public static int[] solution(int[] costs, int coins) {
        // write code here
        int[] copy = Arrays.copyOf(costs, costs.length);    // O(n)
        Arrays.sort(copy);          // O(n*lgn)
        HashMap<Integer, Integer> hm = new HashMap<>();
        int cost = 0;
        int count = 0;
        // 从小到大的贪心思路
        for (int i = 0; i < costs.length; i++) {    // O(n)
            if (copy[i] + cost <= coins) {
                count++;
                cost = cost + copy[i];

                // hm 值出现的次数
                hm.merge(copy[i], 1, Integer::sum);
            } else {
                break;
            }
        }


        // 从 copy[i] 还原成 costs的顺序值

        int[] res = new int[count];
        // 个数-1
        int index = count - 1;
        // 如果hm里出现过这个数，并且仍有
        for (int i = costs.length - 1; i >= 0; i--) {   // O(n)
            if (hm.containsKey(costs[i]) && hm.get(costs[i]) > 0) {
                res[index] = costs[i];
                hm.merge(costs[i], -1, Integer::sum);
                index--;
            }
        }
        return res;
    }


}
