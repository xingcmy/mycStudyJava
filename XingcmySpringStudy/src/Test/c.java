package Test;

import java.util.HashMap;
import java.util.Map;

public class c {
    public static void main(String[] args) {
        String hello = "helloworld!你好";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] ch = hello.toCharArray();
        for (char c : ch) {
            System.out.println(c);
            Integer i = map.get(c);
            if (i == null) {
                map.put(c, 1);
            } else {
                map.put(c, i.intValue() + 1);
            }
        }

        System.out.println(map);
    }
}
