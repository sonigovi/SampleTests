package pkgMultiThreading;

public class DaemonMethods extends Thread{
	public void run(){
		for(int i=0; i<=5; i++){
			try{
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println("Thread name "+currentThread().getName()+" is "+currentThread().isDaemon()+" and iteration is "+i);
		}
	}
	public static void main(String[] args) {
		DaemonMethods dm1 = new DaemonMethods();
		DaemonMethods dm2 = new DaemonMethods();
		DaemonMethods dm3 = new DaemonMethods();
		
		dm1.setDaemon(true);
		dm1.start();
		dm2.start();
		dm3.start();
	}
}