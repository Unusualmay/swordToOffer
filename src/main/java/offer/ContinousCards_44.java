package offer;

public class ContinousCards_44 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,2,4,5};
        ContinousCards_44 cc = new ContinousCards_44();
        System.out.println(cc.isContinous(arr));
    }
    public boolean isContinous(int[] arr) {
        if (arr == null) {
            return false;
        }
        //1.先排序(快排)
        quickSort(arr,0,arr.length-1);
        //2.再统计数组中0的个数
        int numOf0 = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numOf0++;
            } else {
                break;
            }
        }
        //3.统计数组中相邻数字之间的空缺总数
        int numOfTab = 0;
        for (int i = numOf0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                return false;
            } else if (arr[i]+1 < arr[i+1]) {
                numOfTab++;
            }
        }
        System.out.println(numOf0);
        System.out.println(numOfTab);
        if (numOf0 >= numOfTab) {
            return true;
        } else {
            return false;
        }
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int left = start;
            int right = end;
            int pivot = arr[start];
            while (start < end) {
                while (arr[end] >= pivot && start < end) {
                    end--;
                }
                swap(arr, start, end);
                while (arr[start] <= pivot && start < end) {
                    start++;
                }
                swap(arr, start, end);
            }
            quickSort(arr,left,start);
            quickSort(arr,start+1,right);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
