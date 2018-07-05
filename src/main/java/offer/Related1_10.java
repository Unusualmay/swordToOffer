package offer;

public class Related1_10 {
    public static void main(String[] args) {
        if (isTwoIntegerPower(9)) {
            System.out.println("9是2的整数次方");
        } else {
            System.out.println("9不是2的整数次方");
        }
        System.out.println(bitNumsOfChange(6,9));
    }

    /**
     * 判断输入的一个整数是否是2的整数次方，还是利用整数减1然后再与该整数进行相与，看是否是0,
     * @param n
     * @return
     */
    public static boolean isTwoIntegerPower(int n) {
        int count = 0;
        while(n != 0) {
            ++count;
            n = n & (n-1);
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    /**
     * 输入两个整数m,n，计算需要改变m的二进制表示中的多少位才能得到n,注意这里没有说要改变哪几位
     * 只要求求出改变的位数；
     * @param m
     * @param n
     * @return
     */
    public static int bitNumsOfChange(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            ++count;
            temp = temp & (temp-1);
        }
        return count;
    }
}
