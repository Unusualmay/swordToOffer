package sort;

import java.util.Map;

/**
 * 归并排序的思想是先拆开，再合并
 */

/**
 * 归并的思想就是：先递“归”成子数组，再合“并”
 * 1.对于两个有序的数组，要将其合并为一个有序数组，我们可以很容易地写出merge();
 * 2.假如有一个无序数组需要排序，但它的两个完全划分的子数组A和B分别有序，
 *  借助上述代码，我们也可以很容易写出mergeSort()；
 * 3.那么，如果A,B无序，可以把它们再分成更小的数组。递归调用mergeSort();
 * 4.如此一直划分到最小，每个子数组都只有一个元素，则可以视为有序数组。
 * 5.从这些最小的数组开始，逆着上面的步骤合并回去，整个数组就排好了。
 总而言之，归并排序就是使用递归，先分解数组为子数组，再合并数组。
 */

/**
 * 归并排序它是基于分治的思想，和快排的思想是一样的，而且他们俩的时间复杂度都是o(nlogn)，
 * 而且都是会改变原有数组
 */

/**
 * 总结
 * 递归的方法和迭代的方法在时间复杂度上都是一样的，都是o(nlogn)
 * 但是空间复杂度是不一样的，递归的情况下，需要：存放归并结果的存储空间o(n)+递归时深度为o(logn)
 * 的栈空间，因此空间复杂度是o(n+logn)
 *
 * 但是迭代的情况下：只需要存放归并结果的o(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{50,10,90,30,70,40,64,28,97,41,12,80,60,20};
//        ms.mergeSort(arr,0,arr.length-1);
        ms.mergeSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    /**
     * 将有序的arr[i,...,m]和arr[m+1,...n]归并为有序的arr[i,...,n]
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public void merge(int[] arr, int start, int mid, int end) {
        int k;
        int j;
        int i = start;
        int[] tempArr = new int[end-start+1];
        //注意数组tempArr的下标必须从０开始，因为从i开始的话，会导致数组越界
        for(k = 0, j = mid+1; j <= end && i <= mid; k++) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
            }
        }
        while(i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while(j <= end) {
            tempArr[k++] = arr[j++];
        }
        for(int x = 0; x < tempArr.length; x++) {
            arr[x+start] = tempArr[x];
        }
    }

    /**
     * 重载的方法
     * @param arr
     */
    public void mergeSort(int[] arr) {
        int num = 1;
        int length = arr.length;
        while(num < length) {
            mergePass(arr, num, length);
            num = num*2;
        }
    }

    /**
     * 非递归的方法实现归并排序
     * 非递归的迭代做法更加直截了当，从最小的序列开始归并，不需要像递归算法那样，
     * 先拆分，再归并再退出递归
     * @param arr
     * @param num 一次选择num长的进行归并
     * @param length
     */
    public void mergePass(int[] arr, int num, int length) {
        int i = 0;
        while (i < length-2*num+1) {
            merge(arr,i,i+num-1,i+2*num-1);
            i = i + 2 * num;
        }
        if (i < length-num+1) {
            merge(arr,i,i+num-1,length-1);
        }
    }
}
