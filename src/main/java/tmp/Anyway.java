package tmp;

class Anyway {

    private int[][] chessboard;    // 棋盘
    private int count;// 方案数

    public static void main(String[] args) {
        Anyway anyway = new Anyway();
        int cal = anyway.cal(new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 0, 0},
        });
        System.out.println(cal);
    }

    public int cal(int[][] chessboard) {
        this.chessboard = chessboard;   // 保存到全局变量，方便访问

        backTracing(0, 8);
        
        return count;
    }

    /**
     * @param position     当前放到第几个格子了
     * @param remainCastle 还要放的车的个数
     */
    // position: 
    private void backTracing(int position, int remainCastle) {
        if (64 - position < remainCastle) return;   // 剪枝，其余剪枝请自行发挥
        if (position == 64 || remainCastle == 0) {
            // 全部放完了
            if (remainCastle == 0) count++;
            return;
        }

        int lineNum = position / 8; // 这个位置的行号 i
        int columnNum = position % 8;   // 这个位置的列号 j

        if (chessboard[lineNum][columnNum] == 0) {
            // 当前位置是洞，不能放
            backTracing(position + 1, remainCastle);
        } else {
            // 当前位置可以考虑放
            if (conflict(lineNum, columnNum)) {
                // 当前位置和别的车有冲突，不能放
                backTracing(position + 1, remainCastle);
            } else {
                // 当前位置可以放
                chessboard[lineNum][columnNum] = 2;
                backTracing(position + 1, remainCastle - 1);
                // 回溯
                chessboard[lineNum][columnNum] = 1;
            }
        }
    }

    // i,j 处放置车是否和目前棋盘上的情况冲突
    // 假定当前算法复杂度x，主算法复杂度为 O(x * 64)
    private boolean conflict(int i, int j) {
        // 直接模拟判断，上下左右是否会冲突，由于我们是从左至右，从上至下摆棋子，所以只需要看上方和左边是否有车就行。
        // 复杂度 O(2*8) = O(16)
        // 注意国际象棋规则中，车只能上下左右移动，不能斜着走

        // 上
        int upj = j;
        while (--upj >= 0) {
            if (chessboard[i][upj] == 0) {
                // 遇到了洞，阻断
                break;
            } else if (chessboard[i][upj] == 2) {
                // 遇到了车，冲突
                return true;
            }
        }
        // 上方无冲突
        // 左
        int lefti = i;
        while (--lefti >= 0) {
            if (chessboard[lefti][j] == 0) {
                // 遇到了洞，阻断
                break;
            } else if (chessboard[lefti][j] == 2) {
                // 遇到了车，冲突
                return true;
            }
        }
        return false;
    }

}
