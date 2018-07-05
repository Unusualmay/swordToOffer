package offer;

import java.util.LinkedList;

public class TreeNodeWithParent {
    private int data;
    LinkedList<TreeNodeWithParent> children = new LinkedList<>();
    private TreeNodeWithParent parent;
    public TreeNodeWithParent(int data, TreeNodeWithParent parent) {
        this.data = data;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNodeWithParent getParent() {
        return parent;
    }

    public void setParent(TreeNodeWithParent parent) {
        this.parent = parent;
    }
}
