package test.thread;

import org.junit.Test;

public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocalUser = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo local1 = new ThreadLocalDemo();
        ThreadLocalDemo local2 = new ThreadLocalDemo();
        local1.threadLocalUser.set("User1");
        local2.threadLocalUser.set("User2");
        System.out.println(threadLocalUser.get());
        local1.printThread();
        local2.printThread();
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
