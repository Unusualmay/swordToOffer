package offer;

/**
 * 异或运算的运用，此题的关键在于将数组分为两个子数组
 * 思想：我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个
 * 只出现一次的数字的异或结果。因为其他数字都出现了两次，在异或中全部抵消掉了。
 * 由于这两个数字肯定不一样，那么这个异或结果肯定不为0，也就是说在这个结果数字
 * 的二进制表示中至少就有一位为1。我们在结果数字中找到第一个为1的位的位置，记
 * 为第N位。现在我们以第N位是不是1为标准把原数组中的数字分成两个子数组，第一
 * 个子数组中每个数字的第N位都为1，而第二个子数组的每个数字的第N位都为0。
 */
public class NumbersAppearOnce_40 {
    int num1;
    int num2;
    public static void main(String[] args) {
        NumbersAppearOnce_40 nao = new NumbersAppearOnce_40();
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        nao.findNumbersAppearOnce(arr);
        System.out.println("num1:"+ nao.num1);
        System.out.println("num2:"+ nao.num2);
    }

    public void findNumbersAppearOnce(int[] arr) {
        int resultExclusiveOR = 0;
        for (int i = 0; i < arr.length; i++) {
            resultExclusiveOR ^= arr[i];
        }
        int indexBit = findFirstBitIs1(resultExclusiveOR);
        for(int j = 0; j < arr.length; j++) {
            if (isBit1(arr[j], indexBit)) {
                num1 ^= arr[j];
            } else {
                num2 ^= arr[j];
            }
        }
    }

    public int findFirstBitIs1(int num) {
        int indexBit = 0;
        while((num & 1)==0 && indexBit < 32) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    public boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        if ((num & 1) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
