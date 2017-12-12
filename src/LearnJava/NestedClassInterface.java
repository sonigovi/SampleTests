package LearnJava;

import java.io.ObjectInput;

import LearnJava.NestedClassInterface.outer.inner;

public class NestedClassInterface {
	class outer{
		private int data = 30;
		void msg(){
			System.out.println("Message from Outer Class: "+data);
		}
		class inner{
			void msg(){
				System.out.println("Message from Inner Class: "+data);
			}
		}
	}
	public static void main(String[] args){
		NestedClassInterface objNested = new NestedClassInterface();
		NestedClassInterface.outer objOut = objNested.new outer();
		outer.inner objIn = objOut.new inner();

		objOut.msg();
		objIn.msg();
	}
}