package org.nedaair.thread;

/**
 * Created by nedaair on 2016-12-27.
 */
public class AdvancedStopThreadTest {
    public static void main(String[] args) {
        System.out.println("test start");

        AdvancedStopThreadTest test = new AdvancedStopThreadTest();
        test.process();
    }

    private void process() {
        Thread thread = new Thread(new AdvancedStopThread());

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("process exception");
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

class AdvancedStopThread implements Runnable{

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){

                System.out.println("Thread is alive");

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("thread exception");
            e.printStackTrace();
        } finally {
            System.out.println("Thread is dead");
        }
    }
}
