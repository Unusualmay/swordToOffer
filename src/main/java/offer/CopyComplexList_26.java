package offer;

public class CopyComplexList_26 {
    public static void main(String[] args) {
        ComplexListNode node5 = new ComplexListNode(5,null,null);
        ComplexListNode node4 = new ComplexListNode(4,node5,null);
        ComplexListNode node3 = new ComplexListNode(3,node4,null);
        ComplexListNode node2 = new ComplexListNode(2,node3,node5);
        ComplexListNode node1 = new ComplexListNode(1,node2,node3);
        node4.sibling = node2;
        ComplexListNode newNode = clone(node1);
        while(newNode != null) {
            System.out.println(newNode.data);
            newNode = newNode.next;
        }
    }
    //分步解决的思想
    public static ComplexListNode clone(ComplexListNode head) {
        cloneNode(head);
        connectSiblingNodes(head);
        return reConnectNodes(head);
    }
    public static void cloneNode(ComplexListNode head) {
        ComplexListNode node = head;
        while(node != null) {
            //复制的每一个结点都需要重新生成，而不是引用的不断变化，所以要在循环中不断的生成新的结点
            ComplexListNode cloneNode = new ComplexListNode();
            cloneNode.data = node.data;
            cloneNode.next = node.next;
            cloneNode.sibling = null;

            node.next = cloneNode;
            node = cloneNode.next;
        }
    }
    public static void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneNode = node.next;
        while(node.sibling != null) {
            cloneNode.sibling = node.sibling.next;
            node = cloneNode.next;
            cloneNode = node.next;
        }

    }
    public static ComplexListNode reConnectNodes(ComplexListNode head){
       ComplexListNode node = head;
       ComplexListNode cloneHead = null;
       ComplexListNode cloneNode = null;
       //只要node不为null，那么node.next肯定不为空，因为是它的复制
       if (node != null) {
           cloneHead = node.next;
           cloneNode = cloneHead;
           node.next = cloneNode.next;
           node = node.next;
       }
       while(node != null) {
           //cloneNode 是node.next，只要是node不为kong，那么node.next就不为空，因为相同
           cloneNode.next = node.next;
           cloneNode = cloneNode.next;
           node = cloneNode.next;
       }
       return cloneHead;
    }

}
