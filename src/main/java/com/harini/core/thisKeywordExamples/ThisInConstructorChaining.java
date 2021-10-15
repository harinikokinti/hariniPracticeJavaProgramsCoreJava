package com.harini.core.thisKeywordExamples;
/*
this mainly used for Constructor chaining. To reuse the constructor from the constructor. It maintains the chain between the constructors.
Call to this() must be the first statement in constructor.
 */


// To invoke current class constructor , CONSTRUCTOR CHAINING
class StudentNew
{
    String name;
    int rollno;
    String branch;
    StudentNew()
    {
        System.out.println("WELCOME");

    }

    StudentNew(String name, int rollno) {
        this(); // calling the default constructor
        this.name = name;
        this.rollno = rollno;
    }
    StudentNew(String name, int rollno,String branch)
    {
        this(name,rollno); //calling and reusing the parameterised constructor
        this.branch = branch;

    }
    void display(){
        System.out.println("Student details: " + name + " " + rollno + " " + branch) ;
    }

}

public class ThisInConstructorChaining{
    public static void main(String args[]) {
        StudentNew studentNew = new StudentNew("Raju" ,4, "IT");
        studentNew.display();
    }
}

