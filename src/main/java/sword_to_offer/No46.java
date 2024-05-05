package sword_to_offer;

class No46 {
    /*
    给定一个数字，
    我们按照如下规则把它翻译为字符串：
    0 翻译成 “a” ，
    1 翻译成 “b”，……，
    11 翻译成 “l”，……，
    25 翻译成 “z”。
    一个数字可能有多个翻译。
    请编程实现一个函数，
    用来计算一个数字有多少种不同的翻译方法。
     */
    int num;
    int digit;

    public int translateNum(int num) {
        this.num = num;
        while (num > 0) {
            digit++;
            num /= 10;
        }
        return dp(digit);
    }

    public int dp(int level) {
        if (level == 0){
            return 1;
        }
        if (level == 1) {
            return 1;
        }
        int cur = calCur(digit+1-level);//新添加的末尾
        int pre = calCur(digit+2-level);
        boolean b = pre!=0 &&(pre * 10 + cur <= 25) ? true : false;
        if (b) {
            return dp(level - 1) + dp(level - 2);
        } else {
            return dp(level - 1);
        }
    }

    public int calCur(int i) {
        return num / pow(i - 1) % 10;
    }

    public int pow(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
    /*
    输入: 12258
    输出: 5
    解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */


//    int f(int num) {
//        if (num < 10) {
//            return 1;
//        }
//        if (num % 100 < 26 && num % 100 > 9) {
//            return f(num / 10) + f(num / 100);
//        } else {
//            return f(num / 10);
//        }
//    }


//    public int translateNum(int num) {
//        int a = 1, b = 1, x, y = num % 10;
//        while(num != 0) {
//            num /= 10;
//            x = num % 10;
//            int tmp = 10 * x + y;
//            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
//            b = a;
//            a = c;
//            y = x;
//        }
//        return a;
//    }

}
