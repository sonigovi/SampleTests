package com.pkgInterface;
//Default method in Interface

interface Drawable01 {
    void Draw();

    default void msg() {
        System.out.println("Message from Default Method");
    }
}

class Rectangle01 implements Drawable01 {
    @Override
    public void Draw() {
        System.out.println("Drawing Rectangle from Rectangle01 Class");
    }
}

public class InterfaceDemo04 {

    /*
     * Important: What is marker or tagged interface?
     * 
     * An Interface that have no member is known as marker or tagged interface.
     * 
     * For example: Serializable, Cloneable, Remote etc...
     * 
     * They are used to provide some essential information to the JVM
     * so that JVM may perform some useful operations.
     */
    public interface Serializable {
    }

    public static void main(String[] args) {
        Rectangle01 Rect01 = new Rectangle01();
        Rect01.msg();
        Rect01.Draw();

        Drawable01 objDrawable01 = new Drawable01() {
            @Override
            public void Draw() {
                System.out.println("Drawing from the main method using object of Drawable01 interface...");
            }
        };
        objDrawable01.Draw();
    }
}