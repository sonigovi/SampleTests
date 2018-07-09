package com.pkgMultiThreading;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("shut down hook task completed... ");
    }
}

public class TestShutDown01 {
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime(); // The object of Runtime class can be obtained by calling the static factory method getRuntime().
        MyThread objMyThread = new MyThread();

        r.addShutdownHook(objMyThread);

        System.out.println("now main sleeping... press ctrl+c to exit... ");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
