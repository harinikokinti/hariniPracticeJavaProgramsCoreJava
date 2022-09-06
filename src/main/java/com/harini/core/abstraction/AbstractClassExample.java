package com.harini.core.abstraction;
/*
 Abstraction is a process of hiding the implementation details and showing only functionality to the user.
 Mostly, we don't know about the implementation class (which is hidden to the end user), and
 an object of the implementation class is provided by the factory method.

--Ways to achieve Abstraction
There are two ways to achieve abstraction in java
1.Abstract class (0 to 100%)
2. Interface (100% )
Abstract class:
        An abstract class must be declared with an abstract keyword.
        It can have abstract and non-abstract methods.
        It cannot be instantiated.
        It can have constructors and static methods also and even main() method.
        It can have final methods which will force the subclass not to change the body of the method.

Rules:
-- If there is an abstract method in a class, that class must be abstract.
-- If you are extending an abstract class that has an abstract method, you must either provide the implementation of the method or make this class abstract.

Note:
--Difference between Abstract Class  and Java 8 Interface
 After having default and static methods inside the interface, we think about the need of abstract class in Java.
 An interface and an abstract class is almost similar except that you can create constructor in the abstract class
 whereas you can't do this in interface.
 */

import java.util.ArrayList;
import java.util.List;

// Understanding the real scenario of Abstract class
abstract class Shape {
    abstract void draw();
}
//In real scenario, implementation is provided by others i.e. unknown by end user
//The implementation part is hidden by the user who uses the interface or the abstract class

class Rectangle extends Shape{
    void draw(){System.out.println("drawing rectangle");}

}
class Circle extends Shape {
    void draw(){System.out.println("drawing circle");}
}

//In real scenario, method is called by programmer or user
public class AbstractClassExample{
    public static void main(String args[]){
        Shape s=new Circle();//In a real scenario, object is provided through method, e.g., getShape() method
        s.draw();
    }
}


// Abstract class having constructor, data member and methods
//Example of an abstract class that has abstract and non-abstract methods
abstract class Bike{
   Bike(){System.out.println("bike is created");}
    abstract void run();
    void changeGear(){System.out.println("gear changed");}
}
//Creating a Child class which inherits Abstract class
class Honda extends Bike{
    void run(){System.out.println("running safely..");}
}
//Creating a Test class which calls abstract and non-abstract methods
class TestAbstraction2{
    public static void main(String args[]){
        Bike obj = new Honda();
      obj.run();
      obj.changeGear();
    }
}

// Another real scenario of abstract class
//The abstract class can also be used to provide some implementation of the interface.
// In such case, the end user may not be forced to override all the methods of the interface.

interface A {
    void a();
    void b();
    void c();
    void d();
        }

        abstract  class B implements A {
    public void c() { System.out.println("I am c");}
        }
class M extends B {
   public void a() { System.out.println("I am a");}
    public void b(){System.out.println("I am b");}
    public void d(){System.out.println("I am d");}
}
class TestAbstract {
    public static void main(String args[]) {
        A a = new M();
        a.a();
        a.b();
        a.c();
        a.d();

    }

}


// why to use abstract class
// example which defines a common funcitonality area()  method across all the sub classes

abstract class Shape1{
    public double width;
    public double height;
    public double radius;
    public final float pie = 3.14f;

    public abstract void getArea();
}

class Rectangle2 extends Shape1{
    public Rectangle2(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void draw(){
        System.out.println("rectangle drawing...");
    }

    @Override
    public void getArea() {
        System.out.println("Area: "+ (width * height));
    }
}

class Circle2 extends Shape1{
    public Circle2(double radius){
        this.radius = radius;
    }
    public void drawing(){
        System.out.println("circle drawing...");
    }

    @Override
    public void getArea() {
        System.out.println("Area: "+ (this.pie * radius * radius));
    }
}

 class Demo24 {
    public static void main(String[] args) {
        Rectangle2 rectangle = new Rectangle2(12.34, 56.78);
        Circle2 circle = new Circle2(55.55);

        rectangle.draw();
        circle.drawing();

        rectangle.getArea();
        circle.getArea();
    }
}

// Example 2   Why abstract class

abstract class Car {
    public void accelerate() {
        System.out.println("Do something to accelerate");
    }
    public void applyBrakes() {
        System.out.println("Do something to apply brakes");
    }
    public abstract void changeGears();
}
// Now, any Car that wants to be instantiated must implement the changeGears () method.

class Alto extends Car {
    public void changeGears() {
        System.out.println("Implement changeGears() method for Alto Car");
    }
}
class Santro extends Car {
    public void changeGears() {
        System.out.println("Implement changeGears() method for Santro Car");
    }
}