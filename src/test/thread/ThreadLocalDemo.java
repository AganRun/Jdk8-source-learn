package test.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocalUser = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo local1 = new ThreadLocalDemo();
        ThreadLocalDemo local2 = new ThreadLocalDemo();
        local1.threadLocalUser.set("User1");
        local1.threadLocalUser.set("User1");
        local1.threadLocalUser.set("User2");
        local2.threadLocalUser.set("User2");
        System.out.println(threadLocalUser.get());
        local1.printThread();
        local2.printThread();
    }

    /**
     * 测试Hash冲突。
     * 测试remove方法，清理Hash冲突的旧数据比较难。
     * 需要Hash冲突，即两个ThreadLocal的Key相同，可是还没得Hash冲突就扩容了
     */
    @Test
    public void reHash() {
        List<ThreadLocal<String>> threadLocals = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            ThreadLocal<String> local = new ThreadLocal<>();
            local.set("test" + i);  //此时把断点打到rehash()方法
            threadLocals.add(local);
        }
    }

    @Test
    public void processUser() {
        threadLocalUser.set("User");
        try {
            process1();
            process2();
        } finally {
            threadLocalUser.remove();
        }
    }

    private void process2() {
        String user = threadLocalUser.get();
        System.out.println("process2, length: " + user.length() );
    }

    private void process1() {
        String user = threadLocalUser.get();
        System.out.println("process1, str: " + user);
    }

    public void printThread() {
        System.out.println(Thread.currentThread().getName());
    }
}
