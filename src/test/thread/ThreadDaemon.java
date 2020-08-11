package test.thread;

/**
 * 守护线程是指为其他线程服务的线程。
 * 在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出（随后守护线程也执行结束）。
 */
public class ThreadDaemon {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Alive");
            }
        });
        t.setDaemon(true);
        t.start();
//        Thread.sleep(100);
        System.out.println("程序退出");
    }
}
