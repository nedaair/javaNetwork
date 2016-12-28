package org.nedaair.io;

import java.io.IOException;

/**
 * Created by nedaair on 2016-12-28.
 */
public class SystemInputTest {
    public static void main(String[] args) {
        int i=0;

        try {
            while ((i = System.in.read()) != -1){
               //System.out.write(i);
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
