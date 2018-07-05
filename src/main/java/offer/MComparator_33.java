package offer;

import java.util.Comparator;
/**
 * 这个题目从本质上而言就是考察排序，只是重新定义了一下">","<","="的意思
 * 例如：431,43,因为43143<43431,所以431<43,这就是我们重新定义的"<"的意思
 */

/**
 * 自定义一个排序比较器
 */
public class MComparator_33 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if (o1==null || o2 == null) {
            throw new IllegalArgumentException("非法的输入");
        }
        return (o1+""+o2).compareTo(o2+""+o1);
    }

    /**
     * 升级版快速排序
     * @param arr
     * @param start
     * @param end
     * @param comparator
     */
    public void quickSort(int[] arr, int start, int end, Comparator comparator) {
        if (start < end) {
            int pivot = arr[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && comparator.compare(arr[end], pivot) >= 0) {
                    end--;
                }
                swap(arr, start, end);
                while (start < end && comparator.compare(arr[start], pivot) <= 0) {
                    start++;
                }
                swap(arr, start, end);
            }
            quickSort(arr,left,start,comparator);
            quickSort(arr,start+1,right,comparator);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printMinNumber(int[] arr, Comparator comparator) {
        quickSort(arr,0,arr.length-1,comparator);
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        MComparator_33 mc = new MComparator_33();
        int[] arr = new int[]{32,31,45,4,52};
        mc.printMinNumber(arr,mc);
    }
}
