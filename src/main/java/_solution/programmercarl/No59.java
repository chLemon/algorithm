package _solution.programmercarl;

class No59 {

    int N;
    int[][] res;

    public static void main(String[] args) {
        No59 no = new No59();
        no.generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        N = n;
        res = new int[n][n];
        int x = 0;
        int y = 0;
        int dir = 0;    // 0 右，1 下，2 左，3 上
        for (int i = 1; i <= n; i++) {
            res[x][y] = i;
            switch (dir) {
                case 0:
                    if (isValid(x, y + 1)) {
                        y += 1;
                    } else {
                        dir = 1;
                        x += 1;
                    }
                    break;
                case 1:
                    if (isValid(x + 1, y)) {
                        x += 1;
                    } else {
                        dir = 2;
                        y -= 1;
                    }
                    break;
                case 2:
                    if (isValid(x, y - 1)) {
                        y -= 1;
                    } else {
                        dir = 3;
                        x -= 1;
                    }
                    break;
                default:
                    if (isValid(x - 1, y)) {
                        x -= 1;
                    } else {
                        dir = 0;
                        y += 1;
                    }
                    break;
            }
        }

        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && res[x][y] == 0;
    }

}
