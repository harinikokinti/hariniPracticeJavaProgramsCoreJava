package com.harini.core.abstraction;
/*
Nested Interface
An interface i.e. declared within another interface or class is known as nested interface.
Points to remember:
1. Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
2. Nested interfaces are declared static implicitely.

-- Question
Can we define a class inside the interface?
Yes, If we define a class inside the interface, java compiler creates a static nested class.

 */

// Example of nested interface which is declared within the interface
interface Show {
    void run();
    interface Message {
        void msg();
    }
}

class GetDataFromNestedInterface implements Show.Message {
 public   void msg() {System.out.println("Nested Inerface within an Interface Data");}
}
public class NestedInterfaceExample {
    public static void main(String args[]) {
        Show.Message messge = new GetDataFromNestedInterface(); // upcasting
        messge.msg();
    }
}

// we are acessing the Message interface by its outer interface Showable because it cannot be accessed directly.
// It is just like almirah inside the room, we cannot access the almirah directly because we must enter the room first.
// In collection framework, sun microsystem has provided a nested interface Entry. Entry is the subinterface of Map i.e. accessed


// Example of nested interface which is declared within the class
class Show2 {
    interface Message {
        void msg();
    }
}

class GetDataFromNestedInterface2 implements Show.Message {
    public   void msg() {System.out.println("Nested Inerface within an Class Data");}
}
 class NestedInterfaceExample2 {
    public static void main(String args[]) {
        Show.Message messge = new GetDataFromNestedInterface2(); // upcasting
        messge.msg();
    }
}


