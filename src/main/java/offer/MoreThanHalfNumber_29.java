package offer;

/**
 * 基于快速排序算法中的partition()算法，但是可以不必全部排序出来
 * 一趟排序就是调用一次partition(),它将待排序记录分割成独立的两部分，
 * 其中一部分关键字均比另一部分关键字小，则可以分别对这两部分记录继续进行排序
 * 而我们此题的目的是找出中位数，所以不需要全部排序，找出中位数，此中位数就是超过数组长度一半的数字
 */
public class MoreThanHalfNumber_29 {
    public static void main(String[] args) {
        int[] a = new int[] {9,2,3,2,2,2,5,4,2,9,2,2,2,7};
        MoreThanHalfNumber_29 mthn = new MoreThanHalfNumber_29();
        int result = mthn.moreThanHalf(a);
        boolean isMOreThanHalf = mthn.checkMoreThanHalf(result,a);
        if (isMOreThanHalf) {
            System.out.println("找到了该数字："+result);
        } else {
            System.out.println("不存在该数字大于数组长度的一半");
        }

    }
    public int moreThanHalf(int[] a) {
        if (invalidArray(a)) {
            System.out.println("输入数组不合法");
            return 0;
        }
        findMiddle(a,0,a.length-1);
        for(int i = 0; i < a.length; i++) {
            System.out.println("a:"+a[i]);
        }
       return a[(a.length-1)/2];
    }
    public void findMiddle(int[] a, int low, int high) {
        if (a == null || a.length <= 0 || high <= low) {
            return;
        }
        int middle = a.length>>1;
        int index = partition(a,low,high);
        if (index != middle) {//因为只需要中位数，所以我们只需要排序到中位数即可
            if (index >= middle) {
                findMiddle(a,low,index);
            } else {
                findMiddle(a, index + 1, high);
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
    public boolean invalidArray(int[] a) {
        boolean isInvalid = false;
        if (a==null || a.length <= 0) {
            isInvalid = true;
        }
        return isInvalid;
    }
    /**
     * 检查从数组中得到的数字，它的长度是否大于数组长度的一半，这是结果检测
     */
    public boolean checkMoreThanHalf(int num, int[] a) {
        int times = 0;
        boolean isMOreThanHalf = false;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                times++;
            }
        }
        if (times*2 > a.length) {
            isMOreThanHalf = true;
        }
        return isMOreThanHalf;
    }
}
