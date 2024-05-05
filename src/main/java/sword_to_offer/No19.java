package sword_to_offer;

class No19 {
    /*
    请实现一个函数用来匹配包含'. '和'*'的正则表达式。
    模式中的字符'.'表示任意一个字符，
    而'*'表示它前面的字符可以出现任意次（含0次）。
    在本题中，匹配是指字符串的所有字符匹配整个模式。
    例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
    但与"aa.a"和"ab*a"均不匹配。

     */
    public static void main(String[] args) {
        No19 no19 = new No19();
        System.out.println(no19.isMatch("ab", ".*"));

    }


    public boolean isMatch(String s, String p) {
    /*
    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
     */
        //这个题真的是太秀了，最关键的点其实在于，c*这种模式，移动和不移动都必须去考虑，造成了2个分支。
        //所以要么dp，要么递归

        //动态规划：
        int m = s.length();
        int n = p.length();
        boolean[][] resultMatrix = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //从0,0开始，遍历
                if (j == 0) {
                    if (i == 0) {
                        resultMatrix[i][j] = true;
                    }else {
                    resultMatrix[i][j] = false;}
                } else {
                    //如果是c*结构：
                    if (p.charAt(j - 1) == '*') {


                            resultMatrix[i][j] = resultMatrix[i][j - 2];

                        if (i > 0 && j>1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            resultMatrix[i][j] |= resultMatrix[i - 1][j];
                        }
                    } else {
//                        if (i > 0 && ((p.charAt(j - 1) == '.') || (p.charAt(j - 1) == s.charAt(i - 1)))) {
                        if (i > 0 && ((s.charAt(i-1)==p.charAt(j-1))||(p.charAt(j-1)=='.'))) {
                            resultMatrix[i][j] = resultMatrix[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return resultMatrix[m][n];


    }

}
