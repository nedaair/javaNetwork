package org.nedaair.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by nedaair on 2016-12-28.
 */
public class DataOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("FileData.bin");
            dos = new DataOutputStream(fos);

            dos.writeBoolean(true);
            dos.writeByte(5);
            dos.writeInt(100);
            dos.writeDouble(200.5);
            dos.writeUTF("hello god");

            System.out.println("saved");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
