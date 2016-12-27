package org.nedaair.thread;

import java.util.Random;

/**
 * Created by nedaair on 2016-12-27.
 */
public class ThreadLocalTest {

    static volatile int counter = 0;

    static Random random = new Random();

    private static class ThreadLocalObject extends ThreadLocal{

        Random random = new Random();

        @Override
        protected Object initialValue() {
            return new Integer(random.nextInt(1000));
        }
    }

    static ThreadLocal threadLocal = new ThreadLocalObject();

    private static void displayValues(){
        System.out.println("Thread Name : " + Thread.currentThread().getName() +
                           ", initial Value : " + threadLocal.get() +
                           ", counter : " + counter
        );
    }

    public static void main(String[] args) {
        displayValues();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadLocalTest.class){
                    counter++;
                }

                displayValues();

                try{
                    Thread.sleep(((Integer)threadLocal.get()).intValue());
                    displayValues();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        for(int i=0; i< 3; i++){
            Thread t = new Thread(runnable);
            t.start();
        }

    }
}
