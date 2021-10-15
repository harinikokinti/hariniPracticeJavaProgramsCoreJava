package com.harini.core.classExamples.innerClass;
/*
A class i.e. created inside a method is called local inner class in java.
If you want to invoke the methods of local inner class, you must instantiate this class inside the method.
Rules:
1.  Local variable can't be private, public or protected.
2.  Local inner class cannot be invoked from outside the method.
3.  Local inner class cannot access non-final local variable till JDK 1.7.
    Since JDK 1.8, it is possible to access the non-final local variable in local inner class.

 */

public class LocalInnerClassDemo {

    private int a = 20;
    private int b = 60;

    void add() {

        int c = 30;  //local variable must be final till jdk 1.7 only
        class LocalInnerClass {
            void calculate() {
                System.out.println("sum of a, b and c : " + (a + b + c));
            }

        }
        LocalInnerClass localInnerClassObject = new LocalInnerClass();
        localInnerClassObject.calculate();
    }


    public static void main(String args[]) {

        LocalInnerClassDemo localInnerClassDemoObject = new LocalInnerClassDemo();
        localInnerClassDemoObject.add();
    }
}
