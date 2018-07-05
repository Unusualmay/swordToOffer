package offer;

public class Accumulate_46 {
    public static void main(String[] args) {
        Accumulate_46 acc = new Accumulate_46();
//        acc.sum(10);
//        System.out.println(acc.sum);
        int result = acc.find(10);
        System.out.println(result);
    }
    int sum = 0;

    /**
     * 此方法是将循环等价为递归，而判断条件用**||***来代替
     * 这里利用||的短路性质，如果左边是真，那么右边将不再执行
     * @param n
     * @return
     */
    public boolean sum(int n) {
        sum += n;
        return n==0 || sum(n-1);
    }

    /**
     * 方法２：同样是利用短路的性质，只不过利用的是&&的短路的性质就开了；
     * @param n
     * @return
     */
    public int find(int n) {
        int re = 0;
        int a = -1;
        boolean whaterver = false;
        whaterver = ((n!=0) && (a == (re=find(n-1))));//对whatever赋值
        return n+re;
    }
}
