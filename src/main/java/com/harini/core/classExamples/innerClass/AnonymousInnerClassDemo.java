package com.harini.core.classExamples.innerClass;
/*
A class that have no name is known as anonymous inner class in java.
It should be used if you have to override method of class or interface.
Advantage: Instead of creating a separate child class to override the super class methods, we use anonymous inner class with no class name to override

Java Anonymous inner class can be created by two ways:
1. Class (may be abstract or concrete).
2. Interface
 */


// Java anonymous inner class example using class
abstract class ParentClass {
    int a = 20;
    int b = 40;
  abstract  void add();
}

public class AnonymousInnerClassDemo {

    public static void main(String args[]) {

        ParentClass add = new ParentClass() {      //this is An Anonymous inner class to override the super class method
            void add() {
                System.out.println("Sum of a and b are:" + (a + b));    }
        };
        add.add();
    }

}


//Java anonymous inner class example using interface

interface ParentClass2 {
    int a = 20;
    int b = 50;
    void add();
}

class AnonymousInnerClassDemo2
{
    public static void main(String args[]) {
        ParentClass2  add = new ParentClass2() {  // this is an anonymous class overriding the method add() from the interface ParentClass2
            @Override
            public void add() { System.out.println("Sum of a and b are:" + (a + b));    }
          };
        add.add();

    }
}

