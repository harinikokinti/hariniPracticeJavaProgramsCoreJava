package com.harini.core.staticExamples;
/*
The static keyword in Java is used for memory management mainly.
The static keyword belongs to the class than an instance of the class.
Java static property is shared to all objects.
The static can be:
1. Variable (also known as a class variable)
2. Method (also known as a class method)
3. Block
4. Nested class

--Java static variable
If you declare any variable as static, it is known as a static variable.

The static variable can be used to refer to the common property of all objects (which is not unique for each object),
for example, the company name of employees, college name of students, etc.
The static variable gets memory only once in the CLASS AREA at the time of class loading.

--Advantages of static variable
It makes your program memory efficient (i.e., it saves memory).

 */

// Program to understand static variable

class Student {
    String studentName;
    int studentRollno;
    static String college = "SVCET";
    /*
    Suppose there are 500 students in my college, now all instance data members will get memory each time when the object is created.
    All students have its unique rollno and name, so instance data member is good in such case. Here, "college" refers to the common property of all objects.
    If we make it static, this field will get the memory only once.
    here the output does not change if the variable college is static or not static.
    But the field college will get memory only once if it is static
     */

    Student(String name, int rollno) // constructor
    {
        this.studentName = name;
        this.studentRollno = rollno;
    }

    void display()
    {
        System.out.println("Student Name: " + studentName + " " + "Student rollno: " + studentRollno + " " + college);
    }

}

public class StaticVariableExample {
    public static void main(String args[]) {
        Student student1 = new Student("Shilpa",17);
        Student student2 = new Student("Radhika",16);
        student1.display();
        student2.display();

    }
}
