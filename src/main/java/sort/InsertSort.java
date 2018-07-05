package sort;

/**
 * 直接插入排序算法，时间复杂度是O(n^2),同样的时间复杂度，
 * 插入排序比冒泡排序以及简单选择排序的性能要好一些。
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort is = new InsertSort();
        int[] a = new int[]{8,2,4,9,5,6};
        is.insertSort(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public void insertSort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int temp = 0;//设置一个哨兵，使得它等于比前面数小的数
        for(int i = 1; i < a.length; i++) {//外层循环用于比较每一个数的大小
            if (a[i] < a[i-1]) {
                temp = a[i];
                int j = 0;
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {//内层循环用于移动
                    a[j + 1] = a[j];
                }
                a[j+1] = temp;
            }
        }
    }
}
