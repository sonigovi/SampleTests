package pkgNestedClassInterface;

interface Eatable{
	void eat();
}

public class AnonymousInnerInterface {
	public static void main(String args[]){
		Eatable e = new Eatable(){
			public void eat(){
				System.out.println("Interface function eat executed");
			}
		};
		e.eat();
	}
}
