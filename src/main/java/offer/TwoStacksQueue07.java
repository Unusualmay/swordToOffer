package offer;

import java.util.Stack;

public class TwoStacksQueue07 {
	private Stack<Node<Integer>> inputStack;
	private Stack<Node<Integer>> outputStack;
	public TwoStacksQueue07(Stack<Node<Integer>> inputStack, Stack<Node<Integer>> outputStack) {
		this.inputStack = inputStack;
		this.outputStack = outputStack;
	}
	public void appendTail(Node<Integer> node) {
		if(inputStack != null) {
			inputStack.push(node);
		} else {
			return;
		}
	}
	public Node deleteHead() {
		if (!outputStack.isEmpty()) {
			return outputStack.pop();
		}
		while(!inputStack.isEmpty()) {
			Node<Integer> temp = inputStack.pop();
			outputStack.push(temp);
		}
		if (!outputStack.isEmpty()) {
			return outputStack.pop();
		}
		return null;
	}
	public static void main(String[] args) {
		Stack<Node<Integer>> inputStack = new Stack<>();
		Stack<Node<Integer>> outputStack = new Stack<>();
		TwoStacksQueue07 queue07 = new TwoStacksQueue07(inputStack, outputStack);
		Node<Integer> node1 = new Node<>(1,null);
		Node<Integer> node2 = new Node<>(11,null);
		Node<Integer> node3 = new Node<>(111,null);
		Node<Integer> node4 = new Node<>(1111,null);
		Node<Integer> node5 = new Node<>(11111,null);
		queue07.appendTail(node1);
		queue07.appendTail(node2);
		queue07.appendTail(node3);
		queue07.appendTail(node4);
		Node nodetemp1 = queue07.deleteHead();
		System.out.println(nodetemp1.getData());
		Node nodetemp2 = queue07.deleteHead();
		System.out.println(nodetemp2.getData());
		queue07.appendTail(node5);
		System.out.println(queue07.deleteHead().getData());
	}

}
