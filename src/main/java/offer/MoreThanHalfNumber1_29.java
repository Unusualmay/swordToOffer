package offer;

public class MoreThanHalfNumber1_29 {
    public static void main(String[] args) {
        MoreThanHalfNumber1_29 m1 = new MoreThanHalfNumber1_29();
        int[] a = new int[]{1,2,2,2,2,4,2,4,6};
        int result = m1.moreThanHalfNum(a);
//        System.out.println(result);
        if (m1.checkMoreThanHalf(a,result)) {
            System.out.println("找到了该数字就是"+result);
        }
    }

    /**
     * 这里不是单纯的把找到的数字的次数times加到一半，而是根据数组的特点
     * 因为是找到大于数组长度一半的数字，所以最后一次设times=1时候对应的
     * result为我们所需要的数字
     * @param a
     * @return
     */
    public int moreThanHalfNum(int[] a) {
        int times = 0;
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if (result == 0) {
                result = a[i];
                times = 1;
            } else if (a[i] == result) {
                times++;
            } else {
                times--;
            }
            if (times == 0) {
                result = 0;
            }
        }
        return result;
    }

    /**
     * 检查我们找到的数字是不是大于数组长度的一半
     * @param a
     * @param num
     * @return
     */
    public boolean checkMoreThanHalf(int[] a, int num) {
        int times = 0;
        boolean isMOreThanHalf = false;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                times++;
            }
        }
        if (times*2 > a.length) {
            isMOreThanHalf = true;
        }
        return isMOreThanHalf;
    }
}
