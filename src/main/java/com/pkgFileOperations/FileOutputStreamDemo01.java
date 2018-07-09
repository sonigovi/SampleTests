package com.pkgFileOperations;

import java.io.FileOutputStream;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) {
        try {
            FileOutputStream Fout = new FileOutputStream("C:\\temp\\FileOutputStreamEx01-A.txt");
            Fout.write(65);
            Fout.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        try {
            FileOutputStream Fout01 = new FileOutputStream("C:\\temp\\FileOutputStreamEx01-B.txt");
            String s = "Welcome to the Java learning";
            byte b1[] = s.getBytes(); // converting string into byte array
            Fout01.write(b1);
            Fout01.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
