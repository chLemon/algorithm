package solutions.codinginterviews;

import java.util.LinkedHashMap;

public class No50 {
    /*
    在字符串 s 中找出第一个只出现一次的字符。
    如果没有，返回一个单空格。
    s 只包含小写字母。
     */
    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();//
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),true);
            }else{
                map.put(s.charAt(i),false);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character)==false){
                return character;
            }
        }
        return ' ';

//        HashMap<Character, Boolean> dic = new HashMap<>();
//        char[] sc = s.toCharArray();
//        for(char c : sc)
//            dic.put(c, !dic.containsKey(c));
//        for(char c : sc)
//            if(dic.get(c)) return c;
//        return ' ';
//
//        Map<Character, Boolean> dic = new LinkedHashMap<>();
//        char[] sc = s.toCharArray();
//        for(char c : sc)
//            dic.put(c, !dic.containsKey(c));
//        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
//            if(d.getValue()) return d.getKey();
//        }
//        return ' ';

    }
}
