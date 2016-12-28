package org.nedaair.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nedaair on 2016-12-28.
 */
public class EchoThreadServer {
    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(10001);

            System.out.println("waiting........................");


            while (true){
                Socket socket = server.accept();

                EchoThread echoThread = new EchoThread(socket);
                echoThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class EchoThread extends Thread{

        private Socket socket;

        public EchoThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InetAddress address = socket.getInetAddress();

            System.out.println(address.getHostAddress() + " is coming..");

            try {
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

                String line = null;

                while((line = br.readLine()) != null){
                    System.out.println("message by client : " + line);

                    pw.println(line);
                    pw.flush();
                }

                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
