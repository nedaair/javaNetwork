package org.nedaair.thread.pcPattern;

/**
 * Created by nedaair on 2016-12-28.
 */
public class Tester {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = JobQueue.getInstance();

        Thread con1 = new Thread(new Consumer(queue, "1"), "Consumer-1");
        Thread con2 = new Thread(new Consumer(queue, "2"), "Consumer-2");
        Thread con3 = new Thread(new Consumer(queue, "3"), "Consumer-3");

        con1.start();
        con2.start();
        con3.start();

        Thread pro = new Thread(new Producer(queue), "Producer");

        pro.start();

        Thread.sleep(10);

        pro.interrupt();
    }
}
