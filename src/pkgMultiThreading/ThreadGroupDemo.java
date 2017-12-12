package pkgMultiThreading;

public class ThreadGroupDemo implements Runnable{
	public void run(){
		for (int i=1; i<=5; i++){
			try{
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		ThreadGroupDemo tgd = new ThreadGroupDemo();
		
		ThreadGroup tgParent = new ThreadGroup("ParentThreadGroup");
		
		Thread t1 = new Thread(tgParent, tgd, "Thread - One");
		Thread t2 = new Thread(tgParent, tgd, "Thread - Two");
		Thread t3 = new Thread(tgParent, tgd, "Thread - Three");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Thread Group Name is "+t1.getThreadGroup().getName());
		
		tgParent.list();
	}
}
