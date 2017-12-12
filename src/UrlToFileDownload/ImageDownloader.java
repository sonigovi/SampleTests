package UrlToFileDownload;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader{
	private String imageUrl;
	private String destinationPath;
	
	public ImageDownloader(String imageUrl, String destinationPath){
		this.imageUrl = imageUrl;
		this.destinationPath = destinationPath;
	}
	
	public void download() throws Exception{
		URL url = new URL(imageUrl);
		InputStream is = new BufferedInputStream(url.openStream());
		FileOutputStream fout = new FileOutputStream(destinationPath);
		
		//int nameIndex = 0;
		long imgDownloadStartTime = 0;
		long imgDownloadEndTime = 0;
		
		byte[] buffer = new byte[4096];
		int byteRead = 0;
		
		imgDownloadStartTime = System.currentTimeMillis();
		System.out.println(imgDownloadStartTime);

		while ((byteRead = is.read(buffer))!= -1){
			fout.write(buffer,0,byteRead);
		}
		
		imgDownloadEndTime = System.currentTimeMillis();

		is.close();
		fout.close();
		System.out.println(imgDownloadEndTime);
	}
}