package _solution.inf;

import java.util.ArrayList;
import java.util.List;

class No22 {

    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    int n;

    public List<String> generateParenthesis(int n) {
        // 每个位置，可以左括号/右括号
        this.n = n;

        dfs(0, 0);

        return res;
    }

    private void dfs(int i, int leftCount) {
        if (i == n * 2) {
            res.add(builder.toString());
            return;
        }

        int rightCount = builder.length() - leftCount;

        // 如果leftCount < n，就可以考虑 (
        // 如果 rightCount >= leftCount 不能考虑 )
        if (leftCount < n) {
            builder.append("(");
            dfs(i + 1, leftCount + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (rightCount < leftCount) {
            builder.append(")");
            dfs(i + 1, leftCount);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
