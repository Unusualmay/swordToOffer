package offer;

public class ConvertBInarySearchTree_27 {
    BinaryTreeNode lastNodeInList = null;
    public static void main(String[] args) {
        BinaryTreeNode bt7 = new BinaryTreeNode(16,null,null);
        BinaryTreeNode bt6 = new BinaryTreeNode(12, null,null);
        BinaryTreeNode bt5 = new BinaryTreeNode(8,null,null);
        BinaryTreeNode bt4 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode bt3 = new BinaryTreeNode(14,bt6,bt7);
        BinaryTreeNode bt2 = new BinaryTreeNode(6,bt4,bt5);
        BinaryTreeNode bt1 = new BinaryTreeNode(10,bt2,bt3);
        ConvertBInarySearchTree_27 cbs = new ConvertBInarySearchTree_27();
        BinaryTreeNode node = cbs.convert(bt1);
//        inOrder(bt1);
        while (node != null) {
//            System.out.println("--------");
            System.out.println(node.getData());
            node = node.getRight();
        }
    }
    public BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        //将二叉搜索树转化为一个双向的链表
        convertNode(root);
        //lastNodeInList是双向链表的最后一个结点的信息
//        System.out.println(lastNodeInList);
        BinaryTreeNode firstNodeInList = lastNodeInList;
        //得到双向链表的第一个结点
        while(firstNodeInList != null && firstNodeInList.getLeft() != null) {
            firstNodeInList = firstNodeInList.getLeft();
        }
        return firstNodeInList;
    }

    /**
     * 将二叉搜索树转化为一个双向的链表
     * @param root 根结点
     * @param lastNodeInList 转换好的链表的最后一个结点
     */
    public  void convertNode(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode current = root;
        convertNode(current.getLeft());
        current.setLeft(lastNodeInList);
        if (lastNodeInList != null) {
            lastNodeInList.setRight(current);
        }
        lastNodeInList = current;
//        System.out.println(lastNodeInList.getData());
        convertNode(current.getRight());
//        System.out.println("right:"+lastNodeInList.getData());
    }
    public static void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());
    }
}
