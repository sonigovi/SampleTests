package pkgNestedClassInterface;

abstract class Person{
	abstract void eat();
}

public class AnonymousinnerClass {
	public static void main(String[] args){
		Person p = new Person(){
			void eat(){
				System.out.println("Anonymous Inner Class for Person P");
			}
		};
		Person q = new Person(){
			void eat(){
				System.out.println("Anonymous Inner Class for Person Q");
			}
		};
		p.eat();
		q.eat();
	}
}
