package com.pkgInterface;

interface Printable1 {
    void print();
}

interface Showable1 extends Printable1 {
    void show();
}

class A8 implements Showable1 {
    @Override
    public void print() {
        System.out.println("Printing ... ");
    }

    @Override
    public void show() {
        System.out.println("Showing ... ");
    }
}

public class InterfaceDemo03 {
    public static void main(String[] args) {
        Showable1 objShowable = new A8();
        objShowable.print();
        objShowable.show();

        A8 objA8 = new A8();
        objA8.print();
        objA8.show();
    }
}
