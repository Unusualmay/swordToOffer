package offer;

public class SymmetricalBinaryTree_59 {
    public static void main(String[] args) {
        SymmetricalBinaryTree_59 is = new SymmetricalBinaryTree_59();

        BinaryTreeNode n4 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode n5 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n6 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n7 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode n2 = new BinaryTreeNode(6,n4,n5);
        BinaryTreeNode n3 = new BinaryTreeNode(9,n6,n7);
        BinaryTreeNode n1 = new BinaryTreeNode(8,n2,n3);
        System.out.println(is.isSymmetrical(n1,n1));

        BinaryTreeNode n11 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n12 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n13 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode n9 = new BinaryTreeNode(7,n11,n12);
        BinaryTreeNode n10 = new BinaryTreeNode(7,n13,null);
        BinaryTreeNode n8 = new BinaryTreeNode(7,n9,n10);
        System.out.println(is.isSymmetrical(n8,n8));
    }

    public boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        }
        return isSymmetrical(root1.getLeft(),root2.getRight())
                && isSymmetrical(root1.getRight(),root2.getLeft());
    }
}
