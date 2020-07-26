package test.list;

import java.util.ArrayList;

class MList {
    int size = 0;
    Object[] elementData = new Object[2000];

    boolean add(Object e) throws InterruptedException {
        elementData[size] = e;
        Thread.sleep(10);
        size++;
        return true;
    }

    int size() {
        return this.size;
    }

    Object get(int i) {
        return elementData[i];
    }
}

public class ArrayListUnSafeTest {

    public static void main(String[] args) throws Exception {

        MList list = new MList();

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        list.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 10; i < 20; i++) {
                    try {
                        Thread.sleep(1);
                        list.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
