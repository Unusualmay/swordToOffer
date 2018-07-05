package offer;

public class SubStructureInTree_18 {
    public static void main(String[] args) {
        BinaryTreeNode bn7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode bn6 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode bn5 = new BinaryTreeNode(2, bn6,bn7);
        BinaryTreeNode bn4 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode bn3 = new BinaryTreeNode(8, bn4,bn5);
        BinaryTreeNode bn2 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode bn1 = new BinaryTreeNode(8,bn3,bn2);

        BinaryTreeNode bt3 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode bt2 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode bt1 = new BinaryTreeNode(8,bt2,bt3);

        System.out.println("该二叉树中是有该子树："+hasSubTree(bn1,bt1));
    }

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData()) {
                result = DoesTreeHaveTree2(root1,root2);
            }
            if (!result) {
                hasSubTree(root1.getLeft(),root2);
            }
            if (!result) {
                hasSubTree(root2,root2);
            }

        }
        return result;
    }
    public static boolean DoesTreeHaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData()) {
                root1 = root1.getLeft();
                root2 = root2.getLeft();
                boolean result = DoesTreeHaveTree2(root1, root2);
                root1 = root1.getRight();
                root2 = root2.getRight();
                result = DoesTreeHaveTree2(root1,root2);
                return result;
            } else {
                return false;
            }
        }
        return false;
    }
}
