package com.pkgMultiThreading;

public class ThreadPriority extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Thread Name is : " + currentThread().getName() + " and iteration is : " + i);
        }
    }

    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();

        tp2.setPriority(MAX_PRIORITY);
        tp1.setPriority(MIN_PRIORITY);

        tp1.setName("tp-1");
        tp2.setName("tp-2");

        tp1.start();
        tp2.start();
    }
}
