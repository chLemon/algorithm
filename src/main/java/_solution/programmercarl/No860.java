package _solution.programmercarl;

class No860 {

    public static void main(String[] args) {
        No860 no = new No860();
        System.out.println(no.lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}));
    }

    public boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    c5++;
                    break;
                case 10:
                    c10++;
                    c5--;
                    break;
                case 20:
                    if (c10 > 0) {
                        c10--;
                        c5--;
                    } else {
                        c5 -= 3;
                    }
                    break;
            }
            if (c5 < 0 || c10 < 0) return false;
        }
        return true;
    }

}
