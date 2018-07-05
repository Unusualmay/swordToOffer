package offer;

import java.util.Stack;

public class PrintTreesInZigZag_61 {
    public static void main(String[] args) {
        PrintTreesInZigZag_61 ptizz = new PrintTreesInZigZag_61();
        BinaryTreeNode n15 = new BinaryTreeNode(15,null,null);
        BinaryTreeNode n14 = new BinaryTreeNode(14,null,null);
        BinaryTreeNode n13 = new BinaryTreeNode(13,null,null);
        BinaryTreeNode n12 = new BinaryTreeNode(12,null,null);
        BinaryTreeNode n11 = new BinaryTreeNode(11,null,null);
        BinaryTreeNode n10 = new BinaryTreeNode(10,null,null);
        BinaryTreeNode n9 = new BinaryTreeNode(9,null,null);
        BinaryTreeNode n8 = new BinaryTreeNode(8,null,null);
        BinaryTreeNode n7 = new BinaryTreeNode(7,n14,n15);
        BinaryTreeNode n6 = new BinaryTreeNode(6,n12,n13);
        BinaryTreeNode n5 = new BinaryTreeNode(5,n10,n11);
        BinaryTreeNode n4 = new BinaryTreeNode(4,n8,n9);
        BinaryTreeNode n3 = new BinaryTreeNode(3,n6,n7);
        BinaryTreeNode n2 = new BinaryTreeNode(2,n4,n5);
        BinaryTreeNode n1 = new BinaryTreeNode(1,n2,n3);
        ptizz.print(n1);
    }

    /**
     * 这里的原理是用到了两个栈，这stack１和stack2内容是一样的，只是引用的传递
     * @param root
     */
    public void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        int flag = 1;
        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.getData() + "\t");
                //当前是顺序的打印的，则按照顺序的方式进栈
                if (flag == 1) {
                    if (node.getLeft() != null) {
                        stack2.push(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        stack2.push(node.getRight());
                    }
                }
                //当前是逆序打印的，则按照逆序的方式进栈
                if (flag == 0) {
                    if (node.getRight() != null) {
                        stack2.push(node.getRight());
                    }
                    if (node.getLeft() != null) {
                        stack2.push(node.getLeft());
                    }
                }
            }
            if (stack1.isEmpty()) {
                flag = 1 - flag;
                System.out.println();
                Stack temp = stack2;
                stack2 = stack1;//引用传递
                stack1 = temp;
            }
        }
    }
}
