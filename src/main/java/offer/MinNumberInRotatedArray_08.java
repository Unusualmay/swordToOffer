public class MinNumberInRotatedArray_08 {
    public static void main(String[] args) {
        int[] arr = new int[] {3,4,5,1,2};
        System.out.println(minNumber(arr));

    }
    public static int minNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = arr.length-1;
        int min = arr[p1];
        int mid = 0;
        while(arr[p1] >= arr[p2]) {
            if(p1+1 == p2) {
                min = arr[p2];
                break;
            }
            mid = (p1 + p2)/2;
            //为什么相等时的遍历是完全遍历呢？
            if(arr[mid]==arr[p1] && arr[mid]==arr[p2]) {
                int mintemp = arr[p1];
                for(int i = p1+1; i < p2; i++) {
                    if (arr[i] < mintemp) {
                        mintemp = arr[i];
                    }
                }
                min = mintemp;
            }
            if(arr[mid] > arr[p1]) {//如果中间的值在数组１，则将p1的位置移到mid
                p1 = mid;
            }
            if(arr[mid] < arr[p2]) {//如果中间的值在数组2，则将p2的位置移到mid
                p2 = mid;
            }
        }
        return min;
    }
}
