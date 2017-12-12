package UrlToFileDownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadSingleImageFile {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://fbapp.itcuties.com/middle/_DSC4598.jpg");
			File destinationFile = new File("C:\\temp\\imageDownload\\borrowedImg.jpg");
			
			int n = 0;
			byte[] buf = new byte[1024];

			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			while ((n=in.read(buf))!=-1){
				baos.write(buf,0,n);
			}
			
			baos.close();
			in.close();
			
			byte[] response = baos.toByteArray();
			
			FileOutputStream fos = new FileOutputStream(destinationFile);
			fos.write(response);
			fos.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (ConnectException e){
			e.printStackTrace();
			System.out.println("Check firewall setting");
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
