package offer;

public class LeftRotateString_42_2 {
    public static void main(String[] args) {
        LeftRotateString_42_2 lrs = new LeftRotateString_42_2();
        char[] result = lrs.leftRotateString("abcdefg",2);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
    public char[] leftRotateString(String str, int num) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        char[] result = str.toCharArray();
        reverse(result,0,result.length-1);
        reverse(result,0,result.length-3);
        reverse(result,result.length-2,result.length-1);
        return result;
    }

    public void reverse(char[] str,int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
