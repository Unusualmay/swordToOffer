package offer;

public class KthNodeFromEnd_15 {
    /**
     * 返回倒数第k个结点的信息
     * @param headList
     * @param k
     * @return
     */
    public static Node_13 kthNodeFromEnd(Node_13 headList, int k) {
        /*
         * 如果输入的参数不合理，要进行相应的处理，以此来增强代码的鲁棒性
         */
        if (headList == null) {
            return null;
        }
        if (k == 0) {
            return null;
        }
        Node_13 p1 = headList;
        Node_13 p2 = headList;
        /*
         * 如果输入的k要大于链表的结点数，要进行处理以此来提高代码的鲁棒性
         */
        for(int i = 0; i < k-1; i++) {
            if (p1.getNext() != null) {
                p1 = p1.getNext();
            } else {
                return null;
            }

        }
        while(p1.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        System.out.println(p2.getData());
        return p2;
    }

    /**
     * 返回中间结点的信息，如果结点数是奇数，则返回中间的结点，
     * 如果结点数是偶数，则返回中间两个结点的任意一个结点的信息即可
     * @param headList
     * @return
     */
    public static Node_13 findMidNode(Node_13 headList) {
        if(headList == null) {
            return null;
        }
        Node_13 p1 = headList;
        Node_13 p2 = headList;
        while (p1.getNext() != null) {
           if (p1.getNext().getNext() != null) {
               p1 = p1.getNext().getNext();
               System.out.println("p1.data="+p1.getData());
               p2 = p2.getNext();
               System.out.println("p2.data="+p2.getData());
           } else {
               p1 =p1.getNext();
               System.out.println("p1.endData=" + p1.getData());
           }
        }
        System.out.println(p2.getData());
        return p2;
    }

    public static void isCircleList(Node_13 headList) {
        Node_13 p1 = headList;
        Node_13 p2 = headList;
        int i = 0;
        while(p1.getNext() != null) {
            if (p1.getNext().getNext() != null) {
                p1 = p1.getNext().getNext();
                p2 = p2.getNext();
            } else {
                p1 = p1.getNext();
            }
//            System.out.println("这里执行了：" + ++i + "次");
            if (p1 == p2) {
                System.out.println("这是个环形的链表");
                break;
            }
        }

    }
    public static void main(String[] args) {
        Node_13 node6 = new Node_13(6, null);
        Node_13 node5 = new Node_13(5, node6);
        Node_13 node4 = new Node_13(4, node5);
        Node_13 node3 = new Node_13(3, node4);
        Node_13 node2 = new Node_13(2, node3);
        Node_13 node1 = new Node_13(1, node2);//这是头结点
        node6.setNext(node1);
//        Node_13 node = node1;
//        while (node.getNext() != null) {
//            System.out.println(node.getData());
//            node = node.getNext();
//        }
//        Node_13 kthNode = kthNodeFromEnd(node1, 3);
//        Node_13 midNode = findMidNode(node1);
        isCircleList(node1);
    }

}
