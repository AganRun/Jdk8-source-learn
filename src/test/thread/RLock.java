package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLock {

    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        RLock rLock = new RLock();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(rLock::add);
            t.start();
        }
        Thread.sleep(2000);
        System.out.println(rLock.count);
    }
    
    public void add() {
        lock.lock();
        try {
            Thread.sleep(2);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    

}
