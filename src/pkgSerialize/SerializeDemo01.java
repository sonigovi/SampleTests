package pkgSerialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;  

public class SerializeDemo01 {
	public static void main(String[] args) throws Exception{
		Student s1 = new Student(211,"ravi");  
		FileOutputStream fout = new FileOutputStream("f.txt");  
		ObjectOutputStream out = new ObjectOutputStream(fout);  

		out.writeObject(s1);  
		out.flush();
		out.close();
		System.out.println("success");  
	}
}
