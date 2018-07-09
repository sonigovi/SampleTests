package com.pkgMultiThreading;

public class GarbageCollectionDemo {
    @Override
    public void finalize() {
        System.out.println("Object is garbage collected... ");
    }

    public static void main(String[] args) {
        GarbageCollectionDemo gc1 = new GarbageCollectionDemo();
        GarbageCollectionDemo gc2 = new GarbageCollectionDemo();

        gc1 = null;
        gc2 = null;

        System.gc();
    }
}
