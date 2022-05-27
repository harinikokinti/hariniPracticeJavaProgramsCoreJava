package com.harini.core.encapsulation;
/*  Encapsulation: securing, binding, hiding, protecting
It is a process of wrapping code and data together into a single unit.
We can create a fully encapsulated class in Java by making all the data members of the class private.
Now we can use setter and getter methods to set and get the data in it.
The Java Bean class is the example of a fully encapsulated class.

Advantage:
1. By providing only a setter or getter method, you can make the class read-only or write-only.
2. It provides you the control over the data
3. It is a way to achieve data hiding in Java because other class will not be able to access the data through the private data members.
4.The encapsulate class is easy to test. So, it is better for unit testing.
 */

// simple program with encapsulation

class Student {
    // private data members
    private String name;
    private int rollno;
// getters and setters
    void setName(String name) {
        this.name = name;
    }

    void setRollno(int rollno) {
        this.rollno = rollno;
    }

    String getName(){
        return name;
    }

    int getRollno() {
        return rollno;
    }
}

public class Encapsulation {
    public static void main(String args[]) {
        Student student  = new Student();
        student.setName("Ravi");
        student.setRollno(101);
        System.out.println(student.getName());
        System.out.println(student.getRollno());
    }
}
