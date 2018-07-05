package offer;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayForMinNumber_33 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{312,32,321};
        SortArrayForMinNumber_33 safm = new SortArrayForMinNumber_33();
        safm.printMinNumber(nums);
    }

    public void printMinNumber(Integer[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        /**
         * 利用数组中自带的排序方法，根据规则，来堆nums进行排序，将其按照我们想要的大小进行排序
         * 即ab>ba，则认为a>b，例如32,3,此时323<332，那么认为3>32
         */
        /**
         * 自带的排序比较器，这个排序比较器里面自带的是归并排序
         */
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+""+o2).compareTo(o2+""+o1);//返回两个数之间的差值
            }
        });
        String s = new String();
        for(int i = 0; i < nums.length; i++) {
            s+=nums[i];
        }
        System.out.println(s);
    }
}
