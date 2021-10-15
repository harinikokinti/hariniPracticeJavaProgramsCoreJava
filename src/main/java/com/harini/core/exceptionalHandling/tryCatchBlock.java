package com.harini.core.exceptionalHandling;
/*
--try-catch block:
1. try : The try block contain the exception code.
         The try block must be followed by either catch or finally.
         It must be used within the method.
         Note: If an exception occurs at the particular statement in the try block, the rest of the block code will not execute.
               So, it is recommended not to keep the code in try block that will not throw an exception.
         Syntax:
                try
                {
                //code that may throw exception
                } catch(Exception e) {}

                try
                {
                //code that may throw exception
                } finally{}

2. catch : To handle the exception by declaring the type of exception within the parameter.
           The declared exception must be the parent class exception ( i.e., Exception) or the generated exception type.
           It must be preceded by try block which means we can't use catch block alone.
           It can be followed by finally block later.
           You can use multiple catch block with a single try block.

-- Internal Working of Java try-catch block
The JVM firstly checks whether the exception is handled or not.
If handled, rest of the code is executed.
If exception is not handled, JVM provides a default exception handler that performs the following tasks:
    Prints out exception description.
    Prints the stack trace (Hierarchy of methods where the exception occurred).
    Causes the program to terminate.

 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Exception handling using try chatch blocks
public class tryCatchBlock {
    public static void main(String[] args) {
        try
        {
            int data=50/0; //may throw exception
            // // if exception occurs, the remaining statement will not execute
            System.out.println("rest of the code inside the try block");
        }
        //handling the exception
        catch(ArithmeticException e)  // or catch(Exception e), can be handled using parent class exception
        {
            System.out.println(e);
            //  System.out.println("Can't divided by zero"); //   to print a custom message on exception.
            //  System.out.println(50/(0+2));  //  resolving the exception in catch block
        }
        System.out.println("rest of the code inside the main method");
    }
}

//  Handle Unchecked(Runtime) Exception ArrayIndexOutOfBoundsException .
class tryCatchBlock2 {

    public static void main(String[] args) {
        try
        {
            int arr[]= {1,3,5,7};
            System.out.println(arr[10]); //may throw exception
        }
        // handling the array exception
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println("rest of the code");
    }
}

//  Handle Checked(compiletime) Exception  FileNotFoundException
class tryCatchBlock3 {

    public static void main(String[] args) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("jtp.txt"); //may throw exception
            pw.println("saved");
        }
// providing the checked exception handler
        catch (FileNotFoundException e) {

            System.out.println(e);
        }
        System.out.println("File saved successfully");
    }
}