package offer;

public class TreeDepth_1_39 {
    public static void main(String[] args) {
        TreeDepth_1_39 td = new TreeDepth_1_39();
        BinaryTreeNode node7 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode node6 = new BinaryTreeNode(6,null,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5,node7,null);
        BinaryTreeNode node4 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode node3 = new BinaryTreeNode(3,null,node6);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1,node2,node3);
        System.out.println(td.treeDepth(node1,0));
    }
    public int treeDepth(BinaryTreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        //方法１
        if (root != null) {
            num = num + 1;
        }
        int num1 = 0;
        int num2 = 0;
        if (root.getLeft() != null) {
            if (root.getRight() == null) {
                num = treeDepth(root.getLeft(),num);
            } else {
               num1 = treeDepth(root.getLeft(), num);
               num2 = treeDepth(root.getRight(), num);
               num = max(num1, num2);
            }
        } else {
            if (root.getRight() == null) {
                return num;
            } else {
                num = treeDepth(root.getRight(),num);
            }
        }
        return num;


        //方法２
//        int leftNums = treeDepth(root.getLeft(),num);
//        int rightNums = treeDepth(root.getRight(),num);
//        num = max(leftNums,rightNums) + 1;
//        return num;
    }

    public int max(int a, int b) {
        return a>=b ? a : b;
    }
}
