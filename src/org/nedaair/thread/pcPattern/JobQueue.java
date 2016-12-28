package org.nedaair.thread.pcPattern;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by nedaair on 2016-12-28.
 */
public class JobQueue implements Queue {
    private static final String NAME = "JOB QUEUE";
    private static final Object monitor = new Object();

    private LinkedList jobs = new LinkedList();

    private static JobQueue instance = new JobQueue();

    private JobQueue() {}

    public static JobQueue getInstance(){
        if(instance == null){
            synchronized (JobQueue.class){
                instance = new JobQueue();
            }
        }

        return instance;
    }

    @Override
    public String getname() {
        return NAME;
    }

    @Override
    public void clear() {
        synchronized (monitor){
            jobs.clear();
        }
    }

    @Override
    public void put(Object o) {
        synchronized (monitor){
            System.out.println("monitor in thread : " + Thread.currentThread().getName() + " add value :" + o.toString() );
            jobs.addLast(o);
            monitor.notify();
        }
    }

    public LinkedList getLinkedList(){
        return jobs;
    }

    @Override
    public Object pop() throws InterruptedException, NoSuchElementException {
        Object o = null;
        synchronized (monitor){
            System.out.println("monitor in thread : " + Thread.currentThread().getName() );
             if(jobs.isEmpty()){
                 monitor.wait();
             }

             o = jobs.removeFirst();
        }l

        if(o == null) throw new NoSuchElementException();
        return o;
    }

    @Override
    public int size() {
        return jobs.size();
    }
}
