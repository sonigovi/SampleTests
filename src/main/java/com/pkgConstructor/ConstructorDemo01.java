package com.pkgConstructor;

public class ConstructorDemo01 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A(5);

        /*
         * Whenever you create object of Sub Class, you also get object of Super Class.
         * Therefore it will print from Constructor of A as well as of B
         */

        B obj3 = new B();
        B obj4 = new B(7);
    }
}

class A {
    public A() {
        System.out.println("In A Constructor");
    }

    public A(int i) {
        System.out.println("In A Constant " + i);
    }
}

class B extends A {
    public B() {
        super(); // Even if you do not write it, it will be called. Comment it then also result will be same.
        System.out.println("In B Constructor");
    }

    public B(int i) {
        super(); // Even if you do not write it, it will be called. Comment it then also result will be same.
        System.out.println("In B Constant " + i);
    }
}