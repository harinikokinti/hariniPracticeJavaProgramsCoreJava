package com.harini.core.staticExamples;
/*
--Java static method
If you apply static keyword with any method, it is known as static method.
A static method belongs to the class rather than the object of a class.
A static method can be invoked without the need for creating an instance of a class.
A static method can access static data member and can change the value of it.
A static method cannot be overriden because method overriding is based on dynamic binding at runtime and
    the Static methods are bonded at compile time using static binding.

-- There are two main restrictions for the static method. They are:
The static method can not use non static data member or call non-static method directly.
this and super cannot be used in static context.

-- Java static block
Is used to initialize the static data member.
It is executed before the main method at the time of classloading.

-- QUESTIONS
1. Why is the Java main method static?
Ans) It is because the object is not required to call a static method.
If it were a non-static method, JVM creates an object first then call main() method that will lead the problem of extra memory allocation.
2. Can we execute a program without main() method?
Ans) No, one of the ways was the static block, but it was possible till JDK 1.6.
Since JDK 1.7, it is not possible to execute a Java class without the main method.
3.What is the purpose of static methods and variables??
The static methods or variables are shared among all the objects of the class

 */

// Static method example
class StudentNew {
        String studentName;
        int studentRollno;
        static String college = "SVCET";

        // static method to change the static variable college name
        static void getUpdatedCollege()
        {
            college = "SITAMS";  //  can access only static data members, here college is static instance variable
        }
        //constructor to initialize the variable
        StudentNew (String name, int rollno){
            this.studentRollno = rollno;
            this.studentName = name;
        }

         //method to display values
        void display(){
            System.out.println("Student details : " + studentName + "  " + studentRollno + " " + college);
        }
}


public class StaticMethodExample {
    public static void main(String args[]) {
        StudentNew.getUpdatedCollege();  // calling change method
        // creating objects
        StudentNew studentNew = new StudentNew("ravi",1);
        StudentNew studentNew2 = new StudentNew("kiran",2);
        //calling display method
        studentNew.display();
        studentNew2.display();
    }
}




// Static method example 2

class Calculate{
    static int cube(int x){
        return x*x*x;
    }

    public static void main(String args[]){
      //  Calculate c = new Calculate();
        //System.out.println("the value of cube : " + c.cube(5));

      int result=Calculate.cube(5);  //  here without creting object for the class Calculate we can access the static method with its class name
      System.out.println(result);
    }
}




//Example of static block
class A2{
    static{
        System.out.println("static block is invoked");
    }
    public static void main(String args[]){
        System.out.println("Hello main");
    }
}

// We cannot override the Static method

//parent class
class ParentClass
{
    //we cannot override the display() method
    public static void display()
    {
        System.out.printf("display() method of the parent class.");
    }
}
//child class
class ChildClass extends ParentClass
{
    //the same method also exists in the ParentClass
//it does not override, actually it is method hiding
    public static void display()
    {
        System.out.println("Overridden static method in Child Class in Java");
    }
}
class OverloadStaticMethodExample3
{
    public static void main(String args[])
    {
        ParentClass pc = new ChildClass();
//calling display() method by parent class object
        pc.display();
    }
}


//  practice static variable   [ the static variable holds its value in the class memory for n number of objects of that class

class StaticVariable {
 static    int c = 1;
    void counter() {
        System.out.println("The counter value is " + ++c);
    }
}

class StaticVariableTest {
    public static void main(String args[]) {
        StaticVariable sv = new StaticVariable();
        StaticVariable sv2 = new StaticVariable();
        sv.counter();
        sv2.counter();

        sv = new StaticVariable();
        sv.counter();
        sv = new StaticVariable();
        sv.counter();



    }

}

//  practice static method    ( the static method can change the static variable, can be accessed using its class name

class StaticMethod {
    static String collegeName = "SVCET";

    void displayCollegeName() {
        System.out.println("The college name is " + collegeName);
    }

    static void displayCollegeNameChanged () {
        collegeName = "SITAMS";
        System.out.println("The college name is " + collegeName);
    }
    public static void main(String args[]) {
        StaticMethod sm = new StaticMethod();

        sm.displayCollegeName();
        StaticMethod.displayCollegeNameChanged();
    }
}



