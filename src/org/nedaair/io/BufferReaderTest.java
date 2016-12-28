package org.nedaair.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nedaair on 2016-12-28.
 */
public class BufferReaderTest {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();

            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
