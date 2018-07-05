package offer;

/**
 * 这种方法不同于方法１，这是消耗内存，也就是增减空间的消耗，来提高时间的效率
 */
public class UglyNumber1_34 {
    public static void main(String[] args) {
        UglyNumber1_34 un = new UglyNumber1_34();
        System.out.println(un.getUglyNumber(1500));
    }

    public int getUglyNumber(int index) {
        int[] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int nextUglyNumber = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while(nextUglyNumber < index) {
            int min = min(uglyNumber[p2]*2,uglyNumber[p3]*3,uglyNumber[p5]*5);
            uglyNumber[nextUglyNumber] = min;
            //从所有的数中找到第一个大于当前最大丑数的数，三个循环都是一样，然后从三个中找到最小的数
            while(uglyNumber[p2]*2 <= uglyNumber[nextUglyNumber]) {
                p2++;
            }
            while(uglyNumber[p3]*3 <= uglyNumber[nextUglyNumber]) {
                p3++;
            }
            while(uglyNumber[p5]*5 <= uglyNumber[nextUglyNumber]) {
                p5++;
            }
            nextUglyNumber++;
        }
        return uglyNumber[nextUglyNumber-1];
    }

    public int min(int num1,int num2,int num3) {
        int min = (num1 < num2) ? num1:num2;
        min = (min < num3) ? min:num3;
        return min;
    }
}
