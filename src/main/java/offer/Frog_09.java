public class Frog_09 {
    public static void main(String[] args) {
        System.out.println(frog1(10));
        System.out.println(frog2(10));
    }

    /**
     * 青蛙跳台阶问题：一只青蛙一次可以跳上１级台阶，也可以跳上２级台阶...也可以跳上n级台阶，求一共有多少种跳法
     * 公式如下：f(n)=2f(n-1) (n>1)
     *         f(n)=1       (n=1)
     * @param n
     * @return
     */
    /**
     * 方法一：递归方式，时间复杂度为O(n)
     * @param n
     * @return
     */
    public static long frog1(int n) {
        long fN = 0;
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(n > 1) {
            fN = 2 * frog1(n-1);
        }
        return fN;
    }
    public static long frog2(int n) {
        long fN = 1;
        if(n == 1) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        for(int i = 2; i <= n; i++) {
            fN = 2 * fN;
        }
        return fN;
    }
}
