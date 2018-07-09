package com.pkgAnnotations;

public class myAnnotationClass {
    @MyCustomAnnotation(studentName = "Aman Soni", StudentAddress = "Science City Road, Ahmedabad", studentStream = "Aeronautics")
    public static void main(String... aArgs) {
        System.out.println("Test");
        myAnnotationClass obj = new myAnnotationClass();
        obj.new a().showMyDataFromLastYearDatabase();
        obj.new b().showMyDataFromLastYearDatabase();
        obj.show();
        System.out.println(obj.toString());
    }

    @Deprecated
    void show() {
        int a = 10;
        System.out.println("In Deprecated Show Method: " + a);
    }

    class a {
        public void showMyDataFromLastYearDatabase() {
            System.out.println("In class a");
        }
    }

    class b extends a {
        @Override
        public void showMyDataFromLastYearDatabase() {
            System.out.println("In class b");
        }
    }
}
