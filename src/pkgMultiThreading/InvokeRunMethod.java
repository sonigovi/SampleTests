package pkgMultiThreading;

public class InvokeRunMethod extends Thread{
	public void run(){
		for (int i=1; i<=5; i++){
			try{
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println("Thread is running on callstack: "+currentThread().getName()+"; Thread number: "+i);
			//System.out.println(currentThread().getClass());
		}
	}
	public static void main(String[] args) {
		InvokeRunMethod irm1 = new InvokeRunMethod();
		InvokeRunMethod irm2 = new InvokeRunMethod();
		InvokeRunMethod irm3 = new InvokeRunMethod();
		
		irm1.start();
		irm2.run();
		irm3.run();
	}
}
