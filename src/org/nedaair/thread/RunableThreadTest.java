package org.nedaair.thread;

/**
 * Created by nedaair on 2016-12-27.
 */
public class RunableThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunableThread());

        thread.start();
    }
}

class RunableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("implements Runable Interface");
    }
}