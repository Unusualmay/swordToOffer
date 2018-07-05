package offer;

public class ComplexListNode {
    int data;
    ComplexListNode next;
    ComplexListNode sibling;
    public ComplexListNode() {

    }
    public  ComplexListNode(int data, ComplexListNode next, ComplexListNode sibling) {
        this.data = data;
        this.next = next;
        this.sibling = sibling;
    }
}
