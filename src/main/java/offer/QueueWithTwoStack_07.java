package offer;

import offer2.QueueWithTwoStacks_07;

import java.util.Stack;

public class QueueWithTwoStack_07 {
    public static void main(String[] args) {
        Stack<offer2.Node<Integer>> inputStack = new Stack<>();
        Stack<offer2.Node<Integer>> outputStack = new Stack<>();
        QueueWithTwoStacks_07 queue07 = new QueueWithTwoStacks_07(inputStack, outputStack);
        offer2.Node<Integer> node1 = new offer2.Node<>(1,null);
        offer2.Node<Integer> node2 = new offer2.Node<>(2,null);
        offer2.Node<Integer> node3 = new offer2.Node<>(3,null);
        offer2.Node<Integer> node4 = new offer2.Node<>(4,null);
        offer2.Node<Integer> node5 = new offer2.Node<>(5,null);
        queue07.appendTail(node1);
        queue07.appendTail(node2);
        queue07.appendTail(node3);
        queue07.appendTail(node4);
        offer2.Node nodetemp1 = queue07.deleteHead();
        System.out.println(nodetemp1.getData());
        offer2.Node nodetemp2 = queue07.deleteHead();
        System.out.println(nodetemp2.getData());
        queue07.appendTail(node5);
        System.out.println(queue07.deleteHead().getData());

    }
    private Stack inputStack;
    private Stack outputStack;
    public void appendTali(Node node) {
        if (inputStack != null) {
            inputStack.push(node);
        } else {
            return;
        }
    }

    public Node deleteHead() {
        if (!outputStack.isEmpty()) {
            return (Node) outputStack.pop();

        }
        while (!inputStack.isEmpty()) {
            Node node = (Node) outputStack.pop();
            inputStack.push(node);
        }
        if (!outputStack.isEmpty()) {
            return (Node) outputStack.pop();
        }
        return null;
    }
}
