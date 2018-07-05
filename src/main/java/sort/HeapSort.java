package sort;

/**
 * 最大堆和最小堆都是完全二叉树
 * 最大堆的性质：
 * 所谓最大堆的性质，就是子节点的值都小于父节点的值
 * 最小堆的性质：
 * 所谓最小堆的性质，就是子节点的值都大于父节点的值
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[] {90,70,80,60,10,40,50,30,20};
//        int[] arr = new int[] {4,5,1,6,2,7,3,8};
        HeapSort hs = new HeapSort();
        hs.buildMaxHeap(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 建立最大堆，以及进行堆的排序,递归的方法
     * @param arr
     */
    public void buildMaxHeap(int[] arr) {
        if (arr == null) {
            return;
        }
        //建立最大堆，必须从下往上
        for(int i=(arr.length-1)/2; i >= 0; i--) {
            maxHeapSort(arr,i,arr.length);
        }

        //堆排序(递归的方法)
        for(int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);//交换堆顶和第i个数
            maxHeapSort(arr,0,i);
        }
    }

    /**
     * 非递归的方法实现建立最大堆，以及进行堆排序
     * @param arr
     */
    public void buildMaxHeap1(int[] arr) {
        if (arr == null) {
            return;
        }
        //建立最大堆，共ｉ层,必须从下往上
        for(int i = (arr.length-1)/2; i >=0 ; i--) {
            maxHeapSort1(arr,i,arr.length);
        }
        //堆排序，非递归的方法
        for(int i = arr.length-1; i > 0; i--) {
            swap(arr,0,i);
            maxHeapSort1(arr,0,i);
        }
    }

    /**
     * 递归的形式来进行最大堆的排序
     * @param arr
     * @param index
     * @param length
     */
    public void maxHeapSort(int[] arr, int index, int length) {
        int leftChild = index * 2 + 1;//堆的性质
        int child = leftChild;
        if (child >= length) {
            return;
        }
        if(child+1 < length && arr[child] < arr[child+1]) {
            child++;
        }
        /**
         * 将堆顶和较大的孩子结点进行交换
         */
        if (arr[child] > arr[index]) {
            swap(arr,child,index);
            maxHeapSort(arr,child,length);
        } else {
            return;
        }

    }

    /**
     * 循环的方法来实现创建最大堆
     * @param arr
     * @param index
     * @param length
     */
    public void maxHeapSort1(int[] arr, int index, int length) {
        int child;
        for(child = 2* index + 1; child < length; child = leftChild(child)) {
            if (child + 1 < length && arr[child] < arr[child+1]) {
                child++;
            }
            if (arr[child] < arr[index]) {
                break;
            }
            swap(arr,index,child);
            index = child;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public int leftChild(int i) {
        return i*2+1;
    }
}
