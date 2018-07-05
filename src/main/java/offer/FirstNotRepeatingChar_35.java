package offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表来实现第一个只出现一次的字符，哈希表是键值对的集合
 */
public class FirstNotRepeatingChar_35 {

    public static void main(String[] args) {

        FirstNotRepeatingChar_35  fnrc = new FirstNotRepeatingChar_35();
        System.out.println(fnrc.firstNotRepeatChar("abaccdeff"));
    }

    public char firstNotRepeatChar(String str) {
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("输入参数不合法");
        }
        // LinkedHashMap 是 HashMap 的一个子类，它保留插入的顺序，
        // 如果需要输出的顺序和输入时的相同，那么就选用 LinkedHashMap。
        Map<Character,Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i),1);
            }
        }

        Set<Character> sets = map.keySet();
        for(char set:sets) {
            System.out.print("key:"+set + "  ");
            System.out.println("value:"+map.get(set));
        }

        char result = '\0';
        for(int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                result = str.charAt(i);
                break;//必须要有break，因为是得到第一个只出现一次的字符
            }
        }
        return result;
    }
}
