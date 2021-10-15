package com.harini.core.exceptionalHandling;
/*
-- Exceptional Handling with Method Overriding:
Rules :
1. If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
2. If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
 */



import java.io.IOException;

// If the superclass method does not declare an exception,
class Parent {
    void message() {
        System.out.println("Parent class method body");
    }
}

class Child extends Parent {
    void message() throws ArithmeticException {  // CT error if we declare checked exception
        System.out.println("Child class method body");

    }
}
public class ExceptionalHandlingWithMethodOverriding {
    public static void main(String args[]) {
        Child c = new Child();
        c.message();
    }

}

// If the superclass method declares an exception,
class Parent1 {
    void message() throws IOException {
        System.out.println("Parent class method body");
    }
}

class Child1 extends Parent1 {
    void message() throws IOException {  // CT error if we declare parent Exception
        System.out.println("Child class method body");

    }
}
class ExceptionalHandlingWithMethodOverriding2 {
    public static void main(String args[]) {
        Child1 c = new Child1();
        try {
            c.message();
        }catch(Exception e) { System.out.println(e); }
    }

}
