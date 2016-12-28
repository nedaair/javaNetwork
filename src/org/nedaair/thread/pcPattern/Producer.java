package org.nedaair.thread.pcPattern;

/**
 * Created by nedaair on 2016-12-28.
 */
public class Producer implements Runnable {
    private Queue queue = null;

    public Producer(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("[ Start Producer.. ]");
        try{
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(Integer.toString(i++));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("[ End Producer.. ]");
        }

    }
}
