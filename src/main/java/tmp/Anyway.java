package tmp;

class Anyway {

    static int count = 0;
    static int[] dir = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(cal(0, 9));  // 0
        System.out.println(cal(0, 1));  // 9
        System.out.println(cal(0, 5));  // 1
    }

    private static int cal(int catNum, int dogNum) {
        count = 0;
        /*
        3 * 3矩阵非常小，可以直接回溯法解决。
        当矩阵变大，可以考虑 记忆化搜索 或者 动态规划
         */
        int[][] matrix = new int[3][3];
        dfs(matrix, 0, catNum, dogNum);
        return count;
    }

    private static void dfs(int[][] matrix, int position, int catNum, int dogNum) {
        // 适当剪枝
        if (9 - position < catNum + dogNum) {
            return;
        }

        if (position >= 9) {
            // 所有格子已放过
            if (catNum == 0 && dogNum == 0) {
                count++;
            }
            return;
        }

        int iNum = position / 3;
        int jNum = position % 3;

        // 每个位置可能放：0 不放，1 放猫，2 放狗

        // 任何时刻都可以不放
        matrix[iNum][jNum] = 0;
        dfs(matrix, position + 1, catNum, dogNum);

        // 看能否 放猫
        if (catNum > 0 && !hasAnimal(matrix, iNum, jNum, 1)) {
            matrix[iNum][jNum] = 1;
            dfs(matrix, position + 1, catNum - 1, dogNum);
            // 回溯
            matrix[iNum][jNum] = 0;
        }

        // 看能否 放狗
        if (dogNum > 0 && !hasAnimal(matrix, iNum, jNum, 2)) {
            matrix[iNum][jNum] = 2;
            dfs(matrix, position + 1, catNum, dogNum - 1);
            // 回溯
            matrix[iNum][jNum] = 0;
        }
    }

    private static boolean hasAnimal(int[][] matrix, int i, int j, int animalType) {
        for (int k = 0; k < 4; k++) {
            int newI = i + dir[k];
            int newJ = j + dir[k + 1];
            if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix.length) {
                if (matrix[newI][newJ] == animalType) {
                    return true;
                }
            }
        }
        return false;
    }

}
