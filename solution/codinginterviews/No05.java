package codinginterviews;

public class No05 {
    /*
    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    /*
    输入：s = "We are happy."
    输出："We%20are%20happy."
     */
    //调用s.replace方法最快

    public static void main(String[] args) {
        String s = "We are happy.";
        String re = replaceSpace(s);
        System.out.println(re);

    }

    public static String replaceSpace(String s) {
        int length = s.length();
        char[] cs = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                cs[size] = '%';
                cs[size + 1] = '2';
                cs[size + 2] = '0';
                size += 3;
            } else {
                cs[size] = s.charAt(i);
                size++;
            }
        }
        return new String(cs, 0, size);
    }
}
/*
  int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */