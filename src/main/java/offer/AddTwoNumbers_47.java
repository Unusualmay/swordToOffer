package offer;

public class AddTwoNumbers_47 {
    public static void main(String[] args) {
        AddTwoNumbers_47 at = new AddTwoNumbers_47();
        System.out.println(at.add(5,17));
    }

    public int add(int num1, int num2) {
        while(num2 != 0) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
}
