package com.pkgMultiThreading;

class Table04 {
    synchronized static void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i * n);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread70 extends Thread {
    @Override
    public void run() {
        Table04.printTable(1);
    }
}

class MyThread71 extends Thread {
    @Override
    public void run() {
        Table04.printTable(10);
    }
}

class MyThread72 extends Thread {
    @Override
    public void run() {
        Table04.printTable(100);
    }
}

class MyThread73 extends Thread {
    @Override
    public void run() {
        Table04.printTable(1000);
    }
}

public class StaticSynchronizationDemo01 {
    public static void main(String[] args) {
        MyThread70 mt70 = new MyThread70();
        MyThread71 mt71 = new MyThread71();
        MyThread72 mt72 = new MyThread72();
        MyThread73 mt73 = new MyThread73();

        mt70.start();
        mt71.start();
        mt72.start();
        mt73.start();
    }
}
