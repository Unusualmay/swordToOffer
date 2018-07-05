package offer;

public class DicesProbability_43 {
    public static void main(String[] args) {
        printProbability(4,6);
        printProbability_1(4,6);
    }

    /**
     * 基于递归处理骰子的点数
     * @param numbers 骰子数
     */
    public static void printProbability(int numbers, int maxValue) {
        if (numbers < 1) {
            return;
        }

        int maxSum = maxValue*numbers;
        /**存放所有可能出现的数的出现次数
         * 和为s存放在s-numbers这个索引号
         * 这里就是将s置为probabilities的索引号
         */
        int[] probabilities = new int[maxSum-numbers+1];
        for(int i = numbers; i <= maxSum; i++) {
            probabilities[i-numbers] = 0;
        }
        /**
         * 求出数组probabilities的各个索引号出现的次数
         */
        probablities(numbers,probabilities,maxValue);
        /**
         * 求出每个索引对应的概率
         */
        double total = 1;
        for (int i = 0; i < numbers; i++) {
            total *= maxValue;
        }
        for (int i = numbers; i <= maxSum; i++) {
            double ratio = probabilities[i - numbers] / total;
            System.out.printf("%-8.4f", ratio);//按照一定格式输出
        }
        System.out.println();
    }

    public static void probablities(int numbers, int[] probabilities, int maxValue) {
        for(int i = 1; i <= maxValue; i++) {
            probabilities(numbers,numbers,i,probabilities, maxValue);
        }
    }

    /**
     * 一定要注意要有递归的退出条件，否则就会一直递归出现栈溢出的情况
     * 所以：当出现栈溢出的时候，要考虑一下是不是递归没有退出条件
     * @param originNums
     * @param curNums
     * @param sum
     * @param probabilities
     * @param maxValue
     */
    public static void probabilities(int originNums, int curNums, int sum, int[] probabilities, int maxValue) {
        if (curNums == 1) {
            probabilities[sum-originNums]++;
//            return;
        } else {//最开始出现栈溢出就是这里出现了问题，没有加入else
            for (int i = 1; i <= maxValue; i++) {
                probabilities(originNums, curNums - 1, sum + i, probabilities, maxValue);
            }
        }
    }

    /**
     * 循环的解法，使用两个数组，
     * 第一个数组中第n个数表示和为n
     * 第二个数组与第一个数组进行交互
     * 和为n的骰子出现的次数应该等于上一次循环中骰子的点数和为n-1.n-2,n-3,n-4,n-5,n-6的次数的和
     * @param number
     */
    public static void printProbability_1(int number, int maxValue) {
        if (number < 1) {
            return;
        }
        int[][] probabilities = new int[2][maxValue*number+1];
        for(int i = 0; i < probabilities[0].length; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        int flag = 0;
        //初始化，当骰子数为１时
        for(int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        //抛出2-number个骰子
        for(int k = 2; k <= number; k++) {
            for(int i = 0; i < k; i++) {
                //抛出k个骰子，那么0-k-1出现的次数都是０
                probabilities[1-flag][i] = 0;
            }
            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        int total = 1;
        for(int i = 1; i <= number; i++) {
            total *= maxValue;
        }

        for(int i = number; i <= number*maxValue; i++) {
            double ratio = (double)probabilities[flag][i]/total;
            System.out.printf("%-8.4f", ratio);
        }
    }
}
