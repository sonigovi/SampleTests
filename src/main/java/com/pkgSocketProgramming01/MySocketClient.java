package com.pkgSocketProgramming01;

import java.io.DataOutputStream;
import java.net.Socket;

public class MySocketClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6667);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF("Hello");

            dos.flush();
            dos.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
