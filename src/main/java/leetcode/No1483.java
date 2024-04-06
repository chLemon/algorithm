package leetcode;

class No1483 {

    class TreeAncestor {

        int[][] binaryLiftingParent;

        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);   // int最多32位，n的前导0数量减去后，就是n的二进制长度
            this.binaryLiftingParent = new int[parent.length][m];
            for (int i = 0; i < n; i++) {
                this.binaryLiftingParent[i][0] = parent[i];
            }
            for (int i = 0; i < m - 1; i++) {
                for (int x = 0; x < n; x++) {
                    int p = binaryLiftingParent[x][i];  // 循环计算 i + 1 情况下的值，即 爷爷节点 = 父亲的父亲
                    binaryLiftingParent[x][i + 1] = p < 0 ? -1 : binaryLiftingParent[p][i];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            // k 可以表示为二进制，如 1101 = 13，则答案为，先找到0001的，在找到0100的，再找到1000的
            // pa[node][i] 表示 node的第2^i个父节点的值
            // 先跳1，即先找到父节点 n1 ，再跳 2^2，即找到n1的4个父节点，相当于是node的5个父节点……
            while (k > 0 && node != -1) {
                node = binaryLiftingParent[node][Integer.numberOfTrailingZeros(k)];
                k = k & (k - 1);
            }
            return node;
        }
    }


}
