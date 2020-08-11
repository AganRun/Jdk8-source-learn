package test.thread;

/**
 * 发送了中断请求，目标线程是否立即相应要看其代码设计。
 * 如果线程处于等待状态（wait、join、sleep），调用了interruput()，等待代码处，会抛出InterruptedException
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("I can print continue");
            }
        });
//        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
