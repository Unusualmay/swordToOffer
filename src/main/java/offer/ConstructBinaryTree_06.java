package offer;

public class ConstructBinaryTree_06 {
    /**
     * 递归的方法实现重建二叉树
     * @param preOder
     * @param inOrder
     * @return
     */
    public static BinaryTreeNode creatBinaryTree(int[] preOder, int preStart, int preEnd,
                                                 int[] inOrder, int inStart, int inEnd) {
        if (preOder == null) {
            return null;
        }
        if (inOrder == null) {
            return null;
        }
//        BinaryTreeNode root = new BinaryTreeNode();
//        root.setData(preOder[preStart]);
        int length = inOrder.length;
        for (int i = 0; i < length; i++) {
            if (preOder[preStart] == inOrder[i]) {
                preStart = preStart+1;
                preEnd = i;
//                inStart =
//                root.setLeft(creatBinaryTree(preOder,preStart,preEnd));
            }
        }

        return null;
    }
    public static void main(String[] args) {

    }
}
