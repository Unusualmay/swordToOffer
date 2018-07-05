package offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class IsAnagram_35 {
    public static void main(String[] args) {
        IsAnagram_35 ia = new IsAnagram_35();
        System.out.println(ia.isAnagram("lisdten","silewnt"));
    }
    public boolean isAnagram(String word1, String word2) {
        boolean isAnagramWord = false;
        if (word1==null || word2 == null) {
            throw new IllegalArgumentException("输入参数不合法");//抛了异常之后就不能带有return
        }
        //两个的长度不一致，则直接返回false
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < word1.length(); i++) {
            if(map.containsKey(word1.charAt(i))) {
                map.put(word1.charAt(i),map.get(word1.charAt(i))+1);
            } else {
                map.put(word1.charAt(i),1);
            }
        }
        for(int j = 0; j < word2.length(); j++) {
            if (map.containsKey(word2.charAt(j))) {
                map.put(word2.charAt(j),map.get(word2.charAt(j))-1);
            }
        }
        //使用Iterator,必须要使用iterator()方法
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            isAnagramWord = true;
            if ((Integer)entry.getValue() != 0) {
                isAnagramWord = false;
                break;
            }
        }
        return isAnagramWord;
    }
}
