package solutions.weeklycontest.no200;

import org.junit.Test;

public class No2 {
    /*
    给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。

    每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。
    比较 arr[0] 与 arr[1] 的大小，
    较大的整数将会取得这一回合的胜利并保留在位置 0 ，
    较小的整数移至数组的末尾。
    当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。

    返回赢得比赛的整数。

    题目数据 保证 游戏存在赢家。
     */
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int l = 0;

        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                //max打输了
                max = arr[i];
                l = 1;
            }else{
                //max赢了
                l++;
            }
            if (l==k){
                break;
            }
        }
        return max;
    }
    @Test
    public void test(){
        int winner = getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2);
        System.out.println(winner);
    }
}
