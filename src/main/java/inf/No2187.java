package inf;

public class No2187 {

    public static void main(String[] args) {
        System.out.println(new No2187().minimumTime(new int[]{39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25}, 4187));
    }

    public long minimumTime(int[] time, int totalTrips) {
        long min = 1;
        long max = Long.MAX_VALUE;

        while (min < max) {
            long mid = min + (max - min) / 2;

            // mid是可能的答案，如果需要消耗mid的时间，那么完成的旅途数量是：
            long trips = 0;
            for (int t : time) {
                trips += mid / t;
                if (trips >= totalTrips) {
                    break;
                }
            }

            if (trips < totalTrips) {
                // 需要放大时间
                min = mid + 1;
            } else {
                // 缩小时间
                max = mid;
            }
        }
        // min = max, min - 1 一定不满足
        return min;
    }

}
