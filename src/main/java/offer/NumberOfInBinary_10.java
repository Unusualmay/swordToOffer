public class NumberOfInBinary_10 {
    public static void main(String[] args) {
        System.out.println(numsOfOne1(9));
        System.out.println(numsOfOne2(9));
    }

    /**
     * 输入一个整数，输出该整数二进制表示中1的个数
     * @param n
     * @return
     */
    /**
     * 常规解法
     * @param n
     * @return
     */
    public static int numsOfOne1(int n) {
        int count = 0;
        int flag = 0x00000001;
        while(flag != 0) {
            if ((n & flag) != 0) {
                System.out.println("count:" + count);
                ++count;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 新颖解法，先将n-1，然后让其与n相与，如果不等于0，则count自增
     * @param n
     * @return
     */
    public static int numsOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
