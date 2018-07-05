package offer;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstCharacterInStream_55 {
    public static void main(String[] args) {
        FirstCharacterInStream_55 cs = new FirstCharacterInStream_55();
        cs.firstAppearingOnce("google");
        cs.firstAppearingOnce("0");
        cs.firstAppearingOnce(null);
    }

    boolean isInvalidInput = false;
    public char firstAppearingOnce(String str) {
        char result = '0';
        if (str == null || str.length() <= 0) {
            isInvalidInput = true;
            System.out.println(isInvalidInput);
            return result;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if ((Integer)entry.getValue() == 1) {
                result = (Character)entry.getKey();
                System.out.print(entry.getKey() + "\t");
                break;
            }
        }
        System.out.println(isInvalidInput);
        return result;
    }
}
