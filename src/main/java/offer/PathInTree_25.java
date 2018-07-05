package offer;

import java.util.Stack;

public class PathInTree_25 {
    public static void main(String[] args) {
        BinaryTreeNode bt5 = new BinaryTreeNode(7,null,null);
        BinaryTreeNode bt4 = new BinaryTreeNode(4,null,null);
        BinaryTreeNode bt3 = new BinaryTreeNode(12, null,null);
        BinaryTreeNode bt2 = new BinaryTreeNode(5,bt4,bt5);
        BinaryTreeNode bt1 = new BinaryTreeNode(10,bt2,bt3);
        findPath(bt1,22);
//        Stack<Integer> stack = new Stack<>();
//        stack.push(bt1.getData());
//        stack.push(bt2.getData());
//        stack.push(bt3.getData());
//        stack.push(bt4.getData());
//        stack.push(bt5.getData());
//        //用for循环可以完整的打印出栈中的全部的元素信息，而且是从栈底到栈顶
//        for(int i : stack){
//            System.out.println(i);
//        }
    }
    //两个方法的方法名称相同，但是方法的参数不同，这是方法的重载
    public static void findPath(BinaryTreeNode bt, int key) {
        if (bt == null) {
            return;
        }
        Stack<Integer> path= new Stack<>();
        findPath(bt,key,path);
    }
    public static void findPath(BinaryTreeNode bt, int key, Stack<Integer> path) {
        if (bt == null) {
            return;
        }
        //到达叶子结点代表这是一条路径
        if (bt.getLeft() == null && bt.getRight() == null) {
            if (bt.getData() == key) {
                System.out.println("路径是：");
                for (int i : path) {
                    System.out.println(i);
                }
                System.out.println(bt.getData());
            }
        } else {
            path.push(bt.getData());
            findPath(bt.getLeft(),key-bt.getData(),path);
            findPath(bt.getRight(),key-bt.getData(),path);
            //回到父节点之前要删除当前结点的信息
            path.pop();
        }

    }

    /**
     * 利用栈模拟递归调用的过程，来实现前序遍历
     * 此方法扩展性很强，适用于中序和后序遍历中
     * @param root
     */
    public static void preOrder1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        //最终一定要栈为空而且，root为空才会跳出循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 先将右结点压栈，然后再将左结点压栈，之后再弹出，先会弹出左结点，然后弹出右结点
     * 扩展性不适合用在中序遍历和后序遍历
     * @param root
     */
    public static void preOrder2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.getData());
            if (root.getRight() != null) {
                stack.push(root.getRight());
            }
            if (root.getLeft() != null) {
                stack.push(root.getLeft());
            }
        }
    }

    /**
     * 和preOrder1()方法差不多，只是打印的区别
     * @param root
     */
    public static void InOrder1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }
    public static void postOrder1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root = stack.peek().getRight();
                if (root == null) {
//                    BinaryTreeNode root = stack.pop();
//                    System.out.println(btTemp.getData());
                } else {

                }
            }
        }
    }
}
