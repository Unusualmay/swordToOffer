package binaryTree;

import java.io.*;
import java.util.Scanner;

public class CreateBinaryTree {
    public static void main(String[] args) throws IOException {
        CreateBinaryTree cbt = new CreateBinaryTree();
        String filename = "create.txt";
        BinaryTreeNode root = cbt.buildBinaryTree(null,filename);
        cbt.preOrder(root);
    }

    /**
     * 根据文件中前序遍历的顺序来创建二叉树
     * @param node
     * @param filename
     * @return
     * @throws IOException
     */
    public BinaryTreeNode buildBinaryTree(BinaryTreeNode node,String filename) throws IOException {
        File file = new File(filename);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        FileWriter writer = new FileWriter(file);
//        char[] ch = new char[]{'1', '2', '3', '#', '4', '#',
//        '#', '5', '6', '#', '#', '#', '7', '8', '#', '#', '9'};
//        writer.write(ch);
        Scanner scan = new Scanner(file);
        BinaryTreeNode root = createBinaryTree(node,scan);
        return root;
    }
    public BinaryTreeNode createBinaryTree(BinaryTreeNode node, Scanner scan) {
        String temp = scan.next();
        if (temp.trim().equals("#")) {
            return null;
        } else {
            node = new BinaryTreeNode(temp);
            node.setLeft(createBinaryTree(node.getLeft(),scan));
            node.setRight(createBinaryTree(node.getRight(),scan));
        }
        return node;//这个return是返回最后一次递归的值
    }

    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
}
