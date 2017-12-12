package pkgNestedClassInterface;

public class LocalInnerClass {
	void func1(){
		class local{
			void display(){
				System.out.println("Local class display function");
			}
		}
		local l = new local();
		l.display();
	}
	public static void main(String[] args) {
		LocalInnerClass obj = new LocalInnerClass();
		obj.func1();
	}
}
