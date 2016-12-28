package org.nedaair.io;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

/**
 * Created by nedaair on 2016-12-28.
 */
public class FileInfoTest {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("need file info");
            System.exit(0);
        }

        File f = new File(args[0]);

        System.out.println(args[0]);
        System.out.println(f.exists());



        if(f.exists()){
            System.out.println(f.length());
        }
    }
}
