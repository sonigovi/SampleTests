package pkgMultiThreading;

import java.util.concurrent.ExecutorService; //Interface
import java.util.concurrent.Executors; //Class

public class ThreadPoolWorkerThread implements Runnable{
	private String message;

	//Constructor
	public ThreadPoolWorkerThread(String message) {
		//super();
		this.message = message;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" (start) message = "+message);
		processMessage();
		System.out.println(Thread.currentThread().getName()+" (end)");
	}
	
	private void processMessage(){
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5); //creating a pool of 5 threads
		for (int i=1; i<=25; i++){
			Runnable worker = new ThreadPoolWorkerThread(""+i);
			executor.execute(worker); // calling execute method of ExecutorService interface			
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			System.out.println("Shutdown in progress... "+executor.getClass());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All threads terminated");
	}
}