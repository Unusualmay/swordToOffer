package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian_64 {
    public static void main(String[] args) {
        StreamMedian_64 sm = new StreamMedian_64();
        sm.insert(2);
        sm.insert(5);
        sm.insert(3);
        sm.insert(8);
        sm.insert(18);
        sm.insert(23);
        sm.insert(14);
        sm.insert(21);
        sm.insert(10);
        sm.insert(11);
        sm.insert(0);
        sm.insert(6);
        sm.insert(7);
        sm.insert(1);
        sm.insert(4);
        sm.insert(9);
        System.out.println(sm.count-1);
        System.out.println(sm.getMedian());
    }

    private int count = 1;
    //PriorityQueue 实例化对象出来是默认的最小堆，它的逻辑结构是最小堆，但是存储结构是数组
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //加入比较器之后是最大堆的形式，它的逻辑结构是最大堆，但是存储结构是数组
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void insert(Integer num) {
        /**
         * 最大堆是左边的数据，最小堆是右边的数据
         */
        if (count % 2 == 0) {
            //如果是总个数是偶数就插入到最小堆，但是此时要先插入到最大堆中，
            // 将最大堆的数据再插入到最小堆中
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            //如果此时的总个数是奇数，那就插入到最大值，但是此时要插入到最小堆中
            //将最小堆的数据在插入到最大堆中
            minHeap.offer(num);
            int filterMinNum = minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count++;//到了最后总个数还加了１
    }

    public Double getMedian() {
        if (count%2 == 1) {//如果总的个数是偶数个，那么中位数就是最大堆和最小堆的平均值
            return new Double((minHeap.peek() + maxHeap.peek()))/2;
        } else {//如果总的个数是奇数，那么中位数就是最大堆的堆顶
            return new Double(maxHeap.peek());
        }
    }
}