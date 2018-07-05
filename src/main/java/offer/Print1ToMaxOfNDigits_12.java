package offer;

import java.util.Scanner;

public class Print1ToMaxOfNDigits_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        print1ToN(n);
        print1ToN2(n);
    }

    /**
     * 方法1，利用循环的方式
     * @param num
     */
    public static void print1ToN(int num) {
        if (num <= 0) {
            System.out.println("输入的参数不合法");
            return;
        }
        int[] arr = new int[num+1];//int型的数组可以不进行初始化，默认初始值是0
        while (arr[0] != 1) {
            //数组加1
            increaseArrBy1(arr);
            //数组显示，如果最高位等于了1（arr[0]=1），则跳出循环
            if (arr[0] == 1) {
                break;
            }
            printArr(arr);
        }
    }
    public static void increaseArrBy1(int[] arr) {
        //加1的原理是每次都在最右边的一位上加1，continue是跳出{}的内容
        for(int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
                continue;
            }
            else {
                arr[i] += 1;
                //每次只增加1，所以要跳出大循环
                break;
            }
        }
    }
    public static void printArr(int[] arr) {
        //先去除前面的0
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        while (i < arr.length) {
            System.out.print(arr[i]);
            i++;
        }
        System.out.println();
    }
//迭代肯定是要迭代到最小的
    public static void print1ToN2 (int num) {
        int[] arr = new int[num];
        if (num < 0) {
            return;
        }
        print1ToNByTraverse(arr, 0);
    }
    public static void print1ToNByTraverse(int[] arr, int index) {
        if (index == arr.length) {
            printArr(arr);
        }
        if (index < arr.length) {
            for (int i = 0; i < 10; i++) {
                arr[index] = i;
                print1ToNByTraverse(arr, index+1);
            }
        }
    }
}
