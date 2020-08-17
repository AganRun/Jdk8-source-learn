package test.thread;

public class DeadLock {

    public final Object LockA = new Object();
    public final Object LockB = new Object();
    public int value1 = 0;
    public int value2 = 0;

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        deadLock.test();
    }

    public void test() throws InterruptedException {
        DeadLock lock = new DeadLock();
        Thread1 thread1 = new Thread1(lock);
        Thread2 thread2 = new Thread2(lock);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("-------------");
    }

    public void add() {
        synchronized (LockA) {
            value1++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LockB) {
                value2++;
            }
        }
    }

    public void dec() {
        synchronized (LockB) {
            value2--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LockA) {
                value1--;
            }
        }
    }

    class Thread1 extends Thread {
        DeadLock deadLock;
        Thread1(DeadLock deadLock) {
            this.deadLock = deadLock;
        }
        @Override
        public void run() {
            deadLock.add();
        }
    }

    class Thread2 extends Thread {
        DeadLock deadLock;
        Thread2(DeadLock deadLock) {
            this.deadLock = deadLock;
        }
        @Override
        public void run() {
            deadLock.dec();
        }
    }
}
