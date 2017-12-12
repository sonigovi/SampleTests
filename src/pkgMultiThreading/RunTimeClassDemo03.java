package pkgMultiThreading;

import org.omg.SendingContext.RunTime;

public class RunTimeClassDemo03 {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Runtime r = Runtime.getRuntime();
		System.out.println("Total Memory is "+r.totalMemory());
		System.out.println("Free Memory is "+r.freeMemory());
		
		for (int i=1;i<=10000;i++){
			new RunTimeClassDemo03();
		}
		
		System.out.println("Total Memory after 10000 instances is "+r.totalMemory());
		System.out.println("Free Memory after 10000 instances is "+r.freeMemory());
		
		System.gc();
		
		System.out.println("Total Memory after garbage collection is "+r.totalMemory());
		System.out.println("Free Memory after garbage collection is "+r.freeMemory());
		
	}
}
