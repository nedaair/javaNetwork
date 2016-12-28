package org.nedaair.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by nedaair on 2016-12-28.
 */
public class FileView {
    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("usage : FileView file");
            System.exit(0);
        }

        FileInputStream fis = null;


        try {
            fis = new FileInputStream(args[0]);

            int readCount=0;

            byte [] buffer = new byte[512];

            while ((readCount = fis.read(buffer)) != -1){
                System.out.write(buffer, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
