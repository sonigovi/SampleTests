package com.pkgMultiThreading;

public class SetGetNameID extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Current Thread is : " + currentThread().getName() + " and iteration is : " + i);
        }
    }

    public static void main(String[] args) {
        SetGetNameID sgni1 = new SetGetNameID();
        SetGetNameID sgni2 = new SetGetNameID();
        SetGetNameID sgni3 = new SetGetNameID();

        sgni1.setName("sgni-1");
        sgni2.setName("sgni-2");

        sgni1.start();
        try {
            sgni1.join(1500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sgni2.start();
        try {
            sgni2.join(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        sgni3.start();
    }
}
