package com.harini.core.methodExamples;
/*
-- METHOD
 A method is a block of code or collection of statements or a set of code grouped together to perform a certain task or operation.
 reusability, easy modification and readability of code,

-- There are two types of methods in Java:
Predefined Method :  EXAMPLE print(), max(), sqrt(), equals(), compareTo()
User-defined Method:  The method written by the user or programmer is known as a user-defined method. These methods are modified according to the requirement.

-- Static Method:
A method that has static keyword is known as static method. It belongs to a class rather than an instance of a class is known as a static method.
The main advantage of a static method is that we can call it without creating an object.
 It can access static data members and also change the value of it. It is used to create an instance method(a non static method in a class).
It is invoked by using the class name. The best example of a static method is the main() method.

-- Instance Method
The method of the class is known as an instance method. It is a non-static method defined in the class.
Before calling or invoking the instance method, it is necessary to create an object of its class.
    There are two types of instance method:
        Accessor Method  or  getters -it reads the instance variables. It returns the value of the private field. It is used to get the value of the private field.
        Mutator Method   or setters or modifiers - to set value to the instance variables. It does not return anything.

-- Abstract method:
    It a method declared inside an abstract class with a keyword abstract and does not have method implementation.
    The class itself must be abstract if it has abstract method.

-- Factory method
It is a method that returns an object to the class to which it belongs. Factory Methods are also called Virtual Constructors. It returns the instance of the class.
A factory method can be static and non-static both. It can be used to return the instance of its own class or another class.Image Created0Down

All static methods are factory methods. For example, NumberFormat obj = NumberFormat.getNumberInstance();
 */

class StaticMethodExample {
    static void show() {
        System.out.println("It is a static method");
    }
}

abstract class AbstractMethodExample {
    abstract void showAbstractMethodData();
}

class FactoryMethodExample {
    FactoryMethodExample getInstanceOfthisClass() {
        return new FactoryMethodExample();
    }
}

public class MethodExample {

    public static void main(String args[]) {

        StaticMethodExample.show();  // calling static method without object, just with class name

        class SubClassToImplementAbstractMethod extends AbstractMethodExample {

            void showAbstractMethodData() {
                System.out.println("Implementing the abstract method in the subclass");
            }
        }

        SubClassToImplementAbstractMethod subClassToImplementAbstractMethodObject = new SubClassToImplementAbstractMethod();

        subClassToImplementAbstractMethodObject.showAbstractMethodData();

        FactoryMethodExample factoryMethodExampleObject = new FactoryMethodExample();
        System.out.println(factoryMethodExampleObject.getInstanceOfthisClass());

    }
}

