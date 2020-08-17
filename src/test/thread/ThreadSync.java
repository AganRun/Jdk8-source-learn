package test.thread;

public class ThreadSync {

    public static int count;
    public static void main(String[] args) throws InterruptedException {
        Thread addThread = new AddThread();
        Thread decThread = new DecThread();
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(count);
    }
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            ThreadSync.count++;
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            ThreadSync.count--;
        }
    }
}