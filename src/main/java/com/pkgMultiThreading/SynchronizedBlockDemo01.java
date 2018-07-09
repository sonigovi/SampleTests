package com.pkgMultiThreading;

class Table2 {
    void printTable2(int n) {
        synchronized (this) { // Synchronized block
            for (int i = 1; i <= 5; i++) {
                System.out.println(i * n);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    // e.printStackTrace();
                }
            }
        } // Synchronized block closed
    }
}

class MyThread3 extends Thread {
    Table2 t;

    MyThread3(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable2(5);
    }
}

class MyThread4 extends Thread {
    Table2 t;

    MyThread4(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable2(100);
    }
}

public class SynchronizedBlockDemo01 {
    public static void main(String[] args) {
        Table2 obj = new Table2();
        MyThread3 mt3 = new MyThread3(obj);
        MyThread4 mt4 = new MyThread4(obj);

        mt3.start();
        mt4.start();
    }
}
