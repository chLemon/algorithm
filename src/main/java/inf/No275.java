package inf;

public class No275 {

    public int hIndex(int[] citations) {
        // 也可以对答案二分
        // 对数字二分
        int left = 0;
        int right = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left = right, citation[right - 1] 一定不符合
        return citations.length - right;
    }

}
