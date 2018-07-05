package offer;

public class SubstructureInTree {
    public static void main(String[] args) {

    }
    //先找到两个相等的根节点
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData()) {
                return DoesTree1HaveTree2(root1,root2);
            } else {
                root1 = root1.getLeft();
                hasSubTree(root1, root2);
                root1 = root1.getRight();
                hasSubTree(root1,root2);
            }
        }
        return result;
    }
    public static boolean DoesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.getData() == root2.getData()) {
            root1 = root1.getLeft();
            root2 = root2.getLeft();
            DoesTree1HaveTree2(root1,root2);
            root1 = root1.getRight();
            root2 = root2.getRight();
            DoesTree1HaveTree2(root1,root2);
        }
        return false;
    }
}
