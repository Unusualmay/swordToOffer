package offer;

import java.util.ArrayList;
import java.util.List;

public class LastNumberInCircle_45 {
    public static void main(String[] args) {
        LastNumberInCircle_45 lnic = new LastNumberInCircle_45();
        int result = lnic.lastRemaining(10,10);
        System.out.println(result);
        int result_1 = lnic.lastRemaining_1(10,10);
        System.out.println(result);
    }

    /**
     * 方法１：经典的解法，用环形链表模拟圆圈，时间复杂度o(mn)
     * 这里不一定要真正意义上实现环形链表，学会找到规律，这里明显可以用list集合
     * 总结：以后对环形链表的操作可以转换为对集合list的操作
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        if (n == 0) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1) {
            for(int i = 1; i < m; i++) {
                index = (index + 1)%list.size();
            }
            list.remove(index);
        }
        return list.get(0);

    }

    /**
     * 此方法是基于数学归纳的方法
     * 时间复杂度为o(n)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for(int i = 2; i <= n; i++) {
            last = (last+m)%i;
        }
        return last;
    }

}
