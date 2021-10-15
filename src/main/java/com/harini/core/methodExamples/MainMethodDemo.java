package com.harini.core.methodExamples;

/*
-->Java main() method
The main() is the starting point for JVM to start execution of a Java program.

--> What happens if the main() method is written without String args[]?
The program will compile, but not run, because JVM will not recognize the main() method.
Remember JVM always looks for the main() method with a string type array as a parameter.

--> EXECUTION PROCESS
First, JVM executes the static block, then it executes static methods, and then
it creates the object needed by the program. Finally, it executes the instance methods.

-- Different ways of writing main() method are:

static public void main(String []x)
static public void main(String...args)
   We can interchange public and static and write it as follows:
static public void main(String args[])


 */



// JVM 1st executes the static block and then the main method
public class MainMethodDemo
{
static                  //static block
{
    System.out.println("Static block");
        }
public static void main(String args[])  //static method
        {
        System.out.println("Static method");
        }
        }


// Overloading of main() method
//We can also overload the main() method. We can define any number of main() method in the class, but the method signature must be different.
class OverloadMain
{
    public static void main(int a)  //overloaded main method
    {
        System.out.println("this is an overloaded main method with an integer value " +a);
    }

    public static void main(String x) //overloaded main method
    {
        System.out.println("hi this is an overloaded main method with string value: " + x);
    }
    public static void main(String args[])
    {
        System.out.println("main method invoked");
        main(6);
        main("Hi WELCOME");
    }
}
