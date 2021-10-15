package com.harini.core.classExamples;
/*
A class is a group of objects which have common properties.
 It is a template or blueprint from which objects are created.
 It is a logical entity. It can't be physical.

 A class in Java can contain:
Fields
Methods
Constructors
Blocks
Nested class and interface


Instance variable in Java
A variable which is created inside the class but outside the method is known as an instance variable.
Instance variable doesn't get memory at compile time. It gets memory at runtime when an object or instance is created.
That is why it is known as an instance variable.


new keyword in Java
The new keyword is used to allocate memory at runtime. All objects get memory in Heap memory 




 */





// A java file should have only 1 public class

// Simple Class Example
public class NormalClass {
  private  int z;


    protected void addition(int x, int y) {
        z = (x + y);
        System.out.println("sum of X and Y are : " + z);
    }

    public void substraction(int x, int y) {
        z = (x - y);
        System.out.println("Difference of X and Y are : " + z);
    }

    void multiply(int x, int y) {
        z = (x*y);
        System.out.println("Multiplication of X and Y are : " + z);
    }

}
class Calculation {
    public static void main(String args[]) {
        NormalClass normalClass = new NormalClass();
        normalClass.addition(20,30);
        normalClass.substraction(400,300);
        normalClass.multiply(4,8);

    }
}

