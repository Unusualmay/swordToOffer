package offer;

public class TwoNumbersWithSum_41_1 {
    public static void main(String[] args) {
        TwoNumbersWithSum_41_1 tws1 = new TwoNumbersWithSum_41_1();
        int[] arr = new int[]{0,1,2,4,7,11,12,13};
        tws1.findNumberWithSum(arr,15);
    }

    public void findNumberWithSum(int[] arr, int sum) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int start = 0;
        int end = arr.length-1;
        while(start < end) {
            if (arr[start] + arr[end] > sum) {
                end--;
            } else if (arr[start] + arr[end] < sum){
                start++;
            } else {
                break;
            }
        }
        System.out.println("start:"+arr[start]);
        System.out.println("end:"+arr[end]);
    }
}
