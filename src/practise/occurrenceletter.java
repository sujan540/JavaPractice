package practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class occurrenceletter {
    public static void main(String[] args) {
        String str = "123sfwer23";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                Integer count = map.get(str.charAt(i));
                map.put(str.charAt(i), count + 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
