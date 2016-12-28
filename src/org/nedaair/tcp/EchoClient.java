package org.nedaair.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by nedaair on 2016-12-28.
 */
public class EchoClient {
    public static void main(String[] args) {

        try {
            Socket client = new Socket("127.0.0.1", 10001);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


            OutputStream out = client.getOutputStream();
            InputStream  in  = client.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter    pw = new PrintWriter(new OutputStreamWriter(out));

            String line  = null;

            while((line = keyboard.readLine()) != null){
                if(line.equals("quit")) break;

                pw.println(line);
                pw.flush();

                String echo = br.readLine();

                System.out.println("echo message by server : "+ echo);
            }

            pw.close();
            br.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
