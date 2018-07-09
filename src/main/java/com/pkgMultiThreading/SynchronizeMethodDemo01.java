package com.pkgMultiThreading;

class Table {
    synchronized public void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}

public class SynchronizeMethodDemo01 {
    public static void main(String[] args) {
        Table obj = new Table(); // Only one object

        MyThread1 mt1 = new MyThread1(obj);
        MyThread2 mt2 = new MyThread2(obj);

        mt1.start();
        mt2.start();
    }
}