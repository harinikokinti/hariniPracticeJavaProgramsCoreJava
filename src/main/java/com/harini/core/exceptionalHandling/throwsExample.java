package com.harini.core.exceptionalHandling;
/*
-- throws :
throws keyword is used to declare an exception which may occur. DEclared at method signature.
It provides information to the caller of the method about the exception.
It is better for the programmer to provide the exception handling code so that the normal flow of the program can be maintained.
Note: 1. Only Checked exceptions are declared.
         The Unchecked exceptions are under the programmer control, can be corrected.
         The error are beyond our control.
      2. If we are calling a method that declares an exception, we must either caught or declare the exception.

-- Advantage of Java throws keyword
Now Checked Exception can be propagated (forwarded in call stack).
It provides information to the caller of the method about the exception.

-- Can we rethrow an exception?
Yes, by throwing same exception in catch block.

 */

import java.io.IOException;

// Handle the exception Using try-catch block
public class throwsExample {

    static void method() throws IOException {
        throw new IOException("device error"); // checked exception
    }
    public static void main(String args[]){
        try{
            method();  // here the method with exception is called and must be either handled or declared

        } catch (IOException e) {  // handling the exception
            e.printStackTrace();
        }
        System.out.println("normal flow...");
    }

}

// Declare Exception
class throwsExample2 {

    static void method() throws IOException {
        System.out.println("Method body");
       // throw new IOException("device error"); // checked exception
    }
    public static void main(String args[]) throws IOException{  // here the exception is declared
      method();
      System.out.println("normal flow...");
    }

}


// Using Unchecked or Runtime Exceptions

class throwsExample3 {

    static void method()  {
        System.out.println("Method body");
       int x = 50/0;
    }
    public static void main(String args[]) {
        try {
            method();
            throw new ArithmeticException(); // Unchecked exception
        }catch(ArithmeticException e) { System.out.println(e);}
        System.out.println("normal flow...");
    }

}