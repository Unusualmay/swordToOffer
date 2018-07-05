package offer;

public class DeleteDuplicatedListNode_57 {
    public static void main(String[] args) {
        Node node7 = new Node(4,null);
        Node node6 = new Node(4,node7);
        Node node5 = new Node(4,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(2,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(2,node2);
        Node node0 = new Node(1,node1);
        DeleteDuplicatedListNode_57 drn = new DeleteDuplicatedListNode_57();
        Node root = drn.deleteDuplication(node0);
        while (root != null) {
            System.out.println(root.getData());
            root = root.next;
        }

    }

    public Node deleteDuplication(Node root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return root;
        }
        Node start = new Node();
        start.next = root;
        Node preNode = start;
        Node curNode = root;
        while (curNode != null && curNode.next != null) {
            if (curNode.getData() == curNode.next.getData()) {
                while (curNode.next != null && curNode.getData() == curNode.next.getData()) {
                    curNode = curNode.next;
                }
                preNode.next = curNode.next;
            }  else {
                preNode.next = curNode;
                preNode = preNode.next;
            }
            curNode = curNode.next;//两个if条件下都会执行
        }
        return start.next;//因为第一个结点永远是null
    }
}
