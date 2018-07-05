package offer;

public class MergeSortedList_17 {
    public static void main(String[] args) {
        Node_13 node16 = new Node_13(10, null);
        Node_13 node15 = new Node_13(7, node16);
        Node_13 node14 = new Node_13(5, node15);
        Node_13 node13 = new Node_13(5, node14);
        Node_13 node12 = new Node_13(3, node13);
        Node_13 node11 = new Node_13(1, node12);//这是头结点

        Node_13 node29 = new Node_13(15, null);
        Node_13 node28 = new Node_13(12, node29);
        Node_13 node27 = new Node_13(9, node28);
        Node_13 node26 = new Node_13(8, node27);
        Node_13 node25 = new Node_13(7, node26);
        Node_13 node24 = new Node_13(7, node25);
        Node_13 node23 = new Node_13(3, node24);
        Node_13 node22 = new Node_13(2, node23);
        Node_13 node21 = new Node_13(0, node22);//这是头结点
        Node_13 headList = mergeSortList(null, null);
//        Node_13 headList = mergeSortList2(null,null);
        printList(headList);
    }

    /**
     * 非递归的方法实现两个链表的连接（循环的方式）
     * @param headList1
     * @param headList2
     * @return
     */
    public static Node_13 mergeSortList(Node_13 headList1, Node_13 headList2) {
        if (headList1 == null) {
            return headList2;
        }
        if (headList2 == null) {
            return headList1;
        }
        Node_13 headList = null;
        if (headList1.getData() < headList2.getData()) {
            headList = headList1;
            headList1 = headList1.getNext();
        } else {
            headList = headList2;
            headList2 = headList2.getNext();
        }
        //需要一个变量指向头结点，因为之后headList总在变化
        Node_13 headListFinal = headList;
//        System.out.println(headList.getData());

        while (headList1 != null && headList2 != null) {

            if (headList1.getData() <= headList2.getData()) {

                headList.setNext(headList1);
                headList = headList.getNext();
                headList1 = headList1.getNext();
//                System.out.println("headList(if1):" + headList.getData());
            } else {

                headList.setNext(headList2);
                headList = headList.getNext();
                headList2 = headList2.getNext();
//                System.out.println("headList(if2):" + headList.getData());
            }
//            System.out.println("headList:"+headList.getData());
        }
        if (headList1!=null) {
            headList.setNext(headList1);
        }
        if (headList2!=null) {
            headList.setNext(headList2);
        }
        return headListFinal;
    }
    public static void printList(Node_13 headList) {
        while(headList != null) {
            System.out.println(headList.getData());
            headList = headList.getNext();
        }
    }

    /**
     * 递归的方法实现两个链表的连接
     * @param headList1
     * @param headList2
     * @return
     */
    public static Node_13 mergeSortList2(Node_13 headList1, Node_13 headList2) {
        if (headList1 == null) {
            return headList2;
        }
        if (headList2 == null) {
            return headList1;
        }
        //必须要把第一个结点弄出来，不然没法遍历
        Node_13 headList = null;
        if (headList1.getData() < headList2.getData()) {
            headList = headList1;
            headList1 = headList1.getNext();
        } else {
            headList = headList2;
            headList2 = headList2.getNext();
        }
        //定义一个中间变量来等于headList，因为它之后会发生变化,为什么没有定义中间变量，也可以出现想要的结果呢？？？
        Node_13 headListFinal = headList;

        mergeListTraverse(headList1,headList2,headList);

        return headListFinal;
    }

    /**
     * 递归的实现两个链表的连接的中间方法
     * @param headList1
     * @param headList2
     * @param headList
     */
    public static void mergeListTraverse(Node_13 headList1, Node_13 headList2,Node_13 headList) {
        if (headList1 == null) {
            if (headList2 != null) {
                headList.setNext(headList2);
                headList = headList.getNext();
                headList2 = headList2.getNext();
            } else {
                return;
            }
        }
        if (headList2 == null) {
            if (headList1 != null) {
                headList.setNext(headList1);
                headList = headList.getNext();
                headList1 = headList1.getNext();
            } else {
                //这里有个return的返回值之后，则递归的结束就有判断的条件了，否则永远在递归，没有递归结束的条件
                return;
            }
        }
        if (headList1 != null && headList2 != null) {
            if (headList1.getData() < headList2.getData()) {
                headList.setNext(headList1);
                headList = headList.getNext();
                headList1 = headList1.getNext();
            } else {
                headList.setNext(headList2);
                headList = headList.getNext();
                headList2 = headList2.getNext();
            }
        }
        mergeListTraverse(headList1,headList2,headList);
    }
}
