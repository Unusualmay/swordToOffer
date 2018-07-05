package offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 一样的使用哈希表来解决这个问题
 */
public class DeleteStr2FromStr1_35 {
    public static void main(String[] args) {
        DeleteStr2FromStr1_35  d = new DeleteStr2FromStr1_35();
        System.out.println(d.deleteStr2FromStr1("We are students","aeiou"));
    }

    public String deleteStr2FromStr1(String str1, String str2) {
        StringBuilder str = new StringBuilder();
        //先创建哈希表将str2存储起来
        Map<Integer,Character> map = new LinkedHashMap<>();
        for(int i = 0; i < str2.length(); i++) {
            map.put(i,str2.charAt(i));
        }
        //遍历str1，看是否存在有str2中的元素，如果有，则删除
        for(int i = 0; i < str1.length(); i++) {
            if (!map.containsValue(str1.charAt(i))) {
                str.append(str1.charAt(i));
            }
        }
        return str.toString();
    }

}
