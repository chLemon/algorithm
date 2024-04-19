package inf;

public class No875 {

    public int minEatingSpeed(int[] piles, int h) {
        // 珂珂可以选择的速度是 [1, max_pile]
        int max = piles[0];
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = sum + 1;

        while (left < right) {
            int k = left + (right - left) / 2;
            // k的速度能不能吃完，可以，则放大，不行，则缩小
            // 用sum做一个快速判断，真实耗时 >= ceil (sum / k) 
            if (sum / k > h) {
                // h < sum/k <= 真实耗时，需要加快速度
                left = k + 1;
            } else {
                // 计算真实速度
                int cost = 0;
                for (int pile : piles) {
                    cost += (pile - 1) / k + 1;
                }
                if (cost > h) {
                    left = k + 1;
                } else {
                    right = k;
                }
            }
        }
        // left = right, 取left - 1时，时间不够，right刚刚够
        return left;
    }

}
