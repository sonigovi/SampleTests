package pkgInterface;

interface Drawable{
	public void draw();
}

class Rectangle implements Drawable{
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
}

class Circle implements Drawable{
	public void draw(){
		System.out.println("Drawing Circle");
	}
}

public class InterfaceDemo01 {
	public static void main(String[] args) {
		Drawable DrawableRect = new Rectangle();
		DrawableRect.draw();
		
		Drawable DrawableCirc = new Circle();
		DrawableCirc.draw();
		
		Rectangle Rect = new Rectangle();
		Rect.draw();
		
		Circle Circ = new Circle();
		Circ.draw();
	}
}
