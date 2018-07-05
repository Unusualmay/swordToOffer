package offer;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreesInLines_60 {
    public static void main(String[] args) {
        PrintTreesInLines_60 ptil = new PrintTreesInLines_60();
        BinaryTreeNode n15 = new BinaryTreeNode(19,null,null);
        BinaryTreeNode n14 = new BinaryTreeNode(18,null,null);
        BinaryTreeNode n13 = new BinaryTreeNode(17,null,null);
        BinaryTreeNode n12 = new BinaryTreeNode(16,null,null);
        BinaryTreeNode n11 = new BinaryTreeNode(15,null,null);
        BinaryTreeNode n10 = new BinaryTreeNode(14,null,null);
        BinaryTreeNode n9 = new BinaryTreeNode(13,null,null);
        BinaryTreeNode n8 = new BinaryTreeNode(12,null,null);
        BinaryTreeNode n4 = new BinaryTreeNode(5,n8,n9);
        BinaryTreeNode n5 = new BinaryTreeNode(7,n10,n11);
        BinaryTreeNode n6 = new BinaryTreeNode(9,n12,n13);
        BinaryTreeNode n7 = new BinaryTreeNode(11,n14,n15);
        BinaryTreeNode n2 = new BinaryTreeNode(6,n4,n5);
        BinaryTreeNode n3 = new BinaryTreeNode(10,n6,n7);
        BinaryTreeNode n1 = new BinaryTreeNode(8,n2,n3);
        ptil.print(n1);
    }

    public void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        int toBePrinted = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode bt = queue.poll();
            System.out.print(bt.getData() + "\t");
            toBePrinted--;
            if (bt.getLeft() != null) {
                queue.offer(bt.getLeft());
            }
            nextLevel++;
            if (bt.getRight() != null) {
                queue.offer(bt.getRight());
            }
            nextLevel++;
            if (nextLevel > 0 && toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

    }
}
