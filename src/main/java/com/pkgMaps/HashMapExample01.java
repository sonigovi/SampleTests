package com.pkgMaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample01 {
    public static void main(String args[]) {
        HashMap<Integer, String[]> hm = new HashMap<Integer, String[]>();
        String[] strArr1 = { "Amit", "Gautam" };
        String[] strArr2 = { "Suman", "Ammineni" };
        String[] strArr3 = { "Sreekanth", "Ajith" };
        hm.put(100, strArr1);
        hm.put(101, strArr2);
        hm.put(102, strArr3);
        for (Map.Entry<Integer, String[]> m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue()[1] + ", " + m.getValue()[0]);
        }
        hm.remove(101);
        for (Map.Entry<Integer, String[]> m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue()[1] + ", " + m.getValue()[0]);
        }
        hm.clear();
        System.out.println(hm.size());
        for (Map.Entry<Integer, String[]> m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue()[1] + ", " + m.getValue()[0]);
        }
    }
}