package _solution.leetcode;

public class No67 {

    public static void main(String[] args) {
        String s = new No67().addBinary("11", "1");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
//        int m = a.length();
//        int n = b.length();
//        int i = m - 1;
//        int j = n - 1;
//        int carry = 0;
//        LinkedList<Integer> res = new LinkedList<>();
//        while(i >= 0 || j >= 0 || carry > 0) {
//            int av = i >= 0 ? a.charAt(i) - '0' : 0;
//            int bv = j >= 0 ? b.charAt(j) - '0' : 0;
//            int r = av + bv + carry;
//            res.addFirst(r % 2);
//            carry = r / 2;
//            i--;
//            j--;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(Integer r : res) {
//            sb.append(r.toString());
//        }
//        return sb.toString();
    }
}
