package com.pkgMultiThreading;

import java.io.IOException;

public class RunTimeClassDemo01 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
