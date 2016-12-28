package org.nedaair.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by nedaair on 2016-12-28.
 */
public class NsLookupLocal {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();

            System.out.println("hostName : " + address.getHostName());
            System.out.println("hostAddress : " + address.getHostAddress());

            byte [] ip = address.getAddress();

            for(int i=0; i < ip.length; i++){
                System.out.print((int)ip[i]);
                if(i != ip.length -1) {
                    System.out.print(".");
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
