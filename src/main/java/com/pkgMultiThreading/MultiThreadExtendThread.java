package com.pkgMultiThreading;

public class MultiThreadExtendThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MultiThreadExtendThread mtd = new MultiThreadExtendThread();
        mtd.start();
        // mtd.suspend();
    }
}
