package pkgFileOperations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/*Java ByteArrayOutputStream class is used to write common data into multiple files. In this stream, the data is written into a byte array which can be written to multiple streams later.

The ByteArrayOutputStream holds a copy of data and forwards it to multiple streams.

The buffer of ByteArrayOutputStream automatically grows according to data.
*/
public class ByteArrayOutputStreamDemo01 {
	public static void main(String[] args) {
		try {
			FileOutputStream fout01 = new FileOutputStream("C:\\temp\\ByteArrayOutputStreamDemo01-A.txt");
			FileOutputStream fout02 = new FileOutputStream("C:\\temp\\ByteArrayOutputStreamDemo01-B.txt");
			ByteArrayOutputStream bais = new ByteArrayOutputStream();
			
			bais.write(65);
			bais.writeTo(fout01);
			bais.writeTo(fout02);
			
			fout01.close();
			fout02.close();
			bais.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}