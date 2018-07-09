package com.pkgFileOperations;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo01 {
    private static BufferedOutputStream os;

    public static void main(String[] args) {
        try {
            FileOutputStream Fout = new FileOutputStream("C:\\temp\\BufferedOutputStreamEx01-A.txt");
            BufferedOutputStream Bout = new BufferedOutputStream(Fout);
            String s = "Welcome to Nova - The planet of Apes";
            byte[] b = s.getBytes();
            Bout.write(b);
            Bout.flush();
            Bout.close();
            Fout.close();
            System.out.println("Success...");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}