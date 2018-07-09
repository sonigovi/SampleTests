package com.learnJava;

public class ExtendAbstractClass extends AbstractClassExample {
    @Override
    public void goFast() {
        // an abstract method
        System.out.println("goFast abstract method extended from abstract class");
    }

    @Override
    public void changeColor() {
        System.out.println("changeColor abstract method extended from abstract class");
    }

    public static void main(String[] args) {
        ExtendAbstractClass ExtAbsCls = new ExtendAbstractClass();

        ExtAbsCls.goFast();
        ExtAbsCls.changeColor();

        System.out.println("Starting with " + InstanceCounter.getCount() + " instances");

        for (int i = 0; i < 500; ++i) {
            // new InstanceCounter();
            InstanceCounter InstCnt = new InstanceCounter();
            System.out.println("Created " + InstCnt.getCount() + " instances");
        }
        System.out.println("Created " + InstanceCounter.getCount() + " instances");
    }
}
