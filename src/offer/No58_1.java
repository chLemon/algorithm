package offer;

import org.junit.Test;

import java.util.ArrayList;

public class No58_1 {
    /*
    输入一个英文句子，
    翻转句子中单词的顺序，
    但单词内字符的顺序不变。
    为简单起见，
    标点符号和普通字母一样处理。
    例如输入字符串"I am a student. "，
    则输出"student. a am I"。
     */

    public String reverseWords(String s) {
//        s = s.trim(); // 删除首尾空格
//        int j = s.length() - 1, i = j;
//        StringBuilder res = new StringBuilder();
//        while(i >= 0) {
//            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
//            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
//            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
//            j = i; // j 指向下个单词的尾字符
//        }
//        return res.toString().trim(); // 转化为字符串并返回
        s=s.trim();
        StringBuilder result = new StringBuilder();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                if(sb.length()!=0){
                    strings.add(sb.toString());
                    sb=new StringBuilder();
                }
            }else{
                sb.append(c);
            }
        }
        if(sb.length()!=0){
            strings.add(sb.toString());
        }
        //倒序输出strings，保存在result里面
        for (int i = strings.size()-1 ;i >=0 ; i--) {
            result.append(strings.get(i));
            result.append(" ");
        }
        return result.toString().trim();

    }

    @Test
    public void test() {
        String s = reverseWords("the sky is blue");
        System.out.println(s);
    }
}
