package offer;

import java.util.Stack;

public class FirstCommonNodesInLists_37 {
    public static void main(String[] args) {
        Node_13 node7 = new Node_13(7,null);
        Node_13 node6 = new Node_13(6,node7);
        Node_13 node5 = new Node_13(5,node6);
        Node_13 node4 = new Node_13(4,node5);
        Node_13 node3 = new Node_13(3,node6);
        Node_13 node2 = new Node_13(2,node3);
        Node_13 node1 = new Node_13(1,node2);
        FirstCommonNodesInLists_37 fcni = new FirstCommonNodesInLists_37();
        Node_13 result = fcni.findFirstCommonNode1(node1,node4);
        System.out.println(result.getData());
    }

    /**
     * 方法一：利用栈的原理,需要用到辅助栈
     * 时间复杂度是o(m+n)
     * 空间复杂度是o(m+n)
     * @param head1
     * @param head2
     * @return
     */
    public Node_13 findFirstCommonNode(Node_13 head1, Node_13 head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<Node_13> stack1 = new Stack<>();
        Stack<Node_13> stack2 = new Stack<>();
        Node_13 node1 = head1;
        Node_13 node2 = head2;
        Node_13 result = null;
        while(node1 != null) {
            stack1.push(node1);
            node1 = node1.getNext();
        }
        while(node2 != null) {
            stack2.push(node2);
            node2 = node2.getNext();
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek()== stack2.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                result = stack1.peek().getNext();
                break;
            }
        }
        return result;
    }

    /**
     * 方法２：不需要用到辅助栈，只需要先将链表较长的那个先遍历到与第二个链表等长的位置即可
     * 时间复杂度：o(m+n)
     * 空间复杂度o()
     * @param head1
     * @param head2
     * @return
     */

    public Node_13 findFirstCommonNode1(Node_13 head1, Node_13 head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node_13 result = null;
        Node_13 node1 = head1;
        Node_13 node2 = head2;
        int length1 = 0;
        int length2 = 0;
        while(node1 != null) {
            length1++;
            node1 = node1.getNext();
        }
        while(node2 != null) {
            length2++;
            node2 = node2.getNext();
        }
        node1 = head1;
        node2 = head2;
        int lengthDif = Math.abs(length1-length2);
        if (length1 > length2) {
            for(int i = 0; i < lengthDif; i++) {
                node1 = node1.getNext();
            }
        } else {
            for (int i = 0; i < lengthDif; i++) {
                node2 = node2.getNext();
            }
        }
        for(int j = 0; j < min(length1,length2); j++) {
            if (node1 == node2) {
                result = node1;
                break;
            } else {
                node1 = node1.getNext();
                node2 = node2.getNext();
            }
        }
        return result;
    }

    public int min(int i, int j) {
        if (i > j) {
            return j;
        } else {
            return i;
        }
    }
}
