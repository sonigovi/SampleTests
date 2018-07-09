package com.pkgMultiThreading;

public class SleepMethodDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(250 * i);
                /*
                 * if (i==3){
                 * currentThread().sleep(750);
                 * }
                 */
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Thread is running... " + i);
        }
    }

    public static void main(String[] args) {
        SleepMethodDemo01 sm1 = new SleepMethodDemo01();
        SleepMethodDemo01 sm2 = new SleepMethodDemo01();
        sm1.start();
        sm2.start();
    }
}
