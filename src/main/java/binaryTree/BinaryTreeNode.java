package binaryTree;

import java.util.Scanner;

public class BinaryTreeNode {
    private String data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    public BinaryTreeNode(String data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinaryTreeNode(String data) {
        this.data = data;
    }
}
