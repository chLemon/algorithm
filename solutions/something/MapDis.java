package something;

public class MapDis {
    static int l = 11;

    class Point {
        int x;
        int y;
        int dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        int[][] p = new int[l][l];
        // 假定初始方向向上
        p[l / 2][l / 2] = 1;

        p = move(p);

        print(p);
    }

    // [0,0]概率为1，则下一轮
    // [0,-2] 94% [1,-1] 2% [0,0] 2% [-1,-1] 2%
    // 方向的概率
    // 0 0.8836 1 0.0188 2 0.0188 3 0.0188
    // 0 0.0004 1 0.0188 2 0.0004 3 0.0004
    // 0 0.0004 1 0.0004 2 0.0188 3 0.0004
    // 0 0.0004 1 0.0004 2 0.0004 3 0.0188
    private static int[][] move(int[][] p) {
        int[][] next = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int now = p[i][j];
                if (now > 0) {

                }
            }
        }

        return next;
    }

    private static void print(int[][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                System.out.print(p[i][j]);
            }
            System.out.println();
        }
    }

}
