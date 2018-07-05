public class Fibonacci_09 {
    /*
    求fibonacci数列的第n项
     */
    public static long fibonacci(int n) {
        long[] result = new long[]{0,1};
        if(n < 2) {
            return result[n];
        }
        long fibonacciOne = 1;
        long fibonacciTwo = 0;
        long fbN = 0;
        for(int i = 2; i <= n; i++) {
            fbN = fibonacciOne + fibonacciTwo;
            fibonacciOne = fbN;
            fibonacciTwo = fibonacciOne;
        }
        return fbN;
    }
    //n较大时，不能用int修饰，因为会有越界的风险，所以要使用long来修饰
    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }
}
