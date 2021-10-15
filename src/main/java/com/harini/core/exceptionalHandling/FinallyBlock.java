package com.harini.core.exceptionalHandling;
/*
-- finally block: to execute important code such as closing the connection, etc.
The Finally block is always executed whether an exception is handled or not.
Therefore, it contains all the necessary statements that need to be printed regardless of the exception occurs or not.
The finally block follows the try-catch block.
Note: If you don't handle the exception, before terminating the program, JVM executes finally block (if any).

--Why use Java finally block?
To put "cleanup" code such as closing a file, closing connection, etc.
The important statements to be printed can be placed in the finally block.

Note:
1. For each try block there can be zero or more catch blocks, but only one finally block.
2. The finally block will not be executed if the program exits (either by calling System.exit() or by causing a fatal error that causes the process to abort).

 */

public class FinallyBlock {
    public static void main(String args[]){

        try {

            System.out.println("Inside try block");

            //below code throws divide by zero exception
            int data=25/0;
            System.out.println(data);
        }

        //handles the Arithmetic Exception / Divide by zero exception
        catch(ArithmeticException e){
            System.out.println("Exception handled");
            System.out.println(e);
        }

        //executes regardless of exception occured or not
        finally {
            System.out.println("finally block is always executed");
        }

        System.out.println("rest of the code...");
    }
}


