package pkgMultiThreading;

class Table1{
	synchronized public void printTable1(int n){
		for (int i=1; i<=5; i++){
			try{
				System.out.println(n*i);
				Thread.sleep(400);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}

public class SynchronizeMethodDemo02 {
	public static void main(String[] args) {
		final Table obj = new Table();
		
		Thread t1 = new Thread(){
			public void run(){
				obj.printTable(5);
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				obj.printTable(100);
			}
		};

		t1.start();
		t2.start();
	}
}
