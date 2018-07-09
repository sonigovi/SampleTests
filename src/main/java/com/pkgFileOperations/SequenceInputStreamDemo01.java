package com.pkgFileOperations;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo01 {
    public static void main(String[] args) {
        try {
            FileInputStream fin11 = new FileInputStream("D:\\Users\\gosoni\\desktop\\Tasks.txt");
            FileInputStream fin13 = new FileInputStream("D:\\Users\\gosoni\\desktop\\tmp.txt");
            SequenceInputStream inst = new SequenceInputStream(fin11, fin13);
            String s = "";
            int i;
            while ((i = inst.read()) != -1) {
                s = s + (char) i;
                // Thread.sleep(1);
            }
            System.out.println(s);
            fin11.close();
            fin13.close();
            inst.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
