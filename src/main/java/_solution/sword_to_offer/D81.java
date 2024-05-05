package _solution.sword_to_offer;

class D81 {

    static int x;

    public static boolean multi() {
        if (x % 5 == 0) {
            x = x / 5 * 6 + 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x = 6 * i + 1;//六号小朋友分前一共有这么多
            if (multi()) {
                //5号小朋友分前的量
                if (multi()) {
                    //四号小朋友
                    if (multi()) {
                        //三号下朋友
                        if (multi()) {
                            //二号
                            if (multi()) {
                                //一号
                                System.out.println(i);
                                System.out.println(x);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
