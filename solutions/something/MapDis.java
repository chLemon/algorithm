package something;

import lombok.Data;
import util.JacksonUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapDis {
    static int l = 11;
    static int n = 3;
    static int mid = l / 2;

    public static void main(String[] args) {
        Point[][] p = newMap();

        // 假定初始方向向上
        Point start = p[mid][mid];
        start.p_up = new BigDecimal("1");
//        start.p_right = new BigDecimal("1");
//        start.p_down = new BigDecimal("1");
//        start.p_left = new BigDecimal("1");

        print2(p);

        for (int i = 0; i < n; i++) {
            System.out.println();
            p = move(p);
            System.out.println("当前轮次：" + i);
            print2(p);
            System.out.println();

            // 发现边缘区域概率非常大，计算一下
            BigDecimal[] result = cal(p);
            System.out.print("边缘部分的概率和为：");
            System.out.println(result[0]);
            System.out.print("上半部分的概率和为：");
            System.out.println(result[1]);
            System.out.print("下半部分的概率和为：");
            System.out.println(result[2]);
            System.out.print("左半部分的概率和为：");
            System.out.println(result[3]);
            System.out.print("右半部分的概率和为：");
            System.out.println(result[4]);
            System.out.println("最大的概率是：");
            System.out.println(result[5]);
        }
    }

    private static BigDecimal[] cal(Point[][] p) {
        List<BigDecimal> edges = new ArrayList<>();
        List<BigDecimal> ups = new ArrayList<>();
        List<BigDecimal> rights = new ArrayList<>();
        List<BigDecimal> downs = new ArrayList<>();
        List<BigDecimal> lefts = new ArrayList<>();
        BigDecimal max = new BigDecimal("0");

        for (int i = 0; i < l; i++) {
            List<BigDecimal> thisLine = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                BigDecimal pointP = p[j][i].getP();
                if (pointP.compareTo(max) > 0) {
                    max = pointP;
                }
                if (pointP.compareTo(new BigDecimal("0")) != 0) {
                    thisLine.add(pointP);
                }
                if (j < mid) {
                    lefts.add(pointP);
                } else if (j > mid) {
                    rights.add(pointP);
                }
                if (i < mid - 1) {
                    ups.add(pointP);
                } else if (i > mid - 1) {
                    downs.add(pointP);
                }
            }
            if (thisLine.size() > 1) {
                edges.add(thisLine.get(0));
                edges.add(thisLine.get(thisLine.size() - 1));
            } else if (thisLine.size() == 1) {
                edges.add(thisLine.get(0));
            }
        }
        BigDecimal[] res = new BigDecimal[6];
        res[0] = edges.stream().reduce(BigDecimal::add).orElse(null);
        res[1] = ups.stream().reduce(BigDecimal::add).orElse(null);
        res[2] = downs.stream().reduce(BigDecimal::add).orElse(null);
        res[3] = lefts.stream().reduce(BigDecimal::add).orElse(null);
        res[4] = rights.stream().reduce(BigDecimal::add).orElse(null);
        res[5] = max;
        return res;
    }

    private static void print(Point[][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                System.out.print(p[j][i].getP() + "\t\t\t");
            }
            System.out.println();
        }
    }

    private static void print2(Point[][] p) {
        List<List<BigDecimal>> res = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            ArrayList<BigDecimal> line = new ArrayList<>();
            res.add(line);
            for (int j = 0; j < p.length; j++) {
                line.add(p[j][i].getP().setScale(4, BigDecimal.ROUND_HALF_UP));
//                System.out.print(p[j][i].getP() + "\t\t\t");
            }
//            System.out.println();
        }
        String s = JacksonUtil.writeValueAsString(res);
        System.out.println(s);
    }

    static class Point {

        // 方向为上的概率
        BigDecimal p_up = new BigDecimal("0");
        // 方向为右的概率
        BigDecimal p_right = new BigDecimal("0");
        // 方向为左的概率
        BigDecimal p_left = new BigDecimal("0");
        // 方向为下的概率
        BigDecimal p_down = new BigDecimal("0");

        public BigDecimal getP() {
            return p_up.add(p_right).add(p_down).add(p_left).stripTrailingZeros();
        }

        public Point() {
        }
    }


    private static Point[][] newMap() {
        Point[][] p = new Point[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                p[i][j] = new Point();
            }
        }
        return p;
    }


    // [0,0]概率为1，则下一轮
    // [0,-2] 94% [1,-1] 2% [0,0] 2% [-1,-1] 2%
    // 方向的概率
    // 0 0.8836 1 0.0188 2 0.0188 3 0.0188
    // 0 0.0004 1 0.0188 2 0.0004 3 0.0004
    // 0 0.0004 1 0.0004 2 0.0188 3 0.0004
    // 0 0.0004 1 0.0004 2 0.0004 3 0.0188
    private static Point[][] move(Point[][] p) {
        Point[][] next = newMap();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                Point now = p[i][j];
                if (now.getP().compareTo(new BigDecimal("0")) > 0) {
                    if (j - 1 < 0 || i - 1 < 0 || i + 1 >= l || j + 1 >= l) {
                        // 边界点
                    } else {
                        if (now.p_up.compareTo(new BigDecimal("0")) > 0) {
                            // 上方的点
                            Point next_up = next[i][j - 2];
                            // 右方的点
                            Point next_right = next[i + 1][j - 1];
                            // 下方的点
                            Point next_down = next[i][j];
                            // 左方的点
                            Point next_left = next[i - 1][j - 1];
                            BigDecimal p_base = now.p_up;

                            next_up.p_up = next_up.p_up.add(new BigDecimal("0.8836").multiply(p_base));
                            next_up.p_right = next_up.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_up.p_down = next_up.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_up.p_left = next_up.p_left.add(new BigDecimal("0.0188").multiply(p_base));

                            next_right.p_up = next_right.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_right = next_right.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_right.p_down = next_right.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_left = next_right.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_down.p_up = next_down.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_right = next_down.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_down = next_down.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_down.p_left = next_down.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_left.p_up = next_left.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_right = next_left.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_down = next_left.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_left = next_left.p_left.add(new BigDecimal("0.0188").multiply(p_base));
                        }
                        if (now.p_right.compareTo(new BigDecimal("0")) > 0) {
                            // 上方的点
                            Point next_up = next[i + 1][j - 1];
                            // 右方的点，主方向
                            Point next_right = next[i + 2][j];
                            // 下方的点
                            Point next_down = next[i + 1][j + 1];
                            // 左方的点
                            Point next_left = next[i][j];
                            BigDecimal p_base = now.p_right;

                            next_right.p_up = next_right.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_right.p_right = next_right.p_right.add(new BigDecimal("0.8836").multiply(p_base));
                            next_right.p_down = next_right.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_right.p_left = next_right.p_left.add(new BigDecimal("0.0188").multiply(p_base));

                            next_down.p_up = next_down.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_right = next_down.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_down = next_down.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_down.p_left = next_down.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_left.p_up = next_left.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_right = next_left.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_down = next_left.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_left = next_left.p_left.add(new BigDecimal("0.0188").multiply(p_base));

                            next_up.p_up = next_up.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_up.p_right = next_up.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_down = next_up.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_left = next_up.p_left.add(new BigDecimal("0.0004").multiply(p_base));
                        }
                        if (now.p_down.compareTo(new BigDecimal("0")) > 0) {
                            // 上方的点
                            Point next_up = next[i][j];
                            // 右方的点
                            Point next_right = next[i + 1][j + 1];
                            // 下方的点，主方向
                            Point next_down = next[i][j + 2];
                            // 左方的点
                            Point next_left = next[i - 1][j + 1];

                            BigDecimal p_base = now.p_down;

                            next_down.p_up = next_down.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_down.p_right = next_down.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_down.p_down = next_down.p_down.add(new BigDecimal("0.8836").multiply(p_base));
                            next_down.p_left = next_down.p_left.add(new BigDecimal("0.0188").multiply(p_base));

                            next_left.p_up = next_left.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_right = next_left.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_down = next_left.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_left.p_left = next_left.p_left.add(new BigDecimal("0.0188").multiply(p_base));

                            next_up.p_up = next_up.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_up.p_right = next_up.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_down = next_up.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_left = next_up.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_right.p_up = next_right.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_right = next_right.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_right.p_down = next_right.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_left = next_right.p_left.add(new BigDecimal("0.0004").multiply(p_base));
                        }
                        if (now.p_left.compareTo(new BigDecimal("0")) > 0) {
                            // 上方的点
                            Point next_up = next[i - 1][j - 1];
                            // 右方的点
                            Point next_right = next[i][j];
                            // 下方的点
                            Point next_down = next[i - 1][j + 1];
                            // 左方的点，主方向
                            Point next_left = next[i - 2][j];
                            BigDecimal p_base = now.p_left;

                            next_left.p_up = next_left.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_left.p_right = next_left.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_left.p_down = next_left.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_left.p_left = next_left.p_left.add(new BigDecimal("0.8836").multiply(p_base));

                            next_up.p_up = next_up.p_up.add(new BigDecimal("0.0188").multiply(p_base));
                            next_up.p_right = next_up.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_down = next_up.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_up.p_left = next_up.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_right.p_up = next_right.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_right = next_right.p_right.add(new BigDecimal("0.0188").multiply(p_base));
                            next_right.p_down = next_right.p_down.add(new BigDecimal("0.0004").multiply(p_base));
                            next_right.p_left = next_right.p_left.add(new BigDecimal("0.0004").multiply(p_base));

                            next_down.p_up = next_down.p_up.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_right = next_down.p_right.add(new BigDecimal("0.0004").multiply(p_base));
                            next_down.p_down = next_down.p_down.add(new BigDecimal("0.0188").multiply(p_base));
                            next_down.p_left = next_down.p_left.add(new BigDecimal("0.0004").multiply(p_base));
                        }
                    }
                }
            }
        }

        return next;
    }

}
