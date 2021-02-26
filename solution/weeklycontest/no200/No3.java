package weeklycontest.no200;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No3 {
    /*
    给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。

    一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。

    请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。

    主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
     */
    public int minSwaps(int[][] grid) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            //统计每一行的末尾的0的个数
            //重复的，-1再放进去
            int countZero = 0;
            for (int j = grid[0].length - 1; j > 0; j--) {
                if (grid[i][j] == 0) {
                    countZero++;
                } else {
                    break;
                }
            }
            while (map.containsKey(countZero)) {
                countZero--;
            }
            if (countZero >= 0) {
                map.put(countZero, i);
            }
        }
        //从第一行开始
        int line = 0;
        while (line < grid.length) {
            //需要的0的个数是
            int needZero = grid.length - line - 1;
            Integer lineNumber = map.get(needZero);
            if (lineNumber == null) {
                return -1;
            }
            count += lineNumber - line;
            line++;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue()<lineNumber){
                    map.put(entry.getKey(),entry.getValue()+1);
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        //[[0,0,1],[1,1,0],[1,0,0]]
//        minSwaps(new int[][]{{0,0,1},{1,1,0},{1,0,0}});
        minSwaps(new int[][]{{0,0},{0,1}});
    }
}
