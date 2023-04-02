package Test;

import java.util.Map;

public class LinkedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new java.util.LinkedHashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        System.out.println(map.toString() );
    }
}
