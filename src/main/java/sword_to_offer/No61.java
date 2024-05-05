package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

class No61 {
    /*
    从扑克牌中随机抽5张牌，
    判断是不是一个顺子，
    即这5张牌是不是连续的。
    2～10为数字本身，
    A为1，J为11，Q为12，K为13，
    而大、小王为 0 ，
    可以看成任意数字。
    A 不能视为 14。
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            boolean b = set.add(num);
            if (!b) {
                return false;
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min < 5;
    }

    public void test() {
        isStraight(new int[]{0, 0, 1, 2, 5});
    }
}
