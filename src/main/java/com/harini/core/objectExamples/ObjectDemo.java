package com.harini.core.objectExamples;

/*
--- An Object is an entity which has state and behaviour e.g., chair, bike, marker, pen, table, car, etc.
It can be physical or logical (tangible and intangible).
The example of an intangible object is the banking system.

An object has three characteristics:

State: represents the data (value) of an object.
Behavior: represents the behavior (functionality) of an object such as deposit, withdraw, etc.
Identity: it is used internally by the JVM to identify each object uniquely.

An object is an instance of a class. A class is a template or blueprint from which objects are created. So, an object is the instance(result) of a class.

--- Object Definitions:

An object is a real-world entity.
An object is a runtime entity.
The object is an entity which has state and behavior.
The object is an instance of a class.
object gets the memory in heap memory area.

There are 3 ways to initialize object in Java. Initializing an object means storing data into the object.
By reference variable
By method
By constructors

Example:
Student student = new Student("RAM", 101,"CSE"); //Creating object & Object initialization through constructor
Branch branch = new Branch();
branch.branchName = "CSE";  // // Object Initialization through reference variable
branch.branchID = 1;
student.setStudentLastName("XYZ"); // Object initialization through method
new Branch().printGreetings(); //calling method with anonymous object
Labs lab1 = new Labs(), lab2 = new Labs(); // creating multiple objects

There are many ways to create an object in java. They are:

By new keyword
By newInstance() method
By clone() method
By deserialization
By factory method etc.

--- Anonymous object
Anonymous simply means nameless. An object which has no reference is known as an anonymous object. It can be used at the time of object creation only.
If you have to use an object only once, an anonymous object is a good approach.
new Branch().printGreetings(); //calling method with anonymous object

The objects can be created without new keyword by following ways
Using Class.forName() and Class.newInstance()
ClassLoader loadClass()
Using Object.clone()
Deserialization
Using reflection


-- Create object using Class.newInstance()
Class ref = Class.forName("DemoClass");
DemoClass obj = (DemoClass) ref.newInstance();
Class.forName() loads the class in memory. To create an instance of this class, we need to use newInstance().

-- Create object using class loader’s loadClass()
Just like above method, class loader’s loadClass() method does the same thing. It creates a new instance of class using an existing instance of same class.

instance.getClass().getClassLoader().loadClass("NewClass").newInstance();

--Create object using Object.clone()
This is also a way to have a new independent instance of a class.
NewClass obj = new NewClass();
NewClass obj2 = (NewClass) obj.clone();

-- Create new object using serialization and deserialization
If you have gone through this article, you can understand that serialization and de-serialization is also a way to have another instance of a class in system.

ObjectInputStream objStream = new ObjectInputStream(inputStream);
 NewClass obj = (NewClass ) inStream.readObject();

-- Create new object using reflection  [refer reflectionAPI package)
Reflection is also a popular way to create new instances in most of available frameworks.
constructor.newInstance(); or
class.newInstance();





 */


// Creating the objects, Initializing the objects through reference, method, constructor. Anonymous Object . Creating multiple objects at a time

class Branch {
    String branchName;
    int branchID;

    void printGreetings() {
        System.out.println("Hi All the Very Best");
    }
}

class Labs {

    String labName;

    void setLabName(String labName){
        this.labName = labName;
    }
    String getLabName(){
       return labName;
    }
}



class Student {
     String studentName;
     int studentID;
     String studentBranch;
    String studentLastName;


    Student(String studentName, int ID, String studentBranch) {
        this.studentName = studentName;
        this.studentID = ID;
        this.studentBranch = studentBranch;
    }

    void setStudentLastName(String studentLastName){
        this.studentLastName = studentLastName;
    }

    String getStudentLastName(){
           return studentLastName;
    }
}


public class ObjectDemo {
    public static void main(String args[]) {

        Student student = new Student("RAM", 101,"CSE"); //Creating object & Object initialization through constructor

        Branch branch = new Branch();
        branch.branchName = "CSE";  // // Object Initialization through reference variable
        branch.branchID = 1;


        student.setStudentLastName("XYZ"); // Object initialization through method

        new Branch().printGreetings(); //calling method with anonymous object

        Labs lab1 = new Labs(), lab2 = new Labs(); // creating multiple objects
        lab1.setLabName("COMPUTERS LABORATORY");
        lab2.setLabName("MECHANICS LABORATORY");

        //Print Student details

        System.out.println("Student Details: " + student.studentName + " " +  student.studentID + " " +  student.studentBranch);

        System.out.println("Branch details: " + branch.branchID + " " + branch.branchName);

        System.out.println("Student LastName: " + student.getStudentLastName());

        System.out.println("Labs : " + lab1.getLabName() + " , " + lab2.getLabName() );

    }

}


