package pkgMultiThreading;

import java.io.IOException;

// This program will restart your system. Be cautious before running this program.

public class RunTiimeClassDemo02 {
	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("shutdown -r -t 0");
		} catch (IOException e) {
			System.out.println(e);
			//e.printStackTrace();
		}
	}
}
