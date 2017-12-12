package pkgAnnotations;

import java.util.ArrayList;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
	String os() default "Symbian";
	int version() default 1;
}

@SmartPhone(os="Android", version=6)
class NokiaASeries{
	String model;
	int size;

	public NokiaASeries(String model, int size) {
	//	super();
		this.model = model;
		this.size = size;
	}
}

/*class NASeries extends NokiaASeries{
	String model;
	int size;
	public NASeries(String model, int size){
		//super();
		this.model = model;
		this.size = size;
	}
}*/

public class AnnotationDemo {
	public static void main (String[] args){
		NokiaASeries obj = new NokiaASeries("Fire", 5);
		System.out.println("Model is: "+obj.model);
		System.out.println("Size is: "+obj.size);
		
		Annotation an1 = obj.getClass().getAnnotation(SmartPhone.class);
		SmartPhone s1 = (SmartPhone)an1;
		System.out.println("OS is : "+s1.os()+" and Version is : "+s1.version());
		
		//@SuppressWarnings("unchecked")
		Class c = obj.getClass(); //Use reflection API to fetch the values of SmartPhone annotation 
		Annotation an2 = c.getAnnotation(SmartPhone.class);
		SmartPhone s2 = (SmartPhone)an2;
		System.out.println("OS is : "+s2.os()+" and Version is : "+s2.version());
	}
}