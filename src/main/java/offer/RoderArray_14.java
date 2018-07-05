package offer;

public class RoderArray_14 {
    public static void roderArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start < end) {
            //先往前找到第一个偶数
            while(arr[start]%2 == 1 && start < end) {
                start++;
            }
            /*
             *方法1：利用while循环
             */
//            //往后找到第一个奇数
//            while(arr[end]%2 == 0 && start < end) {
//                end--;
//            }
//            if (start < end) {
//                int temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//                start++;
//                end--;
//            }
            /*
             *方法2：利用if条件判断语句
             */
            if(arr[end]%2 == 1 && start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else {
                end--;
            }
        }
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println("-----------");
//        printArr(arr);
        roderArray(arr);
        printArr(arr);
    }
}
