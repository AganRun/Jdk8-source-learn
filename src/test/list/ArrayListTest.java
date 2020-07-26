package test.list;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(11);//添加第11个元素，此时开始扩容
        list.get(5);
        list.remove(5);
    }
}
