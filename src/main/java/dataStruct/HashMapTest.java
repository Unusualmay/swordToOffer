package dataStruct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HashMap是无序的表
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        /**
         * 方法１：使用系统的Set和Value
         */
        Set<String> sets = map.keySet();
        for(String set : sets) {
            System.out.println(set+"="+map.get(set));
        }

        System.out.println("----------------------");
        /**
         * 方法２：使用迭代器，它通常和List放在一起使用
         */
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
