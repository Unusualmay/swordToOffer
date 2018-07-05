package offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeleteRepeatChar_35 {
    public static void main(String[] args) {
        DeleteRepeatChar_35 drc = new DeleteRepeatChar_35();
        System.out.println(drc.deleteRepeatChar("google"));
    }

    public String deleteRepeatChar(String str) {
        StringBuilder result = new StringBuilder();
        Map<Character,Boolean> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),true);
            } else {
                map.put(str.charAt(i),false);
            }
            if (!map.get(str.charAt(i))) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
