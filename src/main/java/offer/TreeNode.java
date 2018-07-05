package offer;

import java.util.LinkedList;

public class TreeNode {
    private int data;
    LinkedList<TreeNode> children = new LinkedList<>();
    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
