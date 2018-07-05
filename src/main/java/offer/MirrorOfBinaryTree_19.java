package offer;

public class MirrorOfBinaryTree_19 {
    public static void main(String[] args) {
        BinaryTreeNode bt7 = new BinaryTreeNode(11, null,null);
        BinaryTreeNode bt6 = new BinaryTreeNode(9,null,null);
        BinaryTreeNode bt3 = new BinaryTreeNode(10,bt6,bt7);
        BinaryTreeNode bt5 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode bt4 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode bt2 = new BinaryTreeNode(6,bt4,bt5);
        BinaryTreeNode bt1 = new BinaryTreeNode(8,bt2,bt3);
//        printBinaryTree(bt1);
        mirrorBinaryTree(bt1);
        System.out.println("---------------------");
        printBinaryTree(bt1);

    }

    /**
     * 用递归的方法实现二叉树的镜像
     * @param root
     */
    public static void mirrorBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("执行次数");
        System.out.println(root.getData());
        BinaryTreeNode tempNode = null;
        tempNode = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tempNode);
        mirrorBinaryTree(root.getLeft());
        mirrorBinaryTree(root.getRight());

    }
    public static void printBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        printBinaryTree(root.getLeft());
        printBinaryTree(root.getRight());
    }
}
