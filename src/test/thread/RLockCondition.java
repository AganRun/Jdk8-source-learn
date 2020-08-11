package test.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLockCondition {

    public static void main(String[] args) throws InterruptedException {
        TaskConditionQueue queue = new TaskConditionQueue();
        List<Thread> consumers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread consumer = new Thread( () -> {
                while (true) {
                    try {
                        System.out.println("consumer -> " + queue.get());
                    } catch (InterruptedException e) {
                        System.out.println("consumer over");
                        return; //保证run方法可以结束，线程可以退出
                    }
                }
            });
            consumers.add(consumer);
            consumer.start();
        }
        Thread producer = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                String s = "product" + String.valueOf(i);
                System.out.println("product ->" + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.add(s);
            }
        });
        producer.start();
        producer.join();
        Thread.sleep(100);  //留一些时间去消费，不然可能最后一个没有被消费
        consumers.forEach( c -> c.interrupt());
    }
}

class TaskConditionQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void add(String str) {
        lock.lock();
        try {
            queue.add(str);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }


}