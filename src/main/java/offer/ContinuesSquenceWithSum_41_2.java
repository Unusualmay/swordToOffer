package offer;

/**
 * 打印处所有和为sum的连续正数序列的数组
 */
public class ContinuesSquenceWithSum_41_2 {
    public static void main(String[] args) {
        ContinuesSquenceWithSum_41_2 csw = new ContinuesSquenceWithSum_41_2();
//        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
//        csw.findContinueSquenceInArr(arr,9);
        csw.findContinueSquence(100);
    }

    /**
     * 这是打印一个数组中，连续子数组的和等于sum的数
     * @param arr
     * @param sum
     */

    public void findContinueSquenceInArr(int[] arr, int sum) {
        if (arr==null || arr.length<=0) {
            return;
        }
        int start = 0;
        int end = 1;
        while(start<end && end<arr.length) {
            int num = 0;
            for(int i = start; i <= end; i++) {
                num += arr[i];
            }
            if (num < sum) {
                end++;
            } else if (num > sum) {
                start++;
            } else {
                for(int j = start; j <= end; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                end++;
            }
        }
    }

    /**
     * 这是输入一个正数s，打印出所有和为s的连续正数序列(至少含有两个数)
     * @param s
     */
    public void findContinueSquence(int s) {
        int start = 1;
        int end = 2;
        //因为至少要含有两个数，所以start<(s+1)/2
        while(start < (s+1)/2 && start <= end) {
            int num = 0;
            for(int i = start; i <= end; i++) {
                num += i;
            }
            if (num < s) {
                end++;
            } else if (num > s) {
                start++;
            } else if (num==s){
                for(int j = start; j <= end; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
                end++;
            }
        }
    }
}
