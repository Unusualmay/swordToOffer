package offer;

public class ReverseList_16 {
    public static void main(String[] args) {
        Node_13 node6 = new Node_13(6, null);
        Node_13 node5 = new Node_13(5, node6);
        Node_13 node4 = new Node_13(4, node5);
        Node_13 node3 = new Node_13(3, node4);
        Node_13 node2 = new Node_13(2, node3);
        Node_13 node1 = new Node_13(1, node2);//这是头结点
//        Node_13 resultNode = reverseList(node1);
        Node_13 resultNode2 = reverList2(node1);
//        System.out.println(resultNode.getData());
        System.out.println(resultNode2.getData());
//        Node_13 node = node1;
//        while (node != null) {
//            System.out.println(node.getData());
//            node = node.getNext();
//        }

    }

    /**
     * 用非递归实现翻转链表，并且返回翻转后的头结点信息
     * @param headList
     * @return
     */
    public static Node_13 reverseList(Node_13 headList) {
        Node_13 preNode = null;
        Node_13 nextNode = null;
        Node_13 curNode = headList;
        if (headList == null) {
            return null;
        }
        if (headList.getNext() == null) {
            return headList;
        }
        while (curNode != null) {
            nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
    public static Node_13 reverList2(Node_13 headList) {
        if (headList == null) {
            return null;
        }
        if (headList.getNext()==null) {
            return headList;
        }
        Node_13 preNode = headList;
        Node_13 curNode = headList.getNext();
//        reverseListTraverse(preNode,curNode);
        return reverseListTraverse2(preNode,curNode);

    }

    /**
     * 递归方法1，最后得到的是一个反转的链表，至于链表如何遍历得到头结点呢？
     * @param preNode
     * @param curNode
     */
    public static void reverseListTraverse(Node_13 preNode, Node_13 curNode) {
        if (curNode != null) {
//            System.out.println("preNode:"+preNode.getData());
            Node_13 nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
            System.out.println(preNode.getData());
            reverseListTraverse(preNode,curNode);
//            System.out.println("preNode2:"+preNode.getData());
        }
    }

    /**
     * 递归方法2，有返回值，返回的正是反转之后的头结点的信息
     * @param preNode
     * @param curNode
     * @return
     */
    public static Node_13 reverseListTraverse2(Node_13 preNode, Node_13 curNode) {
        if (preNode == null) {
            return null;
        }
        if (curNode.getNext() == null) {
            curNode.setNext(preNode);
            return curNode;
        }
        if (curNode != null) {
            Node_13 nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
            Node_13 pNewNode = reverseListTraverse2(preNode,curNode);
            return pNewNode;
        }
        return null;
    }

}
