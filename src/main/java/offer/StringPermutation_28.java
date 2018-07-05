package offer;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation_28 {
    int count = 1;
    public static void main(String[] args) {
        StringPermutation_28 sp = new StringPermutation_28();
        char[] str = new char[]{'a','b','c','d'};
//        sp.permution(str,0);
        sp.combination(str);

    }
    public void permution(char[] str,int i) {
        if (str == null || i<0 || i > str.length) {
            return;
        }
        if (i == str.length) {
            System.out.println(str);
        }
        //固定第一个字符a，后面两个字符bc的排列。
        for(int j = i; j < str.length; j++) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            //递归交换
            permution(str,i+1);
            //交换了ab之后要换回来再换ac
            temp = str[j];
            str[j] = str[i];
            str[i] = temp;
        }
    }
    public void combination(char[] str) {
        if (str==null) {
            return;
        }

        List<Character> list = new ArrayList<Character>();
        //分步考虑，不同组合的字符个数下的显示
        for(int i = 1; i <= str.length; i++) {
            combination(str, 0, i, list);
        }
    }

    /**
     * 实现组合，假设想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
     * 针对第一个字符,我们有两种选择，一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个
     * 字符中选取m-1个字符；二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m
     * 个字符。这两种方法都可以用递归来解决
     * @param str
     * @param begin
     * @param nums
     * @param list
     */
    public void combination(char[] str, int begin, int nums, List<Character> list) {
       if (nums > str.length) {
           return;
       }
       if (nums == 0) {
           for(int i = 0; i < list.size(); i++) {
               System.out.print(list.get(i));
           }
           System.out.println();
           return;
       }
       if (begin ==  str.length) {
           return;
       }
        //字符数组的第一个元素在组合中
       list.add(str[begin]);
       combination(str,begin+1,nums-1,list);
       //字符数组的第一个元素不在组合中
       list.remove((Character) str[begin]);
       combination(str,begin+1,nums,list);
    }
}
