package offer;

/**
 * 要求：不使用中间变量交换两个数字的值
 */
public class SwapTwoNumbers_47 {
    public static void main(String[] args) {
        SwapTwoNumbers_47 st = new SwapTwoNumbers_47();
        st.swap(5,-4);
        st.swap(5,-4);
    }

    /**
     * 基于四则运算的交换两个数字
     * @param a
     * @param b
     */
    public void swap(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("a:" + a + "\t" + "b:" + b);
    }

    /**
     * 基于异或的交换两个数的值
     * @param a
     * @param b
     */
    public void swap_1(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a:"+a+"\t"+"b:"+b);
    }
}
