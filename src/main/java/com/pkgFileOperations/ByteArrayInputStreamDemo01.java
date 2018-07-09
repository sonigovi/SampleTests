package com.pkgFileOperations;

import java.io.ByteArrayInputStream;

/*The ByteArrayInputStream is composed of two words: ByteArray and InputStream. As the name suggests, it can be used to read byte array as input stream.

Java ByteArrayInputStream class contains an internal buffer which is used to read byte array as stream. In this stream, the data is read from a byte array.

The buffer of ByteArrayInputStream automatically grows according to data.*/

//public class ByteArrayInputStream extends InputStream

public class ByteArrayInputStreamDemo01 {
    public static void main(String[] args) {
        byte[] buf = { 35, 36, 37, 38 };
        ByteArrayInputStream byt = new ByteArrayInputStream(buf);
        int k = 0;
        while ((k = byt.read()) != -1) {
            System.out.println("ASCII value of " + k + " is " + (char) k);
        }
    }
}