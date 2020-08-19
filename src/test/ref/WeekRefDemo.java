package test.ref;

import java.lang.ref.WeakReference;

public class WeekRefDemo {

    public static void main(String[] args) {
        Person p = new Person("Job");
        WeakReference r = new WeakReference(p);
        System.out.println(r.get());  //job
        System.gc();    //系统回收
        System.out.println(r.get());  //job   此时还有强引用
        p = null;   //取消强引用
        System.gc();    //再回收
        System.out.println(r.get());  //null
    }

    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{ name='" + name + '}';
        }
    }
}
