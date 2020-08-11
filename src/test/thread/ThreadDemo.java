package test.thread;

import org.junit.Test;

public class ThreadDemo {

    @Test
    public void testRun() {
        System.out.println("main start");
        Runnable runnable = () -> {
            System.out.println("thread start");
            System.out.println("thread end");
        };
        Thread thread = new Thread(runnable, "AganRunThread");
        thread.start();
        System.out.println("main end");
    }

    /**
     * 可以对线程设定优先级，操作系统对高优先级线程可能调度更频繁，但不能保证顺序
     */
    @Test
    public void testPriority() {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread1 = new Thread(runnable, "A");
        thread1.setPriority(10);
        Thread thread2 = new Thread(runnable, "B");
        thread2.setPriority(1);

        thread2.start();
        thread1.start();
    }

    /**
     * join()方法：当前线程会进入阻塞状态，等待指定线程执行结束再继续运行。
     * 可以指定等待时间戳，超过等待时间线程仍然没有结束就不再等待；
     * @throws InterruptedException
     */
    @Test
    public void testJoin() throws InterruptedException {
        System.out.println("main start");
        Runnable runnable = () -> {
            System.out.println("thread start");
            System.out.println("thread end");
        };
        Thread thread = new Thread(runnable, "AganRunThread");
        thread.start();
        thread.join();
        System.out.println("main end");
    }
}
