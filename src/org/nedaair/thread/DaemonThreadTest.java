package org.nedaair.thread;

/**
 * Created by nedaair on 2016-12-27.
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread End");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //thread.setDaemon(true);
        thread.start();
        System.out.println("Main Thread end");
    }
}


