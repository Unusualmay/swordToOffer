package sort;

/**
 * 快速排序的时间复杂度是n*logn
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,2,5,7,6,3,9,1,8};
        QuickSort qs = new QuickSort();
//        qs.sort(a,0,a.length-1);
        qs.quickSort(a,0,a.length-1);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public void sort(int[] a,int low, int high) {
        if (a == null||low>=high) {
            return;
        }
        int index;
        if (low < high) {
            index = partition(a,low,high);
            sort(a,low,index);
            sort(a,index+1,high);
        }
    }
    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while(low < high) {
            while(low < high && a[high] >= pivot) {
                high--;
            }
            swap(a,low,high);
            while(low < high && a[low] <= pivot) {
                low++;
            }
            swap(a,low,high);
        }
        return low;
    }
    public void swap(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    public void quickSort(int[] a,int start, int end) {
        if (start < end) {
            int pivot = a[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && a[end] >= pivot) {
                    end--;
                }
                swap(a, start, end);
                while (start < end && a[start] <= pivot) {
                    start++;
                }
                swap(a, start, end);
            }
            quickSort(a,left,start);
            quickSort(a,start+1,right);
        }
        return;
    }
}
