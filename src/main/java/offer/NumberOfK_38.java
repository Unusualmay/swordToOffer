package offer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class NumberOfK_38 {
    public static void main(String[] args) {
        NumberOfK_38 nk = new NumberOfK_38();
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        int number = nk.getNumberOfK(arr,3);
        System.out.println("3的个数："+nk.getNumberOfK(arr,3));
    }

    public int getFirstK(int[] arr, int start, int end, int k ) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midData = arr[mid];
        if (midData == k) {
            if (mid == 0 || (mid > 0 && arr[mid - 1] != k)){
                return mid;
            } else {
                end = mid-1;
            }
        }else {
            if (midData < k) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return getFirstK(arr,start,end,k);
    }

    public int getLastK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end)/2;
        int midData = arr[mid];
        if (midData == k) {
            if (mid == arr.length - 1 || (mid < arr.length-1 && arr[mid + 1] != k)){
                return mid;
            } else {
                start = mid+1;
            }
        }else {
            if (midData < k) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return getLastK(arr,start,end,k);
    }

    public int getNumberOfK(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int startIndex = getFirstK(arr,0,arr.length-1,k);
        int endIndex = getLastK(arr,0,arr.length-1,k);
        int number = 0;
        if (startIndex > -1 && endIndex > -1) {
            number = endIndex - startIndex + 1;
        }
        return number;
    }
}
