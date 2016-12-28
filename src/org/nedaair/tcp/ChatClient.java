package org.nedaair.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by nedaair on 2016-12-28.
 */
public class ChatClient {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("usage : java ChatClient id targetIp");
            System.exit(0);
        }


        Socket client = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        boolean endFlag = false;

        try {
            client = new Socket(args[1], 10001);

            pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            pw.println(args[0]);
            pw.flush();

            InputThread it = new InputThread(client, br);
            it.start();

            String line = null;

            while ((line = keyboard.readLine()) != null){
                pw.println(line);
                pw.flush();

                if(line.equals("/quit")){
                    endFlag = true;
                    break;
                }
            }

            System.out.println("disconnected....");

        } catch (IOException e) {
            if(!endFlag)
                e.printStackTrace();
        } finally {
            pw.close();
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static class InputThread extends Thread {
        private Socket client;
        private BufferedReader br;

        public InputThread(Socket client, BufferedReader br) {
            this.client = client;
            this.br = br;
        }

        @Override
        public void run() {
            try{

                String line = null;

                while ((line = br.readLine()) != null){
                    System.out.println(line);

                }

            }catch (Exception e){

            }finally {
                try {
                    if(br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(client!= null) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
