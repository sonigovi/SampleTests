package pkgFileOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteTextFileJDK7Ex01 {
	final static String FILE_NAME = "C:\\temp\\input.txt";
	final static String OUTPUT_FILE_NAME = "C:\\temp\\output.txt";
	final static Charset ENCODING = StandardCharsets.UTF_8;

	  //For smaller files

	  /**
	   Note: the javadoc of Files.readAllLines says it's intended for small
	   files. But its implementation uses buffering, so it's likely good 
	   even for fairly large files.
	  */  
	
	List<String> readSmallTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		return Files.readAllLines(path, ENCODING);
	}
	
	void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aLines, ENCODING);
	}
	
	//For large files
	void readLargerTextFile (String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		try (Scanner aScanner = new Scanner (path, ENCODING.name())){
			while (aScanner.hasNextLine()){
				System.out.println(aScanner.nextLine());
			}
		}
	}
	
	void readLargetTextFileAlternate (String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedReader aReader = Files.newBufferedReader(path, ENCODING)){
			String line = null;
			while ((line = aReader.readLine()) != null)
				log(line);
		}
	}
	
	void writeLargerTextFile (String aFileName, List<String> aLines) throws IOException{
		Path path = Paths.get(aFileName);
		try (BufferedWriter aWriter = Files.newBufferedWriter(path, ENCODING)){
			for (String line : aLines){
				aWriter.append(line);
				aWriter.newLine();
			}
		}
	}
	
	public static void log(Object aMsg){
		System.out.println(String.valueOf(aMsg));
	}
	
	public static void main (String... aArgs) throws IOException{
		ReadWriteTextFileJDK7Ex01 text = new ReadWriteTextFileJDK7Ex01();
		
		//treat as small file
		List<String> lines = text.readSmallTextFile(FILE_NAME);
		log(lines);
		lines.add("This is the line added in code");
		text.writeSmallTextFile(lines, OUTPUT_FILE_NAME);
		
		//treat as a large file
		text.readLargetTextFileAlternate(FILE_NAME);
		lines = Arrays.asList("Down to the waterline", "Water of Love");
		text.writeLargerTextFile(OUTPUT_FILE_NAME,lines);
	}
}