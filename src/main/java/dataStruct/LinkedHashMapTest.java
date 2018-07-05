package dataStruct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap 是 HashMap 的一个子类，它保留插入的顺序，
 * 如果需要输出的顺序和输入时的相同，那么就选用 LinkedHashMap。
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>();

        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");
        /**
         * 方法１：使用系统的Set和Value,方法１和方法２效果都是一样的
         */
        Set<String> sets = map.keySet();
        for(String set : sets) {
            System.out.println(set+"="+map.get(set));
        }

        System.out.println("---------------------------");
        /**
         * 方法２，使用迭代器Iterator,它通常和List放在一起使用
         */
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
