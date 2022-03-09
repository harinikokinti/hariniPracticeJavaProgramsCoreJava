package com.harini.core.abstraction;
/*
An interface in Java is a blueprint of a class.
Interface fields(variables) are public, static and final by default, and the methods are public and abstract.

Since Java 8, we can have default and static methods in an interface.
Since Java 9, we can have private methods in an interface.

A class that implements an interface must implement all the methods declared in the interface.
Java Interface also represents the IS-A relationship.
It cannot be instantiated just like the abstract class.
--Use of Interface:
1. to achieve abstracton
2. to implement Multiple inheritance
3. to achieve loose coupling

-- Relationship between classes and interfaces
A class extends another class,
A class implements an interface
An Interface extends another interface

-- Multiple inheritance in Java by interface is achieved as follows
A class implements 2 interfaces
an interface extends 2 interfaces

the ambiguity issue is resolved if we use intefaces to implement Multiple inheritance. Since the implementation is provided by the implementation class.

Note: since the methods in interface are public by default,
the overriding methods must be public in order to avoid the access privilege issue.

-- QUESTIONS:
What is marker or tagged interface?
An interface which has no member is known as a marker or tagged interface, for example, Serializable, Cloneable, Remote, etc.
They are used to provide some essential information to the JVM so that JVM may perform some useful operation.
Example : Getting permission on a class obj which implements this marker interface and execute a functionality.

//How Serializable interface is written?
public interface Serializable{
}



 */
// Interface Example
interface PrintThis {
    void print();
}
class PrintThisImpl implements PrintThis {
   public void print() { System.out.println("Hi Print this message");} //  since the methods in interface are public by default,
                                                                     //    the overriding methods must be public in order to avoid the access privilege issue
}
public class InterfaceExample {
    public static void main(String args[]) {

        PrintThis printThis = new PrintThisImpl();
       // PrintThisImpl printThis = new PrintThisImpl();
        printThis.print();
    }
}

// Real time Interface Example
//n this example, the Drawable interface has only one method. Its implementation is provided by Rectangle and Circle classes.
// In a real scenario, an interface is defined by someone else, but its implementation is provided by different implementation providers.
// Moreover, it is used by someone else. The implementation part is hidden by the user who uses the interface.

interface Drawable {  //Interface declaration: by first user
    void draw();
}
//Implementation: by second user
class Rectangle1 implements Drawable {
    public void draw() {System.out.println("drawing rectangle");}
}
class Circle1 implements Drawable{
    public void draw(){System.out.println("drawing circle");}
}

//Using interface: by third user
class TestInterface1{
    public static void main(String args[]){
        Drawable d=new Circle1();//In real scenario, object is provided by method e.g. getDrawable()
        d.draw();
    }}


// Multiple inheritance in Java by interface - 1
interface Printable {
    void print();
}
interface Showable {
    void print();
}
class GetData implements Printable , Showable {
   public void print() {System.out.println("Hi Achieve Multiple Inheritance");}
}

class TestMultipleInheritance {
    public static void main(String args[]) {
        GetData getData = new GetData();
        getData.print();
    }
}

// Multiple inheritance in Java by interface - 2
interface Interface1 {
    void display();
}
interface Interfce2 {
    void display();
    void showMessage();
}
interface interface3 extends Interface1 , Interfce2 {

}

class GetData2 implements interface3 {
   public void display() {System.out.println("Print this interface1 ");}
    public void showMessage() {System.out.println("Print this interface2 specific method" );}
}

class TestMultipleInheritance2 {
    public static void main(String args[]) {
        GetData2 getData2 = new GetData2();
        getData2.display();
        getData2.showMessage();

}}

// Java 8 Default Method in Interface , Java 8 Static Method in Interface
interface Sam1 {
    void display();
    default void showDefault() { System.out.println("show DEFAULT method body");}
    static void showStatic() { System.out.println("show STATIC method body");}
}

class GetData3 implements Sam1
{
    public void display() { System.out.println("Override the abstract method");}
}

class TestJava8DefaultAndStaticMethods {
    public static void main(String args[]) {
        GetData3 getData3 = new GetData3();
        getData3.display();
        getData3.showDefault();
        Sam1.showStatic();
    }
}