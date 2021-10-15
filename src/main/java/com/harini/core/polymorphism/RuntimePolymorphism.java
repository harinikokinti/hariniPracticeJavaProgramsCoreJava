package com.harini.core.polymorphism;
/*
--POLYMORPHISM - Many forms
Tp perform a single action in different ways.
There are two types of polymorphism in Java: compile-time polymorphism and runtime polymorphism.
We can perform polymorphism in java by method overloading and method overriding.

--  compile time polymorphism.:
If you overload a static method in Java, it is the example of compile time polymorphism.

--Runtime Polymorphism
Runtime polymorphism or Dynamic Method Dispatch is a process in which a call to an overridden method is resolved or decided at runtime rather than at compile-time.
In this process, an overridden method is called through the reference variable of a superclass.
The determination of the method to be called during runtime is based on the object being referred to by the reference variable.

--Upcasting
If the reference variable of Parent class refers to the object of Child class, it is known as upcasting.
For upcasting, we can use the reference variable of class type or an interface type
class A{}
class B extends A{}
A a=new B();//upcasting
 */


// Runtime Polymorphism by Overriden method and by Data members
class Shape {
    String shapeName = "Abstract";
     void draw() {
        System.out.println("Drawing");
    }
}
class Rectange extends Shape
{
    String shapeName = "Rectangle";
    void draw() {
        System.out.println("Drawing Rectangle");}

}

    class Square extends Shape
    {
        String shapeName = "Square";
        void draw() {
            System.out.println("Drawing Square");}

    }
    class Circle extends Shape
    {
        String shapeName = "Circle";
        void draw() {
            System.out.println("Drawing Circle");}
    }

public class RuntimePolymorphism {
        public static void main(String args[]) {
            Shape s;
            s = new Rectange();
            s.draw();
            System.out.println("The Shape name is: " + s.shapeName); // runtime polymorphism can't be achieved by  data members
            s = new Square(); //  runtime polymorphism is achieved by the overriden methods
            System.out.println("The Shape name is: " + s.shapeName);
            s.draw();
            s = new Circle();
            System.out.println("The Shape name is: " + s.shapeName);
           s.draw();
        }
}

