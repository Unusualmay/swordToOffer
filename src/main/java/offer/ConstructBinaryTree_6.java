package offer;

import offer2.BinaryTreeNode;
import java.util.Stack;

/**
 * 根据输入的前序遍历和中序遍历的结果，重建二叉树
 */
public class ConstructBinaryTree_6 {
	public static BinaryTreeNode<Integer> ConstructorCore(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) throws Exception {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
		if (preOrder == null && inOrder == null) {
			return null;
		} 
		int rootValue = preOrder[startPre];
		root.setData(rootValue);
		root.setLeft(null);
		root.setRight(null);
		if (startPre == endPre) {
			//因为是要同一个序列，所以还需要后面的条件
			if (startIn == endIn && preOrder[startPre] == inOrder[startIn]) {
				//递归结束的条件
				return root;
			} else {
				throw new Exception("Invalid input");	
			}
		}
		int rootIndex = startIn;
		while (rootIndex < endIn && inOrder[rootIndex] != rootValue) {
			rootIndex++;
		}
		if (rootIndex == endIn && inOrder[rootIndex] != rootValue) {
			throw new Exception("Invalid input");
		} 
		int leftLength = rootIndex - startIn;
		int leftLengthEnd = leftLength + startPre;
		if (leftLength > 0) {
			root.setLeft(ConstructorCore(preOrder, startPre+1, leftLengthEnd, inOrder, startIn, rootIndex - 1));
		}
		if (leftLength < endPre - startPre) {
			root.setRight(ConstructorCore(preOrder, leftLengthEnd+ 1, endPre, inOrder, rootIndex + 1, endIn));
		}
			
		return root;
	}
	public static void main(String[] args) throws Exception {
		int[] preOrder = new int[] {1,2,4,7,3,5,6,8};
		int[] inOrder = new int[] {4,7,2,1,5,3,8,6};
		BinaryTreeNode<Integer> root = ConstructorCore(preOrder, 0, 7, inOrder, 0, 7);
//		PreTraverse(root);
		InTraverse(root);
//		inOrderByLoop(root);
	}
	public static void PreTraverse(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		} 
		System.out.println(root.getData());
		PreTraverse(root.getLeft());
		PreTraverse(root.getRight());
	}
	public static void InTraverse(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		InTraverse(root.getLeft());
		System.out.println(root.getData());
		InTraverse(root.getRight());
	}
	//非递归的方法
	public static void inOrderByLoop(BinaryTreeNode<Integer> node) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		while (node != null || !stack.empty()) {
			while (node != null) {
				stack.push(node);
		        node = node.getLeft();
		        }
		    if (!stack.empty()) {
		    	node = stack.pop();
		        System.out.println(node.getData());
		        node = node.getRight();
		        }
		    }
	}


}
