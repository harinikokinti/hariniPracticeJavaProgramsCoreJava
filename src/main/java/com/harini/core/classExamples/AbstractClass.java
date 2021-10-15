package com.harini.core.classExamples;
/* Abstraction is a process of hiding the implementation details and showing only functionality to the user.
    Ways to achieve Abstraction
        There are two ways to achieve abstraction in java

        1.Abstract class (0 to 100%)
        2. Interface (100% )

An abstract class must be declared with an abstract keyword.
It can have abstract and non-abstract methods.
It cannot be instantiated.
It can have constructors and static methods also and even main() method.
It can have final methods which will force the subclass not to change the body of the method.
 */

//Example of an abstract class that has abstract and non-abstract methods
abstract class AbstractClass {

    void addition(int x, int y){
        System.out.println(x+y);
    }

    abstract void multiply(int x, int y);
    final void substract(int x, int y) {System.out.println(x-y);} // cannot be overriden in the subclass

}

class ChildClass extends AbstractClass{  // here the childClss must implement the abstract method multiply()

    @Override
    void multiply(int x,int y) {
        System.out.println(x*y);
    }

}

class AbstractClassDemo {
    public static void main(String args[]) {

        ChildClass childObject = new ChildClass();

        childObject.multiply(2,3);
        childObject.addition(2,3);

    }
}
