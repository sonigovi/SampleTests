package com.pkgMultiThreading;

/*A thread cannot be started twice. It will lead to IllegalThreadStateException exception.
Thread will run first time, but for second time it will throw the exception.
*/

public class RunThreadTwice extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(750);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Thread is running... " + i);
        }
    }

    public static void main(String[] args) {
        try {
            RunThreadTwice rtt = new RunThreadTwice();

            rtt.start();
            rtt.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
