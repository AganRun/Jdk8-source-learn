package test.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        testHashMap();
//        testConcurrentHashMap();
    }

    static void testHashMap() {
        Map map = new HashMap();
        map.put(1, 1);
        map.put(1, 2);
        Map<Integer, List> map2 = new HashMap<>();
//        map2.put("1", new ArrayList());
        List values = map2.computeIfAbsent(1, id->{return new ArrayList();});
        values.add(2222);
        System.out.println(map2.get(1));
    }

    static void testConcurrentHashMap() {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("A", "A");
        map.put("A", "B");
    }
}
