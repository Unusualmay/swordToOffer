package offer;

public class Power_11 {
    public static void main(String[] args) {
        System.out.println(power(-2,-1));
    }

    /**
     * 求得一个数值的整数次方
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        double result = 0.0;
        boolean isInvalidInput = false;
        if (base == 0 && exponent < 0) {
            System.out.println("输入不合法");
            isInvalidInput = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }
        result = basePowerUnsignedExponet(base,absExponent);
        if (exponent < 0) {
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 单独利用公式求得a的n次方
     * @param base
     * @param absExponet
     * @return
     */
    public static double basePowerUnsignedExponet(double base, int absExponet) {
        if (absExponet == 0) {
            return 1;
        }
        if (absExponet == 1) {
            return base;
        }
        double result = basePowerUnsignedExponet(base, absExponet >> 1);
        result *= result;
        if ((absExponet & 1) != 0) {
            result *= base;
        }
        return result;
    }
}
