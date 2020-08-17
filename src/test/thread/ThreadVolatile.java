package test.thread;

public class ThreadVolatile {

    public static void main(String[] args) throws InterruptedException {
        HelloTread2 t = new HelloTread2();
        t.start();
        Thread.sleep(100);
        t.running = false;
    }
}

class HelloTread2 extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("I am running");
        }
    }
}