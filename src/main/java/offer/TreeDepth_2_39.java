package offer;

import java.util.Map;

public class TreeDepth_2_39 {
    public static void main(String[] args) {
        TreeDepth_2_39 td2 = new TreeDepth_2_39();
        BinaryTreeNode node7 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode node6 = new BinaryTreeNode(6,null,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5,node7,null);
        BinaryTreeNode node4 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3 = new BinaryTreeNode(3,null,node6);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1,node2,node3);
        System.out.println(td2.isBalancedTree2(node1,0));
    }
    /**
     * 方法一：
     * 利用递归调用左右子树的深度，
     * 但是因为有一些结点的重复访问，这样的时间效率不高
     */
    /**
     * 应用：判断是否是平衡二叉树
     * 平衡二叉树的定义：该二叉树的任意结点的左右子树的深度相差不超过１
     * @param root
     * @return
     */
    public boolean isBalancedTree(BinaryTreeNode root, int num) {
        if (root == null) {
            return true;
        }
        int leftNums = treeDepth(root.getLeft(),num);
        int rightNums = treeDepth(root.getRight(),num);
        int numDif = leftNums-rightNums;
        if (Math.abs(numDif) > 1) {
            return false;
        }
        return isBalancedTree(root.getLeft(),num) && isBalancedTree(root.getRight(),num);
    }

    /**
     * 这是有中间变量num的方法
     * @param root
     * @param num
     * @return
     */
    public int treeDepth(BinaryTreeNode root, int num) {
        if (root == null) {
            return num;
        }
        int leftNums = treeDepth(root.getLeft(),num);
        int rightNums = treeDepth(root.getRight(),num);
        num = max(leftNums,rightNums);
        return num+1;
    }

    public int max(int a, int b) {
        return a>=b? a : b;
    }

    /**
     * 没有中间变量num的递归调用，这里也是逐次加１
     * @param root
     * @return
     */
    public int treeDepth1(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNums = treeDepth1(root.getLeft());
        int rightNums = treeDepth1(root.getRight());
        return max(leftNums,rightNums) + 1;
    }


    /**
     * 方法二：
     */

    public boolean isBalancedTree2(BinaryTreeNode root, int num) {
        if (root == null) {
            num = 0;
            return true;
        }
        int left = 0;
        int right = 0;
        if(isBalancedTree2(root.getLeft(),left) && isBalancedTree(root.getRight(),right)) {
            int numDif = left-right;
            if (Math.abs(numDif) < 1) {
                num = 1 + (left > right ? left:right);
                return true;
            }
        }
        return false;
    }
}
