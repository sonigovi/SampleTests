package pkgFileOperations;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*Java DataOutputStream class allows an application to write primitive Java data types to the output stream in a machine-independent way.

Java application generally uses the data output stream to write data that can later be read by a data input stream.
*/

//public class DataOutputStream extends FilterOutputStream implements DataOutput  

public class DataOutputStreamDemo01 {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("C:\\temp\\DataOutputStreamDemo01.txt");
			DataOutputStream dout = new DataOutputStream(fout);
			dout.write(65);
			dout.writeByte(10);
			dout.writeInt(65);
			dout.writeByte(65);
			//dout.writeChar("x");
			dout.writeChars("String writeChars");
			
			fout.close();
			dout.flush();
			dout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
