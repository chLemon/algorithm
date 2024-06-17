package _solution.leetcode;

import java.util.Arrays;

class No135 {

    public static void main(String[] args) {
        No135 no = new No135();
        int candy = no.candy2(new int[]{1, 0, 2});
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // left -> right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // right -> left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }


    public int candy2(int[] ratings) {
        int n = ratings.length;
        /*
        12353210
        对于 1235 部分，只需要分 1234 糖果即可 -> 升序序列
        对于 3210 部分，只需要分 4321 -> 降序序列
        但是降序序列可能很长，53210 会导致 5所在的位置 54321 要比之前多1个（可以理解将原本在升序序列里的人，加入到降序序列里）
        */


        int res = 1;    // 第一个孩子直接分配。
        int incPre = 1; // 升序序列时，前一个同学的糖果数
        // 下面2个值主要为降序序列服务
        int inc = 1; // 上一个升序序列出现的最大值
        int dec = 0; // 记录一下降序序列的长度，也是降序序列的最大值；注意这里是0

        for (int i = 1; i < n; i++) {
            // 从第二个孩子开始
            if (ratings[i] >= ratings[i - 1]) {
                // 升序序列中
                incPre = ratings[i] == ratings[i - 1] ? 1 : incPre + 1; // 相等时，直接赋0即可
                inc = incPre;   // 记录最大值，这个值只在降序序列中使用
                res += incPre;  // 加上当前孩子的糖果
                dec = 0;    // 更新降序序列长度为0
            } else {
                // 降序序列
                // 开始降序序列，先直接将降序序列长度 + 1
                dec++;
                if (inc == dec) dec++;   // 将inc最大值加入到降序序列中
                res += dec; // 给降序序列所有孩子发1个糖果
                incPre = 1; // 由于最后一个数也可以是下一个升序序列的开头
            }
        }
        return res;
    }

    public int candy3(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
