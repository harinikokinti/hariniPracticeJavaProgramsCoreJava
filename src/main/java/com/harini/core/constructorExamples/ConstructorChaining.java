package com.harini.core.constructorExamples;
/*
A constructor is called from another constructor in the same class this process is known as constructor chaining.
In different classes, It occurs through inheritance. When we create an instance of a base class,
all the constructors of the super class are first invoked, after that the constructor of the calling class (base class) is invoked.

-- Constructor Calling form another Constructor
The calling of the constructor can be done in two ways:
1. By using this() keyword: It is used when we want to call the current class constructor within the same class.
                            this(); or
                            this(parameters list);
2. By using super() keyword: It is used when we want to call the superclass constructor from the base class.
            super(): It calls the no-argument or default constructor of the superclass.  or
            super(parameters): It invokes the superclass parameterized constructor.

-- Need of Constructor Chaining
To implement multiple tasks in a single constructor.

-- Rules of Constructor Chaining
1. An expression that uses this keyword must be the first line of the constructor.
2. Order does not matter in constructor chaining.
3. There must exist at least one constructor that does not use this

*/


// Calling Current Class Constructor
class Happy {
    Happy()
    {
        this("Hi");
        System.out.println("Yes I am Happy " );
    }
    Happy(String s)
    {
        System.out.println("Are you Happy?");
    }
}


public class ConstructorChaining {
    public static void main(String args[]) {
        Happy happy = new Happy();
    }
}


// Calling Super Class Constructor

class SuperClass {
    SuperClass() {
        System.out.println("Good Day " );
    }
}

class BaseClass extends SuperClass {
    BaseClass() {
        super();
        System.out.println("Good day one more time from base class");
    }
}

class ConstructorChainingInInheritance {
    public static void main(String args[]) {
        BaseClass baseClass = new BaseClass();
    }
}

