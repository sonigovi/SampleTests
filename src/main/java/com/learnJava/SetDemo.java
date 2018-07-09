package com.learnJava;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String args[]) {
        int count[] = { 34, 22, 10, 60, 30, 22 };
        String strList[] = { "appu", "pappu", "tappu", "bittu", "kittu", "tittu" };
        Set<Integer> testIntSet = new HashSet<Integer>();
        Set<String> testStrSet = new HashSet<String>();
        try {
            for (int i = 0; i < 6; i++) {
                testIntSet.add(count[i]);
                testStrSet.add(strList[i]);
            }
            System.out.println(testIntSet);
            System.out.println(testStrSet);

            TreeSet sortedIntSet = new TreeSet<Integer>(testIntSet);
            TreeSet sortedStrSet = new TreeSet<String>(testStrSet);
            System.out.println("The sorted integer list is:");
            System.out.println(sortedIntSet);

            System.out.println("The First element of the integer set is: " +
                    sortedIntSet.first());
            System.out.println("The last element of the integer set is: " +
                    sortedIntSet.last());

            System.out.println("The sorted String list is:");
            System.out.println(sortedStrSet);

            System.out.println("The First element of the String set is: " +
                    (String) sortedStrSet.first());
            System.out.println("The last element of the String set is: " +
                    (String) sortedStrSet.last());
        } catch (Exception e) {
        }
    }
}