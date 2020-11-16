package test.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, 1);

        Map<Integer, List> map2 = new HashMap<>();
//        map2.put("1", new ArrayList());
        List values = map2.computeIfAbsent(1, id->{return new ArrayList();});
        values.add(2222);
        System.out.println(map2.get(1));
    }
}
