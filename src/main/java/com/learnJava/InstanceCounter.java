package com.learnJava;

public class InstanceCounter {

    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " + InstanceCounter.getCount() + " instances");

        for (int i = 0; i < 500; ++i) {
            // new InstanceCounter();
            InstanceCounter InstCnt = new InstanceCounter();
            System.out.println("Created " + InstCnt.getCount() + " instances");
        }
        System.out.println("Created " + InstanceCounter.getCount() + " instances");
    }
}