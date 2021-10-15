package com.harini.core.polymorphism;
/*
Instance Initializer block is used to initialize the instance data member. It run each time when object of the class is created.

Rules for instance initializer block :
There are mainly three rules for the instance initializer block. They are as follows:
The instance initializer block is created when instance of the class is created.
The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
The instance initializer block comes in the order in which they appear.

Usage:
To perform some common operations while assigning value to instance data member e.g. a for loop to fill a complex array or error handling etc.
Inside instance block we can perform some extra operations while initializing the instance variable.
Of cause we can do initialization inside constructor also, but when we have multiple constructors (overloaded constructors) in our class,
and we have certain common operations or initialization in each constructor then we can write those common operations in instance block.
 */

// Example of Instance initializer block
class Sample
{

    Sample()
    {
        System.out.println("Parent class Constructor");
    }
    {System.out.println("Instance Initializer Block");}  //  Instance initializer block
}

public class InstanceInitializerBlock {
    public static void main(String args[]) {
        Sample parentClass = new Sample();
    }
}  // In the above example, it seems that instance initializer block is firstly invoked but NO. Instance intializer block is invoked at the time of object creation.
// The java compiler copies the instance initializer block in the constructor after the first statement super(). So firstly, constructor is invoked. L


// Program of instance initializer block that is invoked after super()
class ParentClass
{

    ParentClass()
    {
        System.out.println("Parent class Constructor");
    }

}

class ChildClass extends ParentClass
{
    ChildClass()
    {
        super();
        System.out.println("Child class Constructor");
    }
    {System.out.println("Instance Initializer Block");}  //  Instance initializer block
}

 class InstanceInitializerBlock2 {
    public static void main(String args[]) {
        ChildClass childClass = new ChildClass();
    }
}

// Another example of instance block

class ParentClass2
{

    ParentClass2()
    {
        System.out.println("Parent class Constructor");
    }

}

class ChildClass2 extends ParentClass2
{
    ChildClass2()
    {
        super();
        System.out.println("Child class Constructor");
    }
    ChildClass2(String s)
    {
        // super() is called implicitly even if we specify it or not
        System.out.println("Child class Constructor with String value : " +s);
    }
    {System.out.println("Instance Initializer Block");}  //  Instance initializer block
}

class InstanceInitializerBlock3 {
    public static void main(String args[]) {
        ChildClass2 childClass2 = new ChildClass2();
        ChildClass2 childClass3 = new ChildClass2("welcome");
    }
}

