package pkgFileOperations;

import java.io.FileInputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo03Enum {
	public static void main(String[] args) {
		try{
			FileInputStream fin01 = new FileInputStream("D:\\Users\\gosoni\\desktop\\Tasks.txt");
			FileInputStream fin02 = new FileInputStream("D:\\Users\\gosoni\\desktop\\tmp.txt");
			FileInputStream fin03 = new FileInputStream("D:\\Users\\gosoni\\desktop\\Kaizens.txt");
			
			//creating Vector object to all the stream    
			Vector v = new Vector();
			v.add(fin01);
			v.add(fin02);
			v.add(fin03);
	
			//creating enumeration object by calling the elements method    
			Enumeration e = v.elements(); 
			
			//passing the enumeration object in the constructor    
			SequenceInputStream bin = new SequenceInputStream(e);
			
			int i=0;
			String s = "";
			while ((i=bin.read())!=-1){
				s=s+((char)i);
			}
			
			fin01.close();
			fin02.close();
			fin03.close();
			bin.close();
			
			System.out.println(s);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
