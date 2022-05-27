package com.harini.core.polymorphism;

import java.io.IOException;

/*
--If subclass (child class) has the same method as declared in the parent class, it is known as method overriding in Java.
-- Usage
1.Method overriding is used to provide the specific implementation of a method which is already provided by its superclass.
2. Method overriding is used for runtime polymorphism

--Rules for Java Method Overriding
The method must have the same name as in the parent class
The method must have the same parameters or arguments as in the parent class.
The return types must be compatible: Whatever the super class declares as a return type, the subclass should declare either the same type or the sub class type
There must be an IS-A relationship (inheritance).
The method cannot be less accessible. Example: if the super class method is public, you should not make it private while overriding it in subclass

QUESTIONS:
Can we override static method?
No, a static method cannot be overridden. It can be proved by runtime polymorphism, so we will learn it later.

Why can we not override static method?
class memory - static methods,
heap memory - instance methods
It is because the static method is bound with class whereas instance method is bound with an object.
Static belongs to the class area, and an instance belongs to the heap area.

Can we override java main method?
No, because the main is a static method.

-- Difference between Method Overloading and Method Overriding
Method Overloading	                                                                Method Overriding
1)	Method overloading is used to increase the readability of the program.	        Method overriding is used to provide the specific implementation of the method that is already provided by its super class.
2)	Method overloading is performed within class.	                                Method overriding occurs in two classes that have IS-A (inheritance) relationship.
3)	In case of method overloading, parameter must be different.	                    In case of method overriding, parameter must be same.
4)	Method overloading is the example of compile time polymorphism.	                Method overriding is the example of run time polymorphism.
5)	In java, method overloading can't be performed by just changing return type     Return type must be same or covariant in method overriding.
of the method only. Return type can be same or different in method overloading.
 But you must have to change the parameter.

-- -- Exceptional Handling with Method Overriding:
Rules :
1. If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
2. If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.

 */
// Method Overriding Example
class Bank
{
    int rateOfInterest;
    void  getRateOfInterest(){
        System.out.println("Rate of Interest");
    }
}

class ICICIBank extends Bank {
    void getRateOfInterest() {
        System.out.println("Rate of Interest of ICICI: " + 15);
    }
}

class HDFCBank extends Bank {
    void getRateOfInterest() {
        System.out.println("Rate of Interest of HDFC Bank: " + 14);
    }
}


public class MethodOverridngExample {
    public static void main(String args[])
    {
        ICICIBank iciciBank = new ICICIBank();
        iciciBank.getRateOfInterest();
        HDFCBank hdfcBank = new HDFCBank();
        hdfcBank.getRateOfInterest();
    }
}

// Exception Handling with MethodOverriding
/*
RULES
1. If the superclass method does not declare an exception
        If the superclass method does not declare an exception, subclass overridden method cannot declare the Checked exception
        but it can declare Unchecked exception.
2. If the superclass method declares an exception
        If the superclass method declares an exception, subclass overridden method can declare same,
        subclass exception or no exception but cannot declare parent exception
 */

class Parent{
    void msg() throws Exception
    {
        System.out.println("parent");
    }
}

class TestExceptionChild extends Parent{
    void msg() throws IOException {
        System.out.println("TestExceptionChild");
    }
    public static void main(String args[]){
        Parent p=new TestExceptionChild();
        try{
            p.msg();
        }
        catch(Exception e) {}

    }
}

// Here if parent class has not declared exception, it throws compile time error. 


// Java Access Modifiers with Method Overriding --  gives compile time error
/*
class A
{
    protected void msg(){System.out.println("Hello java");}
}
class B extends A {
    void msg(){System.out.println("Hello java");} //  compile time error since the default access specifier is more restrictive then protected
    public static void main(String args[]){
        B obj=new B();
        obj.msg();
    }
}
} */