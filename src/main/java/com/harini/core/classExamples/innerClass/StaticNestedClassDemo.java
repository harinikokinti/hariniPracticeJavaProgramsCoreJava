package com.harini.core.classExamples.innerClass;

/*
A static class created inside a class is called sttic nested class.
It can access only static members of the outer class inclding private.
Cannot access the non static members of the outer class

 */

public class StaticNestedClassDemo {

    private static int a = 20;
    private static int b = 50;

    void calculate() {
    }


    static class StaticNestedClass {
        int c = 80;

        void add() {
            System.out.println("1. sum of a and b : " + (a + b + c));  //  it cannot access non static members of the outer class
        }
    }

    static class StaticNestedClass2 {
      static  int d = 20;

        static void add2() {
            System.out.println("2. sum of a and b : " + (a + b + d));
        }
    }


    public static void main(String args[]){
            StaticNestedClassDemo.StaticNestedClass obj = new StaticNestedClassDemo.StaticNestedClass();
            obj.add();
            StaticNestedClassDemo.StaticNestedClass2.add2(); // no need to create the instance of static nested class StaticNestedClass2

    }
}



