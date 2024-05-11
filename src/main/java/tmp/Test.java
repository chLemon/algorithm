package tmp;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            String s = buildString();
            String old = old(s);
            System.out.println(old);

            String mine = mine(s);
            System.out.println(mine);
            if (!old.equals(mine)) {
                System.out.println("【【有不对的！】】");
            }
        }
    }

    private static String buildString() {
        String s = "";
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 50; i++) {
            int j = random.nextInt(3);
            switch (j) {
                case 0:
                    s += "a";
                    break;
                case 1:
                    s += "b";
                    break;
                case 2:
                    s += "c";
                    break;
            }
        }
        return s;
    }

    private static String old(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        while (true) {
            if (list.size() < 3) {
                return listToString(list);
            }
            int i = 0;
            do {
                Set<Character> set = new HashSet<>();
                set.add(list.get(i));
                set.add(list.get(i + 1));
                set.add(list.get(i + 2));
                boolean kick = false;
                if (set.size() == 3) {
                    list.remove(i + 1);
                    kick = true;
                } else {
                    i = i + 1;
                }
                if (i + 2 >= list.size()) {
                    if (kick) {
                        continue;
                    } else {
                        return listToString(list);
                    }
                }
            } while (i + 2 < list.size());

        }
    }

    private static String listToString(LinkedList<Character> list) {
        String s = "";
        for (Character c : list) {
            s += c;
        }
        return s;
    }

    private static String mine(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        int i = 0;
        while (list.size() > 2) {
            Set<Character> set = new HashSet<>();
            set.add(list.get(i));
            set.add(list.get(i + 1));
            set.add(list.get(i + 2));
            if (set.size() == 3) {
                list.remove(i + 1);
                if (i + 3 >= list.size()) {
                    // 删除了元素，导致越界
                    i--;
                }
            } else {
                i++;
                if (i + 2 >= list.size()) {
                    // 完成
                    break;
                }
            }
        }

        return listToString(list);
    }

}
