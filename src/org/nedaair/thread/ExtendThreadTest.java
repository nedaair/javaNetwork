package org.nedaair.thread;

/**
 * Created by nedaair on 2016-12-27.
 */
public class ExtendThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ExtendThread();
        System.out.println("call thread start");
        thread.start();
        System.out.println("call thread end");
    }
}

class ExtendThread extends Thread {
    @Override
    public void run() {
        System.out.println("extends Thread");
    }
}