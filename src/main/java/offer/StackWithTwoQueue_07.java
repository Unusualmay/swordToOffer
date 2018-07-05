package offer;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue_07 {
    public static void main(String[] args) {
        StackWithTwoQueue_07 swtq = new StackWithTwoQueue_07();
        swtq.push(1);
        swtq.push(2);
        swtq.push(3);
        System.out.println(swtq.pop());
        System.out.println(swtq.pop());

    }
    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();
    public void push(int num) {
        if (queue1.size() != 0) {
            queue1.offer(num);
        } else {
            queue2.offer(num);
        }
    }

    public Integer pop() {
        if (queue1.size() != 0) {
            while (queue1.size() != 1) {
                int temp = (Integer) queue1.poll();
                queue2.add(temp);
            }
            return (Integer) queue1.poll();
        } else {
            while (queue2.size() != 1) {
                int temp = (Integer) queue2.poll();
                queue1.add(temp);
            }
            return (Integer) queue2.poll();
        }
    }
}
