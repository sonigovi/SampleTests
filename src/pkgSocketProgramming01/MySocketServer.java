package pkgSocketProgramming01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6667);
			Socket s = ss.accept(); // Establishes connection
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			String str = (String)dis.readUTF();
			System.out.println("Message from Client "+str);
			
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}