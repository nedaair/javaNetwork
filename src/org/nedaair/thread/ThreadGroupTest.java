package org.nedaair.thread;

/**
 * Created by nedaair on 2016-12-27.
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        System.out.println("current Thread Group :" + Thread.currentThread());

        ThreadGroup group1 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "ThreadGroup1");

        ThreadGroup group2 = new ThreadGroup("ThreadGroup2");

        ThreadGroup group3 = new ThreadGroup(group1, "ThreadGroup3");


        Thread thread1 = new Thread(group1, "Thread1");
        Thread thread2 = new Thread(group2, "Thread2");
        Thread thread3 = new Thread(group3, "Thread3");


        System.out.println("T1 : " + thread1);
        System.out.println("T2 : " + thread2);
        System.out.println("T3 : " + thread3);

        System.out.println("main thread group : " + Thread.currentThread().getThreadGroup() + ", active thread count : "+ Thread.currentThread().getThreadGroup().activeCount()
                  + ", active thread group count : " + Thread.currentThread().getThreadGroup().activeGroupCount());

        Thread.currentThread().getThreadGroup().list();

    }
}
