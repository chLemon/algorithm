package heima;

public class no1_稀疏数组 {
    /*
    例如五子棋的棋盘。1表示黑子，2表示白子
    原本是一个大的矩阵，希望只保存有效数据，节约空间。

    保存有值元素的 行 列 值。其中用第一行保存总行数和总列数，还有总数

    二维数组转换稀疏数组：
    1. 遍历二维数组拿到有效数据个数sum
    2. 根据sum创建sparseArr int[sum+1][3]
    3. 存入

    稀疏数组转换二维数组：
    1. 读取第一行，创建数组
    2. 读取之后的数据，赋值
     */

    /**
     * 二维数组转稀疏数组
     * @param source
     * @return
     */
    public static int[][] sparseArray(int[][] source) {
        int sum = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                if(source[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] target = new int[sum+1][3];
        target[0]=new int[]{source.length,source[0].length,sum};
        int n = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                if(source[i][j] != 0) {
                    n++;
                    target[n] = new int[]{i,j,source[i][j]};
                }
            }
        }
        return target;
    }

    public static int[][] sparseArrayRe(int[][] source) {
        int[][] target= new int[source[0][0]][source[0][1]];
        for (int i = 1; i < source.length; i++) {
            target[source[i][0]][source[i][1]] = source[i][2];
        }
        return target;
    }

    public static void main(String[] args) {
        /*
        测试，创建一个原始二维数组11
         */
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[5][6]=2;

        //输出原始数组
        for (int[] row:chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("================");

        int[][] changedArr = sparseArray(chessArr1);

        for (int[] row : changedArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("================");
        int[][] recoverArr=sparseArrayRe(changedArr);
        for (int[] row : recoverArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}