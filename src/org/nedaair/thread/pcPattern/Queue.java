package org.nedaair.thread.pcPattern;

import java.util.NoSuchElementException;

/**
 * Created by nedaair on 2016. 12. 28..
 */
public interface Queue {
    String getname();
    void clear();
    void put(Object o);
    Object pop() throws InterruptedException, NoSuchElementException;
    int size();

}
