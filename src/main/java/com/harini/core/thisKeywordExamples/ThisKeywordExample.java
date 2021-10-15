package com.harini.core.thisKeywordExamples;
/*
In java, this is a reference variable that refers to the current object.
Usage of java this keyword
Here is given the 6 usage of java this keyword.

this can be used to refer current class instance variable.
this can be used to invoke current class method (implicitly).
this can be passed as argument in the constructor call.
this() can be used to invoke current class constructor.
this can be passed as an argument in the method call.It is mainly used in the event handling
this can be used to return the current class instance from the met
this mainly used for Constructor chaining. To reuse the constructor from the constructor. It maintains the chain between the constructors.
Call to this() must be the first statement in constructor.
this: to pass as argument in the constructor call. It is useful if we have to use one object in multiple classes. (not understood)
this keyword can be used to return current class instance


 */

// this: to refer current class instance variable
class Student
{
    String name;
    int rollno;
    String branch;

    Student(String name, int rollno) {
        this.name = name;  // here, no need this keyword, if the instance variable and the local variable are not same
        // this keyword resolves the problem of ambiguity.
        this.rollno = rollno;
    }
    void display(){
        System.out.println("Student details: " + name + " " + rollno) ;
    }
    void displayWithBranch(String branch){
        System.out.println("Student details with branch");
        this.branch = branch;
        // display() ; // same as this.display();
        this.display(); //  this keyword to invoke the current class method.
        System.out.println("Branch details: " + branch);
    }
}

 public class ThisKeywordExample {
    public static void main(String args[]) {
        Student student = new Student("Ravi" ,3);
        student.display();
        student.displayWithBranch("CSE");
    }
}



