package sword_to_offer;

import java.util.ArrayList;

class No57_2 {
    /*
    输入一个正整数 target ，
    输出所有和为 target 的连续正整数序列（至少含有两个数）。
    序列内的数字由小到大排列，
    不同序列按照首个数字从小到大排列。
     */
    //如果是用二次方程求解间隔，delta会溢出long
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 1, j = 2;
        int temp = 3;
        while (i <= target / 2) {
            if (temp < target) {
                j++;
                temp += j;
            } else if (temp > target) {
                temp -= i;
                i++;
            } else {
                //答案
                int[] l = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    l[k - i] = k;
                }
                result.add(l);
                temp-=i;
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public void test() {
        //32719~32721
        int[][] ints = findContinuousSequence(9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0]);
            System.out.println(ints[i][ints[i].length - 1]);
            System.out.println("============");
        }
    }
}
