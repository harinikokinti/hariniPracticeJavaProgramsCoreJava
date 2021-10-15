package com.harini.core.constructorExamples;
/*
In Java, a constructor is the same as a method but the only difference is that the constructor has the same name as the class name.
It is used to create an instance of the class. It is called automatically when we create an object of the class.
It has no return type.
Remember that a constructor cannot be abstract, final, synchronized, and static.
We cannot override a constructor.
we can have private, protected, public or default constructor in Java.
If there is no constructor in a class, compiler automatically creates a default constructor.
The purpose of default constructor is to provide the default values to the object like 0, null, etc., depending on the type.

--There are two types of constructor in Java:
Default Constructor (also known as a no-argument constructor)
Parameterized Constructor

--There are many differences between constructors and methods. They are given below.
Java Constructor	                                                        Java Method
A constructor is used to initialize the state of an object.	            A method is used to expose the behavior of an object.
A constructor must not have a return type.	                            A method must have a return type.
The constructor is invoked implicitly.	                                The method is invoked explicitly.
The Java compiler provides a default constructor                       	The method is not provided by the compiler in any case.
if you don't have any constructor in a class.
The constructor name must be same as the class name.	                The method name may or may not be same as the class name.

-- Does constructor return any value?
Yes, it is the current class instance (You cannot use return type yet it returns a value).

--Can constructor perform other tasks instead of initialization?
Yes, like object creation, starting a thread, calling a method, etc. You can perform any operation in the constructor as you perform in the method.

-- Is there Constructor class in Java?
Yes.

-- What is the purpose of Constructor class?
Java provides a Constructor class which can be used to get the internal information of a constructor in the class. It is found in the java.lang.reflect package.

-- QUESTION & ANSWERS
Does constructor return any value?
Yes, it is the current class instance (You cannot use return type yet it returns a value).

Can constructor perform other tasks instead of initialization?
Yes, like object creation, starting a thread, calling a method, etc. You can perform any operation in the constructor as you perform in the method.

Is there Constructor class in Java?
Yes.

What is the purpose of Constructor class?
Java provides a Constructor class which can be used to get the internal information of a constructor in the class. It is found in the java.lang.reflect package.
 */


//Default costructor Usage without creation
class Student {

    String name;
    int age;
    // no constructor here
}

public class ConstructorDemo {

    public static void main(String args[]){
        Student student = new Student();
        //We dont have any values for Student name and age but the default cnstructor assigns default values null and 0 respectively.
       System.out.println("Student Name: " + student.name + "  " + "Student age: " + student.age);
    }
}


// Creating default and parameterised constructors, Constructor Overloading, to initialize or store or copy the values from one object to another object.

class Employee {
    String empName;
    int empAge;
    int salary;

    Employee()   // default constructor
    {
        System.out.println("Calling default constructor of type employee :   HI EVERYONE");
    }

    Employee(String name, int age)   // parameterised constructor
    {
        this(); //  calling deafult constructor. this() must be called only in constructor as a first statement
        System.out.println("Calling Parameterised constructor");
        this.empName = name;
        this.empAge = age;
        System.out.println("Employee name : " + empName + " " + "Employee age:" + empAge);
    }

    Employee(String name, int age, int salary) // Constructor overloading
    {
        System.out.println("Constructor Overloading, Employee detals with salary info");
        this.empName = name;
        this.empAge = age;
        this.salary = salary;
        System.out.println("Employee name : " + empName + " " + "Employee age:" + empAge + " " + "Employee salary : " + salary);
    }

    Employee(Employee e) // Constructor to initialize another object (to store or copy )
    {
        this.empName = e.empName;
        System.out.println("Copying values using constructor");
        System.out.println("Employee Name:" + empName);

    }

    void display() {

        System.out.println("Copying values without constructor");
        System.out.println("employee name : " + empName);
    }

}

class ConstructorDemo2 {
    public static void main(String args[]) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee("Ravikumar", 45);
        Employee employee3 = new Employee("Ravikumar", 45, 50000);
        Employee employee4 = new Employee(employee3); // to initialize the values from one object to another object.

        // Copying values without constructor
        employee1.empName = employee2.empName;
        employee1.display();


    }
}