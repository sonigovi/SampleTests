package pkgSocketProgramming02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("localhost", 6667);
			DataInputStream dis = new DataInputStream(s1.getInputStream());
			DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String serverMsg = "";
			String clientMsg = "";
			
			while (serverMsg!="Stop"){
				serverMsg = dis.readUTF();
				System.out.println(serverMsg);
				
				clientMsg = br.readLine();
				
				dos.writeUTF(clientMsg);
				dos.flush();
			}
			
			dis.close();
			s1.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}