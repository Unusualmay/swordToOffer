package offer;

public class QuickSort_29 {
    public static void main(String[] args) {
        int[] a = new int[]{50,10,90,30,70,40,80,60,20};
        QuickSort_29 qs = new QuickSort_29();
        qs.sort(a,0,a.length-1);
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
}
