package offer;

public class BinaryTreeNodeWithParent {
    private int data;
    private BinaryTreeNodeWithParent left;
    private BinaryTreeNodeWithParent right;
    private BinaryTreeNodeWithParent parent;

    public BinaryTreeNodeWithParent(int data, BinaryTreeNodeWithParent left,
                                    BinaryTreeNodeWithParent right,
                                    BinaryTreeNodeWithParent parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNodeWithParent getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNodeWithParent left) {
        this.left = left;
    }

    public BinaryTreeNodeWithParent getRight() {
        return right;
    }

    public void setRight(BinaryTreeNodeWithParent right) {
        this.right = right;
    }

    public BinaryTreeNodeWithParent getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNodeWithParent parent) {
        this.parent = parent;
    }
}
