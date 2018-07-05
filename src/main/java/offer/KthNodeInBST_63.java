package offer;

public class KthNodeInBST_63 {
    public static void main(String[] args) {
        KthNodeInBST_63 kibst = new KthNodeInBST_63();
        BinaryTreeNode n7 = new BinaryTreeNode(8,null,null);
        BinaryTreeNode n6 = new BinaryTreeNode(6,null,null);
        BinaryTreeNode n5 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode n4 = new BinaryTreeNode(2,null,null);
        BinaryTreeNode n3 = new BinaryTreeNode(7,n6,n7);
        BinaryTreeNode n2 = new BinaryTreeNode(3,n4,n5);
        BinaryTreeNode n1 = new BinaryTreeNode(5,n2,n3);
        BinaryTreeNode bt = kibst.kthNode(n1,3);
        System.out.println(bt.getData());

    }
    int count = 0;
    public BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode node = kthNode(root.getLeft(),k);
        if (node != null) {
            return node;
        }
        count++;
        if (count == k) {
            return root;
        }
        node = kthNode(root.getRight(),k);
        if (node != null) {
            return node;
        }
        return null;
    }
}
