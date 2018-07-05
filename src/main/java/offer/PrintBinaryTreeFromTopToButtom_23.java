package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTreeFromTopToButtom_23 {
    public static void main(String[] args) {
        BinaryTreeNode bt7 = new BinaryTreeNode(11, null, null);
        BinaryTreeNode bt6 = new BinaryTreeNode(9,null,null);
        BinaryTreeNode bt5 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode bt4 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode bt3 = new BinaryTreeNode(10,bt6,bt7);
        BinaryTreeNode bt2 = new BinaryTreeNode(6,bt4,bt5);
        BinaryTreeNode bt1= new BinaryTreeNode(8,bt2,bt3);

        ArrayList<BinaryTreeNode> result = printTopToBottom(bt1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getData());
        }

    }
    public static ArrayList<BinaryTreeNode> printTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<BinaryTreeNode> result = new ArrayList<>();
        //LinkedList实现了Queue
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);//队尾加入该元素，如果成功，则返回为true，否则返回false
        while (!queue.isEmpty()) {
            //将队列的头弹出
            BinaryTreeNode bt = queue.poll();
            result.add(bt);
            if (bt.getLeft() != null) {
                queue.offer(bt.getLeft());
            }
            if (bt.getRight() != null) {
                queue.offer(bt.getRight());
            }
        }
        return result;
    }
}
