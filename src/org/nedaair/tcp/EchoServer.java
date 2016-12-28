package org.nedaair.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nedaair on 2016-12-28.
 */
public class EchoServer {
    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(10001);

            System.out.println("waiting....");

            Socket sock = server.accept();

            InetAddress address = sock.getInetAddress();

            System.out.println(address.getHostAddress() + "is coming");

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while((line = br.readLine()) != null){
                System.out.println("message by client : " + line);
                pw.println(line);
                pw.flush();
            }

            pw.close();
            br.close();
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
