package _solution.contest.biweekly.w131;

import java.util.ArrayList;
import java.util.List;

public class No2 {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indexes.add(i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i] - 1;
            res[i] = index >= indexes.size() ? -1 : indexes.get(index);
        }
        return res;
    }

}
