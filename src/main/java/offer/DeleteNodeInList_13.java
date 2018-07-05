package offer;

/**
 * 题目要求就是删除一个结点，而且时间复杂度只能是O(1)
 * 注意：引用在分析的时候可以画指向
 */
public class DeleteNodeInList_13 {
    public static void deletNode(Node_13 headList, Node_13 nodeDelete) {
        if (headList == null) {
            return;
        }
        //如果该链表只有一个结点，而删除的就是该结点
        if (headList.getNext()==null && nodeDelete == headList) {
            System.out.println("这里执行");
            nodeDelete = null;
//            System.out.println("nodeDelete:"+nodeDelete.getData());
            headList = null;
//            System.out.println("headList:"+headList.getData());
            printList(headList);
            return;
        }
        //如果删除的该结点是链表的尾结点
        if (nodeDelete.getNext() == null) {
            Node_13 node = headList;
            //注意这里是找到需要删除的结点的前一个结点
            while(node.getNext() != nodeDelete) {
                node = node.getNext();
            }
            node.setNext(null);
            nodeDelete = null;
            return;
        }

        nodeDelete.setData(nodeDelete.getNext().getData());
        nodeDelete.setNext(nodeDelete.getNext().getNext());

    }
    public static void printList(Node_13 headList) {
        for (Node_13 node = headList; node != null; node = node.getNext()) {
            System.out.println(node.getData());
        }
    }
    public static void main(String[] args) {
        Node_13 node5 = new Node_13(5,null);
//        Node_13 node4 = new Node_13(4,node5);
//        Node_13 node3 = new Node_13(3,node4);
//        Node_13 node2 = new Node_13(2,node3);
//        Node_13 node1 = new Node_13(1, node2);//这是头结点
//        printList(node1);
        System.out.println("------------------分割线-------------------");
        deletNode(node5,node5);
//        printList(node5);//如果是这样执行的话，会有值打印，因为node5这个引用还是有指向
    }
}

