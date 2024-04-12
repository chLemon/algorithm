package leetcode;

class No1702 {

    public static void main(String[] args) {
        No1702 no = new No1702();
        String s = no.maximumBinaryString("000110");
        System.out.println(s);
    }

    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int j = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                // 如果当前是0
                // 如果紧跟着的是0，则转换为1, 0
                if (chars[i + 1] == '0') {
                    chars[i] = '1';
                } else {
                    // 这一大串逻辑都可以优化一下
                    /*
                    答案最多有1个0；
                    当i处为0， [i, j] 中有n个1和m个0时，10 -> 01 会让所有的1被排挤到末尾
                    00 -> 10 可以让 m-1个0变成1
                    所以唯一的0的位置在：j - n 处
                    
                    所以先找到第一个0；然后统计剩下部分里1的个数；然后全部改为1，把 n-1-count1 的位置改为0即可。
                     */

                    // 下一个是1，则判断之后是否有0
                    boolean hasZero = false;
                    // 上一次找到的最后一个0
                    j = Math.max(i + 2, j + 1);
                    while (j < chars.length) {
                        if (chars[j] == '0') {
                            hasZero = true;
                            break;
                        }
                        j++;
                    }

                    if (hasZero) {
                        // 之后还有0
                        // 做转换，j现在是0，转换为，i为1，i+1为0，i+1 -> j全为1
                        chars[i] = '1';
                        chars[i + 1] = '0';
                        chars[j] = '1';
                    } else {
                        // 之后都是1了
                        return new String(chars);
                    }
                }
            }
        }
        return new String(chars);
    }

}
