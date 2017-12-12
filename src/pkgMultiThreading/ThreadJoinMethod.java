package pkgMultiThreading;

public class ThreadJoinMethod extends Thread{
	public void run(){
		for (int i=1; i<=5; i++){
			try{
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println("Thread is running: "+i);
		}
	}
	public static void main(String[] args) {
		ThreadJoinMethod tjm1 = new ThreadJoinMethod();
		ThreadJoinMethod tjm2 = new ThreadJoinMethod();
		ThreadJoinMethod tjm3 = new ThreadJoinMethod();
		//join() method
/*		tjm1.start();
		
		try{
			tjm1.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		tjm2.start();
		tjm3.start();
*/
		//join((long miliseconds) method
		tjm1.start();
		
		try{
			tjm1.join(1500); //after 3rd iteration, it will give chance to tjm2 to run
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		tjm2.start();
		tjm3.start();
	}
}