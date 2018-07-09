package com.pkgTryCatchFinally;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            int data = 50 / 0;
            System.out.println(data);

            int a[] = new int[5];
            a[10] = 50;
            System.out.println(a);

            String s = "abc";
            int a1 = Integer.parseInt(s);
            System.out.println(a1);

            String s1 = null;
            System.out.println(s1.length());

        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            int data = 0;
            System.out.println(data);

            int a[] = { 1, 2, 3, 4, 5 }; // new int[5];
            System.out.println(a[0] + a[1]);

            String s = "1234567890";
            int a1 = Integer.parseInt(s);
            System.out.println(a1);

            String s1 = "abcdefghijklmnopqrstuvwxyz";
            System.out.println(s1.length());
        }
    }
}
