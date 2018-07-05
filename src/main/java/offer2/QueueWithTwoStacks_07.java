package offer2;

import java.util.Stack;

public class QueueWithTwoStacks_07 {
	private Stack<Node<Integer>> inputStack;
	private Stack<Node<Integer>> outputStack;
	public QueueWithTwoStacks_07(Stack<Node<Integer>> inputStack, Stack<Node<Integer>> outputStack) {
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
		//栈中的isEmpty()方法和empty()方法都是一样的,只是empty()方法是栈自带的，但是isEmpty()是继承Vector类的
		if (!outputStack.isEmpty()) {
			return outputStack.pop();
		}
		return null;
	}
	public static void main(String[] args) {
		Stack<Node<Integer>> inputStack = new Stack<>();
		Stack<Node<Integer>> outputStack = new Stack<>();
		QueueWithTwoStacks_07 queue07 = new QueueWithTwoStacks_07(inputStack, outputStack);
		Node<Integer> node1 = new Node<>(1,null);
		Node<Integer> node2 = new Node<>(2,null);
		Node<Integer> node3 = new Node<>(3,null);
		Node<Integer> node4 = new Node<>(4,null);
		Node<Integer> node5 = new Node<>(5,null);
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
