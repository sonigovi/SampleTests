package com.pkgFileOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo02 {
    public static void main(String[] args) {
        try {
            FileInputStream fin05 = new FileInputStream("D:\\Users\\gosoni\\desktop\\Tasks.txt");
            FileInputStream fin07 = new FileInputStream("D:\\Users\\gosoni\\desktop\\tmp.txt");
            SequenceInputStream inst01 = new SequenceInputStream(fin05, fin07);
            FileOutputStream fout07 = new FileOutputStream("C:\\temp\\SequenceInputStreamDemo02.txt");

            int i = 0;
            while ((i = inst01.read()) != -1) {
                fout07.write((char) i);
            }
            fin05.close();
            fin07.close();
            inst01.close();
            fout07.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
