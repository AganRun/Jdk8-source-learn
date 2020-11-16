package test.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static final Integer CORE_POOL_SIZE = 5;
    public static final Integer MAXIMUM_POOL_SIZE = 10;
    public static final Integer KEEP_ALIVE_TIME = 10;
    public static final Integer QUEUE_CAPACITY = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getId() + "start");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "end");
        };

        for (int i = 0; i < 100; i++) {
            System.out.println("------" + i + "------");
            executor.execute(runnable);
        }

        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
