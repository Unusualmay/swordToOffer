package offer;

/**
 * 利用归并排序的原理
 * 时间复杂度是o(nlogn)
 * 空间复杂度是o(n)
 */
public class InversePairs_36 {
    int nums = 0;
    public static void main(String[] args) {
        InversePairs_36 ip = new InversePairs_36();
        int[] arr = new int[]{7,5,6,2,10,9,8,1,4};
        ip.inversePairs(arr,0,arr.length-1);
        System.out.println(ip.nums);
    }

    public void inversePairs(int[] arr, int start, int end) {
        if (arr == null || start >= end || arr.length < 0) {
            return;
        }
        if (start < end) {
            int mid = (start + end) / 2;
            inversePairs(arr, start, mid);
            inversePairs(arr, mid+1, end);
            merge(arr,start,mid,end);
        }
    }

    /**
     * 利用归并排序的原理
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[end-start+1];//辅助的数组
        int i = mid;
        int j = end;
        int k = tempArr.length-1;
        for(; i >= start && j > mid; k--) {
            if (arr[i] > arr[j]) {
                tempArr[k] = arr[i];//当左边序列的值，大于右边序列的值，则左边序列大于右边序列的值之前的全部值
                nums += j - mid;
                i--;
            } else {
                tempArr[k] = arr[j];
                j--;
            }
        }

        while (i >= start) {
            tempArr[k--] = arr[i--];
        }

        while (j > mid) {
            tempArr[k--] = arr[j--];
        }
        for(int x = 0; x < tempArr.length; x++) {
            arr[x+start] = tempArr[x];
        }
    }
}
