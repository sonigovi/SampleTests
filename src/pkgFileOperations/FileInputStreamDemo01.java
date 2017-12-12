package pkgFileOperations;

import java.io.FileInputStream;

public class FileInputStreamDemo01 {
	public static void main(String[] args) {
		try {
			FileInputStream fin01 = new FileInputStream("C:\\temp\\FileOutputStreamEx01-B.txt");
			int i = fin01.read();
			System.out.println((char)i); //this will just print the first character
			fin01.close();
			fin01 = new FileInputStream("C:\\temp\\FileOutputStreamEx01-B.txt");
			i = 0;
			String s = "";
			while ((i=fin01.read())!=-1){
				System.out.println((char)i);
				s = s+(char)i;
			}
			System.out.println(s);
			fin01.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}