package pkgFileOperations;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadWithScanner {

	private final Path fFilePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	private static void log(Object aObject){
		System.out.println(String.valueOf(aObject));
	}
	
	private String quote(String aText){
		String Quote = "'";
		return Quote + aText + Quote;
	}
	
	/**
	  Constructor.
	  @param aFileName full name of an existing, readable file.
	*/
	
	public ReadWithScanner(String aFileName){
		fFilePath = Paths.get(aFileName);
	}
	
	  /** 
	   Overridable method for processing lines in different ways.
	    
	   <P>This simple default implementation expects simple name-value pairs, separated by an 
	   '=' sign. Examples of valid input: 
	   <tt>height = 167cm</tt>
	   <tt>mass =  65kg</tt>
	   <tt>disposition =  "grumpy"</tt>
	   <tt>this is the name = this is the value</tt>
	  */
	
	protected void processLine(String aLine){
	    //use a second Scanner to parse the content of each line 
		Scanner aScanner = new Scanner(aLine);
		aScanner.useDelimiter("=");
		if (aScanner.hasNext()){
		    //assumes the line has a certain structure
			String name = aScanner.next();
			String value = aScanner.next();
			log("Name is : " + quote(name.trim()) + ", and value is : " + quote(value.trim()));
		}
		else{
			log("Empty or invalid line. Unable to process");
		}
	}
		
	/** Template method that calls {@link #processLine(String)}.  */
	public void processLineByLine() throws IOException{
		try (Scanner aScanner = new Scanner(fFilePath, ENCODING.name())){
			while (aScanner.hasNextLine()){
				processLine(aScanner.nextLine());
			}
		}
	}
	
	public static void main (String... aArgs) throws IOException{
		ReadWithScanner parser = new ReadWithScanner ("C:\\temp\\input1.txt");
		parser.processLineByLine();
		log("Done");
	}
}
