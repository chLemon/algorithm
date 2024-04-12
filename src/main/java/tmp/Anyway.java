package tmp;

class Anyway {

    public static void main(String[] args) {
        System.out.println(bag());
    }

    /**
     * 本题为典型的 完全背包问题
     * 下面给出一个二维解法，方便理解
     * 通常会用一维解法降低复杂度
     * 而由于本题有30元限制，增加一维来表示当前用掉的金额
     */
    private static int bag() {
        // 为了方便用Int表示所有价格，将所有价格乘2。即鸡的价格为 4 2 1，现有30元。易证不改变答案
        int[] chickenPrices = new int[]{4, 2, 1};

        // 定义 f[i][j][0] ，表示在考虑购买 0-i 种鸡时，购买 j 只鸡可能的方案数
        // 定义 f[i][j][1] ，表示这种情况下花掉的钱

        // 为了计算方便，i,j 添加0行0列
        // 例如：f[1][1][0]表示，只买a种鸡、购买1只的方案数；f[2][1][0]表示，考虑购买a种和b种鸡、购买1只的方案数 
        int[][][] f = new int[4][11][2];

        // 初始化：
        // 考虑购买i种鸡，但是只购买0只的方案数初始化为 1，花费为0
        for (int i = 0; i < 4; i++) {
            f[i][0][0] = 1;
        }
        // 什么种类的鸡都不买，购买j只的方案为0，花费为0

        // 递推公式：
        for (int i = 1; i < 4; i++) {
            int chickenPrice = chickenPrices[i - 1];
            for (int j = 1; j < 11; j++) {
                f[i][j][0] = f[i - 1][j][0];    // 不买第i种鸡时的方案数
                for (int k = 1; k <= j && k * chickenPrice + f[i - 1][j - k][1] < 30; k++) {
                    f[i][j][0] += f[i - 1][j - k][0];
                }
            }
        }
        return f[3][10][0];
    }


}
