package offer;

/**
 * 求出最小的k个数，这种方法不会改变原有数组，但是会创建一个容量为k的容器
 * 现将容器装满,然后每个数都和容器的最大值进行比较，如果比容器的最大值要大的话，
 * 那么就把这个最大值替换
 */

/**
 * 这里将容器变为最大堆的形式，这样，每次就只用替换掉第一个数
 * 但是替换掉第一个数之后，又要重新创建最大堆
 */
public class KLeastNumbers1_30 {
    public static void main(String[] args) {
        int[] arr = new int[] {8,5,1,6,4,7,3,8};
        KLeastNumbers1_30 kln1 = new KLeastNumbers1_30();
        int[] result = kln1.kLeastNUmber(arr,4);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] kLeastNUmber(int[] arr,int k) {
        int[] result = new int[k];
        int i;
        for(i = 0; i< k; i++) {
            result[i] = arr[i];
        }
        for (int x = i; x < arr.length; x++) {
            //每次都要重新创建最大堆，共有k/2层
            for (int j = (k-1) / 2; j >= 0; j--) {
                makeMaxHeap(result, j, k);
            }
            //每次和最大堆的根节点进行比较，如果比根节点小就要更换
            if (arr[x] < result[0]) {
                result[0] = arr[x];
            }
        }
        return result;
    }

    /**
     * 创建最大堆
     * @param arr
     * @param index
     * @param length
     */
    public void makeMaxHeap(int[] arr, int index, int length) {
        int child = index * 2 +1;
        if (child >= length) {
            return;
        }
        if (child + 1<length && arr[child] < arr[child+1]) {
            child++;
        }
        if (arr[child] > arr[index]) {
            swap(arr,index,child);
            makeMaxHeap(arr,child,length);
        } else {
            return;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
