package offer2;

import java.util.LinkedList;

public class StackWithTwoQueue_07 {
	private LinkedList<Node<Integer>> queue1 = new LinkedList<>();
	private LinkedList<Node<Integer>> queue2 = new LinkedList<>();
	public void push(Node<Integer> node) {
		if (queue1.size() != 0) {
			queue1.add(node);
		} else {
			queue2.add(node);
		}
	}
	public Node<Integer> pop() {
		if (queue1.size() != 0) {
			while(queue1.size() != 1) {
				Node<Integer> tempnode = queue1.poll();
				queue2.add(tempnode);
			}	
			return queue1.poll();
		}	
		if (queue2.size() != 0) {
			while (queue2.size() != 1) {
				Node<Integer> tempnode = queue2.poll();
				queue1.add(tempnode);
			}
			return queue2.poll();
		}
		return null;	
	}
	public static void main(String[] args) {
		StackWithTwoQueue_07 tqs = new StackWithTwoQueue_07();
		Node<Integer> node1 = new Node<>(1,null);
		Node<Integer> node2 = new Node<>(11,null);
		Node<Integer> node3 = new Node<>(111,null);
		Node<Integer> node4 = new Node<>(1111,null);
		Node<Integer> node5 = new Node<>(11111,null);
		tqs.push(node1);
		tqs.push(node2);
		tqs.push(node3);
		System.out.println(tqs.pop());
		System.out.println(tqs.pop());
		tqs.push(node4);
		System.out.println(tqs.pop());
		tqs.push(node5);
	}
}
