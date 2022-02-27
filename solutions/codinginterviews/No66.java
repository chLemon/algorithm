package codinginterviews;

public class No66 {
    /*
    给定一个数组 A[0,1,…,n-1]，
    请构建一个数组 B[0,1,…,n-1]，
    其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
    不能使用除法。
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            b[i] = b[i] * temp;
        }
        return b;
    }
}
