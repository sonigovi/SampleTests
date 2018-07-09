package com.pkgNestedClassInterface;

//import pkgNestedClassInterface.*;

public class MemberInnerClass {
    class outer {
        private int data = 30;

        void msg() {
            System.out.println("Message from Outer Class: " + data);
        }

        class inner {
            void msg() {
                System.out.println("Message from Inner Class: " + data);
            }
        }
    }

    public static void main(String[] args) {
        MemberInnerClass objNested = new MemberInnerClass();
        MemberInnerClass.outer objOut = objNested.new outer();
        outer.inner objIn = objOut.new inner();

        objOut.msg();
        objIn.msg();
    }
}
