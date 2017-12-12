package pkgFileOperations;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo01 {
	public static void main(String[] args) {
		try {
			FileInputStream fin01 = new FileInputStream("C:\\temp\\BufferedOutputStreamEx01-A.txt");
			BufferedInputStream Bin01 = new BufferedInputStream(fin01);
			int i = 0;
			String s = "";
			while ((i=Bin01.read())!=-1){
				System.out.println((char)i);
				s = s+(char)i;
			}
			System.out.println(s);
			fin01.close();
			Bin01.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}