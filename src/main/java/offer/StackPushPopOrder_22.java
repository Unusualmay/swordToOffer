package offer;

import java.util.Stack;

public class StackPushPopOrder_22 {
    public static void main(String[] args) {
        int[] pushData = new int[] {1,2,3,4,5};
        int[] popData = new int[] {4,5,3,2,1};
        System.out.println(IsPopOrder(pushData,popData));
    }
    public static boolean IsPopOrder(int[] pushData, int[] popData) {
        Stack stack = new Stack();
        if (pushData==null || popData==null || pushData.length==0 || popData.length==0) {
            return false;
        }
        //当栈顶元素与popData[j]相等时，弹出栈顶元素（循环弹出），如果不相等，则继续按照压栈顺序压入数据
        for (int i = 0 ,j = 0; i < popData.length; i++) {
            stack.push(pushData[i]);
            while(j < popData.length && (int)stack.peek()==popData[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();

    }
}
