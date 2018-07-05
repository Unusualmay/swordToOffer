package offer;

import java.util.Stack;

public class MinInStack_21 {
    //在类中定义的变量是全局变量，她是存在于堆中的
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public static void main(String[] args) {
        MinInStack_21 myStack = new MinInStack_21();
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(1);
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());

    }
    public void push(int data) {
        if (minStack.empty()) {
            dataStack.push(data);
            minStack.push(data);
        } else if (data < min()) {
            dataStack.push(data);
            minStack.push(data);
        } else {
            dataStack.push(data);
            minStack.push(min());
        }
    }
    public void pop() {
        //注意：空栈和栈的引用为空这是两个 概念，即：dataStack==null是代表没有实例化，而dataStack.empty()是栈中的元素为空
        if (dataStack.empty() || minStack.empty()) {
            return;
        }
        dataStack.pop();
        minStack.pop();
    }
    public Integer min() {
        if (dataStack.empty()) {
            return null;
        }
        return minStack.peek();
    }
}
