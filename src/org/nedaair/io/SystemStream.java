package org.nedaair.io;

import java.io.*;

/**
 * Created by nedaair on 2016-12-28.
 */
public class SystemStream {
    public static void main(String[] args) {
        try{
            int ch;
            while (true){
                PipedInputStream writeIn = new PipedInputStream();
                PipedOutputStream readOut = new PipedOutputStream(writeIn);

                ReadThread rt = new ReadThread(System.in,  readOut );
                ReadThread wt = new ReadThread(writeIn, System.out);


                rt.start();
                wt.start();
            }
        }catch (Exception e){}

    }
}

class ReadThread extends Thread{
    InputStream pi = null;
    OutputStream po = null;

    ReadThread(InputStream pi, OutputStream po){
        this.pi = pi;
        this.po = po;
    }

    public void run(){
        int ch;
        byte [] buffer = new byte[512];

        int bytes_read;

        try{
            for (;;){
                bytes_read = pi.read(buffer);
                if(bytes_read == -1)  return;
                po.write(buffer, 0, bytes_read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                po.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
