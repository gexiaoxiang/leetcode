package com.eden;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author wcc
 * @date 2021/8/21 20:46
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */
public class Test2 {


    public static void main(String[] args) throws Exception {
//        write();
        read();

    }


    public static void write() throws Exception {
        String a = "你好哈 ！！！sdsdd";
        String filePath = "F:\\1.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        byte[] bytes = a.getBytes();
        fileOutputStream.write(bytes, 0, bytes.length);
        fileOutputStream.flush();
    }

    public static void read() throws Exception {

        String filePath = "F:\\1.txt";
        FileInputStream fileOutputStream = new FileInputStream(filePath);
        byte[] bytes = new byte[1024];
        int readCount=0;
        while ((readCount=fileOutputStream.read(bytes))!=-1) {

            System.out.println(new String(bytes,0,readCount,"UTF-8"));
        }
        ;


    }

}
