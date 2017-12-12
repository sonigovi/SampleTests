package pkgNestedClassInterface;

public class StaticInnerClass {
	static int i = 10;
	static class InnerClass{
		static void display(){
			System.out.println(i);
		}
	}
	
	public static void main(String args[]){
		StaticInnerClass.InnerClass in = new StaticInnerClass.InnerClass();
		in.display();
		
		StaticInnerClass.InnerClass.display(); ;//no need to create the instance of static nested class  
	}
}
