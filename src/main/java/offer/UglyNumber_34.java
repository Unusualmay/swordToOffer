package offer;

/**
 * 此方法在时间效率上有点低，找到第1500个丑数是859963392，
 * 这就是说明要判断丑数的次数是859963392次
 */
public class UglyNumber_34 {
    public static void main(String[] args) {
        UglyNumber_34 un = new UglyNumber_34();
        System.out.println(un.getUglyNumber(1500));
    }

    public boolean isUgly(int number) {
        while(number % 2 == 0) {
            number = number/2;
        }

        while(number % 3 == 0) {
            number = number/3;
        }

        while(number % 5 == 0) {
            number = number/5;
        }
        return number == 1? true:false;
    }

    public int getUglyNumber(int index) {
        if (index < 0) {
            return 0;
        }
        int uglyNumber = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            uglyNumber++;
            if (isUgly(uglyNumber)) {
                uglyFound++;
            }
        }
        return uglyNumber;
    }
}
