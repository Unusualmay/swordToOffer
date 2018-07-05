package offer2;
/**
 * 输入链表的头结点，从尾到头打印处每个节点的值
 */
import java.util.Stack;

public class OfferDemo5 {
	//非递归的方法实现打印链表信息
	public static <T> void printList(Node<T> headNode) {
		Stack<Node<T>> stack = new Stack<>();
		while(headNode != null) {
			stack.push(headNode);
			headNode = headNode.next;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().data);//只是打印每个节点的值
//			System.out.println(stack.pop());//和上面的结果返回不一样呢？？？
		}
	}
	//递归方法实现打印链表信息,递归都是用条件判断语句，不是循环语句
	public static <T> void printListReverse (Node<T> headNode) {
		if(headNode != null) {
			if (headNode.next != null) {
				printListReverse(headNode.next);
			}
			System.out.println(headNode.data);
		}
		
	}
	//进行测试
	public static void main(String[] args) {
		Node<String> node1 = new Node<String>();
		node1.setData("张三");
		Node<String> node2 = new Node<String>();
		node2.setData("李四");
		Node<String> node3 = new Node<String>();
		node3.setData("王五");
		Node<String> node4 = new Node<String>();
		Node<String> node5 = null;
		node4.setData("赵柳");
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(null);
//		printList(node1);
//		printListReverse(node1);
		printList(node5);
		
	}
}
