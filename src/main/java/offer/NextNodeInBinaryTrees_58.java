package offer;

public class NextNodeInBinaryTrees_58 {
    public static void main(String[] args) {
        NextNodeInBinaryTrees_58 gnbt = new NextNodeInBinaryTrees_58();
        BinaryTreeNodeWithParent b9 = new BinaryTreeNodeWithParent(9,null,null,null);
        BinaryTreeNodeWithParent b8 = new BinaryTreeNodeWithParent(8,null,null,null);
        BinaryTreeNodeWithParent b7 = new BinaryTreeNodeWithParent(7,null,null,null);
        BinaryTreeNodeWithParent b6 = new BinaryTreeNodeWithParent(6,null,null,null);
        BinaryTreeNodeWithParent b5 = new BinaryTreeNodeWithParent(5,b8,b9,null);
        BinaryTreeNodeWithParent b4 = new BinaryTreeNodeWithParent(4,null,null,null);
        BinaryTreeNodeWithParent b3 = new BinaryTreeNodeWithParent(3,b6,b7,null);
        BinaryTreeNodeWithParent b2 = new BinaryTreeNodeWithParent(2,b4,b5,null);
        BinaryTreeNodeWithParent b1 = new BinaryTreeNodeWithParent(1,b2,b3,null);

        b2.setParent(b1);
        b3.setParent(b1);
        b4.setParent(b2);
        b5.setParent(b2);
        b6.setParent(b3);
        b7.setParent(b3);
        b8.setParent(b5);
        b9.setParent(b5);
        System.out.print("1:");
        BinaryTreeNodeWithParent next1 = gnbt.getNext(b1);
        System.out.println(next1.getData());
        System.out.print("2:");
        BinaryTreeNodeWithParent next2 = gnbt.getNext(b2);
        System.out.println(next2.getData());
        System.out.print("3:");
        BinaryTreeNodeWithParent next3 = gnbt.getNext(b3);
        System.out.println(next3.getData());
        System.out.print("4:");
        BinaryTreeNodeWithParent next4 = gnbt.getNext(b4);
        System.out.println(next4.getData());
        System.out.print("5:");
        BinaryTreeNodeWithParent next5 = gnbt.getNext(b5);
        System.out.println(next5.getData());
        System.out.print("6:");
        BinaryTreeNodeWithParent next6 = gnbt.getNext(b6);
        System.out.println(next6.getData());
        System.out.print("7:");
        BinaryTreeNodeWithParent next7 = gnbt.getNext(b7);
        System.out.println(next7);
        System.out.print("8:");
        BinaryTreeNodeWithParent next8 = gnbt.getNext(b8);
        System.out.println(next8.getData());
        System.out.print("9:");
        BinaryTreeNodeWithParent next9 = gnbt.getNext(b9);
        System.out.println(next9.getData());


    }

    public BinaryTreeNodeWithParent getNext(BinaryTreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        BinaryTreeNodeWithParent next = null;
        //如果右子树存在
        if (node.getRight() != null) {
            next = node.getRight();
            while (next.getLeft() != null) {
                next = next.getLeft();
            }
        }
        //如果右子树不存在，但是存在父节点
        else if (node.getParent() != null) {
            BinaryTreeNodeWithParent curNode = node;
            BinaryTreeNodeWithParent parent = node.getParent();
            while (parent != null && curNode == parent.getRight()) {
                curNode = curNode.getParent();
                parent = curNode.getParent();
            }
            next = parent;
        }
        return next;
    }
}
