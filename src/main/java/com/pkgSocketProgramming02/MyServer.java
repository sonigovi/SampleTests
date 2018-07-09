package com.pkgSocketProgramming02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss1 = new ServerSocket(6667);
            Socket s1 = ss1.accept();

            DataInputStream din = new DataInputStream(s1.getInputStream());
            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());

            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg = "";
            String serverMsg = "";

            while (clientMsg != "Stop") {
                clientMsg = din.readUTF();
                System.out.println("Client says " + clientMsg);
                serverMsg = buff.readLine();
                dos.writeUTF(serverMsg);
                dos.flush();
            }

            din.close();
            // dos.close();
            // buff.close();
            s1.close();
            ss1.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
