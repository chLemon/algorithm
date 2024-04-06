package leetcode;

import java.util.Arrays;

class No135 {

    public static void main(String[] args) {
        No135 no = new No135();
        int candy = no.candy(new int[]{1, 3, 4, 5, 2});
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

}
