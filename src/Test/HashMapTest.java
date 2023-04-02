package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: algo
 * @description: TODO
 * @author: ycbron
 * @create: 2022-07-11 00:40
 **/
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 11);
        map.put("bb", 22);
        map.put("cc", 33);

        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            System.out.println("key=" + next.getKey() + "value=" + next.getValue());
        }
    }
}
