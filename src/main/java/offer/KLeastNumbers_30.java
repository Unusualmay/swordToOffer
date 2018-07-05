package offer;

public class KLeastNumbers_30 {
    public static void main(String[] args) {
        KLeastNumbers_30 kn = new KLeastNumbers_30();
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        kn.findK(a,0,a.length-1,4);
        for(int i = 0; i < 4; i++) {
            System.out.println(a[i]);
        }

    }
    /**
     * 此解法还是基于partition()方法，找到index为k-1的情况，则从0～k-1的k个数就是最小的k个数
     * 这k个数不一定按照顺序来进行排列，但是最小的k个数
     */
    /**
     * 这种基于partition()的方法会改变数组的顺序，有时候面试官可能要求不改变数组的顺序，则需要
     * 考虑别的方法
     */
    public void findK(int[] a, int low, int high, int k) {
        if (a==null || a.length <= 0 || k < 1 || high <= low) {
            System.out.println("输入的参数不合理");
            return;
        }
        int index = partition(a,low,high);
        if (index != k-1) {
            if (index >= k-1) {
                findK(a, low, index, k);
            } else {
                findK(a, index + 1, high, k);
            }
        }
    }
    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while(low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            swap(a, low, high);
            while (low < high && a[low] <= pivot) {
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }
    public void swap(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }
}
