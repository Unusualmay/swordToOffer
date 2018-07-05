package offer;

/**
 * 链表中环的入口结点
 * 总结：以后求环形链表的长度，可以定义一个快指针和一个慢指针,
 * 这样就可以得到一个环形链表中两个相遇的点；然后再遍历一次，就
 * 可以得到环形链表中结点的数目
 */
public class EntryNodeInListLoop_56 {
    public static void main(String[] args) {
        EntryNodeInListLoop_56 enol = new EntryNodeInListLoop_56();
        Node node6 = new Node(6,null);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        node6.setNext(node3);
        Node entryNode = enol.entryNodeOfLoop(node1);
        System.out.println(entryNode.getData());
    }

    /**
     * 得到环中的任一结点信息
     * @param root
     * @return
     */
    public Node meetingNode(Node root) {
        Node<Integer> fast = root;
        Node<Integer> slow = root;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                break;
            }
        }
        return fast;
    }

    public Node entryNodeOfLoop(Node root) {
        Node meetNode = meetingNode(root);
        //这个链表没有环形的链表
        if (meetNode == null) {
            return null;
        }
        //找到环形链表的结点数
        int numsOfNodeOfLoop = 1;
        Node node = meetNode.next;
        while (node != meetNode) {
            numsOfNodeOfLoop++;
            node = node.next;
        }
        //node1先走numsOfNodeOfLoop(环形链表的结点数)的步数
        Node node1 = root;
        Node node2 = root;
        for (int i = 0; i < numsOfNodeOfLoop; i++) {
            node1 = node1.next;
        }
        //node1和node2一起走，它们相遇时的结点就是环形链表的入口
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
