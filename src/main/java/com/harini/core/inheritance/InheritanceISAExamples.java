package com.harini.core.inheritance;
/*
Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.
Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

-- USES:
1. For Method Overriding (so runtime polymorphism can be achieved).
2. For Code Reusability.

-- Terms used in Inheritance
Super Class/Base Class/Parent class
Sub class/child class/Derived class/Extended class

-- The extends keyword indicates that you are making a new class that derives from an existing class. The meaning of "extends" is to increase the functionality.

-- TYPES
There can be three types of inheritance in java:
Single: parent, child
Multilevel: GrandParents, Parents, child
Hierarchical: Parent, child1, child2
In java programming, multiple and hybrid inheritance is supported through interface only not with class
It can be achieved using interfaces

--QUESTION
Why multiple inheritance is not supported in java?
To reduce the complexity and simplify the language, multiple inheritance is not supported in java.
Consider a scenario where A, B, and C are three classes. The C class inherits A and B classes.
 If A and B classes have the same method and you call it from child class object, there will be ambiguity to call the method of A or B class.
 */

// Single Inheritance: When a class inherits another class, it is known as a single inheritance.
class Animal
{
    void eat()
    {
        System.out.println("Eating");
    }
}

class Dog extends Animal{
    void bark()
    {
        System.out.println("Barking");
    }
}

public class InheritanceISAExamples {
    public static void main(String args[])
    {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }

}


// Multilevel Inheritance : When there is a chain of inheritance, it is known as multilevel inheritance

class Animal2
{
    void eat()
    {
        System.out.println("Eating");
    }
}

class Dog2 extends Animal2{
    void bark()
    {
        System.out.println("Barking");
    }
}

class Babydog extends Dog {
    void weep()
    {
        System.out.println("Weeping");
    }
    public static void main(String args[]) {
        Babydog babyDog = new Babydog();
        babyDog.weep();
        babyDog.bark();
        babyDog.eat();
    }
}

// Hierarchical Inheritance  : When two or more classes inherits a single class, it is known as hierarchical inheritance.

class Animal3
{
    void eat()
    {
        System.out.println("Eating");
    }
}

class Dog3 extends Animal3{
    void bark()
    {
        System.out.println("Barking");
    }
}
class Cat extends Animal3
{
    void meow()
    {
        System.out.println("Meow Meow");
    }

    public static void main(String args[])
    {
        Cat cat = new Cat();
        cat.meow();
        cat.eat();
    }
}