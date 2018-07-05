package offer;

public class Node_13 {
    private int data;
    private Node_13 next;
    public Node_13() {

    }
    public Node_13(int data, Node_13 next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node_13 next) {
        this.next = next;
    }

    public Node_13 getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node_13{data=" + this.data + ", next=" + this.next + "}";
    }
}
