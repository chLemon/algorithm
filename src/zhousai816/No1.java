package zhousai816;

public class No1 {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i < arr.length - 2) {
            if ((arr[i] & 1) == 1) {
                //当前位置是奇数
                int next = arr[i + 1];
                if ((next & 1) == 1) {
                    //下一位还是奇数
                    int last = arr[i + 2];
                    if ((last & 1) == 1) {
                        //第三位还是
                        return true;
                    }else{
                        i+=3;
                    }
                }else {
                    //第二位不是
                    i+=2;
                }
            } else {
                //当前位置就不是
                i++;
            }

        }
        return false;
    }

}
