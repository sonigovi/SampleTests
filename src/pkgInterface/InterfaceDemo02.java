package pkgInterface;

interface Showable{
	void show();
}

interface Printable{
	void print();
}

class A7 implements Printable, Showable{
	public void show(){
		System.out.println("Showing... ");		
	}
	public void print(){
		System.out.println("Printing... ");
	}
}

public class InterfaceDemo02 extends A7{
	public static void main(String[] args) {
		A7 objA7 = new A7();
		objA7.print();
		objA7.show();
		
		Printable objPrint = new A7();
		objPrint.print();
		
		Showable objShow = new A7();
		objShow.show();
		
		InterfaceDemo02 objInterfaceDemo02 = new InterfaceDemo02();
		objInterfaceDemo02.print();
		objInterfaceDemo02.show();
	}
}