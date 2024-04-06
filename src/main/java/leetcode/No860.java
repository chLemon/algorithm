package leetcode;

class No860 {
    int count5 = 0;
    int count10 = 0;
    int count20 = 0;

    public boolean lemonadeChange(int[] bills) {
        for (int bill : bills) {
            boolean change = change(bill - 5);
            if (!change) {
                return false;
            }
            if (bill == 20) {
                count20++;
            } else if (bill == 10) {
                count10++;
            } else {
                count5++;
            }
        }
        return true;
    }

    public boolean change(int needChange) {
        if (needChange == 0) {
            return true;
        }
        // 先找20的
        int maybe20 = needChange / 20;
        int find20 = Math.min(count20, maybe20);

        needChange -= find20 * 20;
        count20 -= find20;

        // 找10块的
        int maybe10 = needChange / 10;
        int find10 = Math.min(count10, maybe10);
        needChange -= find10 * 10;
        count10 -= find10;

        // 最后找5块的
        int maybe5 = needChange / 5;
        int find5 = Math.min(count5, maybe5);
        needChange -= find5 * 5;
        count5 -= find5;

        return needChange == 0;
    }
}
