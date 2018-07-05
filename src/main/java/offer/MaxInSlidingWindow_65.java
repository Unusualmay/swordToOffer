package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现滑动窗口的最大值
 * 设置一个双向的队列，它用于存储最大值的索引
 * 设置一个数组List用于存储滑动窗口的最大值
 */
public class MaxInSlidingWindow_65 {
    public static void main(String[] args) {
        MaxInSlidingWindow_65 misw = new MaxInSlidingWindow_65();
        List data = new LinkedList();
        int[] arr = new int[] {2,3,4,2,6,2,5,1};
        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }
        List maxInWindows = misw.maxInWindows(data,3);
        for (int i = 0; i < maxInWindows.size(); i++) {
            System.out.print(maxInWindows.get(i) + "\t");
        }
    }

    public List maxInWindows (List<Integer> data, int windowSize) {
        //用于存储滑动窗口的最大值
        List maxInWindows = new LinkedList();
        if (data == null || data.size() < 1 || windowSize < 1) {
            return maxInWindows;
        }
        //一个双向队列用于存储滑动窗口最大值的索引
        Deque<Integer> index = new LinkedList<Integer>();
        //窗口还没有被填满，存储的是索引
        for (int i = 0; i < windowSize && i < data.size(); i++) {
            while (!index.isEmpty() && data.get(i) >= data.get(index.getLast())) {
                index.removeLast();
            }
            index.addLast(i);
        }
        //窗口被填满了
        for (int i = windowSize; i < data.size(); i++) {
            maxInWindows.add(data.get(index.getFirst()));
            while (!index.isEmpty() && data.get(i) >= data.get(index.getLast())) {
                index.removeLast();
            }
            if (!index.isEmpty()&&index.getFirst() <= i-windowSize) {
                index.removeFirst();
            }
            index.addLast(i);
        }
        //最后一个值最大值也要传进去
        maxInWindows.add(data.get(index.getFirst()));
        return maxInWindows;
    }
}
