package offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicationInArray_51 {
    public static void main(String[] args) {
        DuplicationInArray_51 d = new DuplicationInArray_51();
        int[] arr = new int[]{2,3,1,0,2,5,3};
        //方法１
        d.duplicate_1(arr);
        System.out.println("---------------------");
        d.duplicate_2(arr);
        System.out.println("---------------------");
        d.duplicate_3(arr);
    }

    /**
     * 方法１：利用快排先排序
     * 时间复杂度：o(nlogn)
     * 空间复杂度o(1)
     */
    public void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 0 || start > end) {
            return;
        }
        if (start < end) {
            int left = start;
            int right = end;
            int pivot = arr[start];
            while (start < end) {
                while (start < end && arr[end] >= pivot) {
                    end--;
                }
                swap(arr,start,end);
                while (start < end && arr[start] <= pivot) {
                    start++;
                }
                swap(arr,start,end);
            }
            quickSort(arr,left,start);
            quickSort(arr,start+1,right);
        } else {
            return;
        }
    }

    public void duplicate_1(int[] arr) {
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                System.out.println(arr[i]);
                continue;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 方法２：利用哈希表
     * 时间复杂度是o(n)
     * 空间复杂度是o(1)
     * @param arr
     */
    public void duplicate_2(int[] arr) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i]) + 1);
            } else {
                map.put(arr[i],1);
            }
        }

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if ((Integer)entry.getValue()>1) {
                System.out.println(entry.getKey());
            }
        }
    }

    /**
     * 方法３：重排数组
     * 时间复杂度o(n)
     * 空间复杂度o(1)
     * @param arr
     */
    public void duplicate_3(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int i = 0;
        while (i < arr.length) {
            if (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println(arr[i]);
                    i++;
                    continue;
                }
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
    }
}
