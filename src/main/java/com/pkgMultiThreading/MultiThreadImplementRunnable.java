package com.pkgMultiThreading;

public class MultiThreadImplementRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running... ");
    }

    public static void main(String[] args) {
        /*
         * MultiThreadImplementRunnable mtr = new MultiThreadImplementRunnable();
         * Thread t1 = new Thread(mtr);
         * t1.start();
         */

        Runnable r = new MultiThreadImplementRunnable();
        (new Thread(r)).start();

        MultiThreadImplementRunnable mtir = new MultiThreadImplementRunnable();
        (new Thread(mtir)).start();
    }
}
