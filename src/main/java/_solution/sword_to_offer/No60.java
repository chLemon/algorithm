package _solution.sword_to_offer;

class No60 {
    /*
    把n个骰子扔在地上，
    所有骰子朝上一面的点数之和为s。
    输入n，打印出s的所有可能的值出现的概率。

    你需要用一个浮点数数组返回答案，
    其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     */
    public double[] twoSum(int n) {
        double base = Math.pow(1 / 6d, n);
        int[] temp = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            temp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {//i个骰子
            //从f[2][]开始
            for (int j = 6 * i; j >= i; j--) {//
                int sum = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 1) {
                        continue;
                    }
                    sum += temp[j - k];
                }
                temp[j] = sum;
            }
            for (int j = 0; j < i; j++) {
                temp[j] = 0;
            }
        }
        double[] result = new double[6 * n - n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp[i + n] * base;
        }
        return result;
    }

    public double sum(double[] doubles) {
        double sum = 0;
        for (double v : doubles) {
            sum += v;
        }
        return sum;
    }

    public void test() {
        twoSum(3);
    }
}
