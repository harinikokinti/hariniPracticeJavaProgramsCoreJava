package com.harini.core.exceptionalHandling;
/*
-- Custom or User defined Exceptions
Creating our own Exception is known as custom exception or user-defined exception.
Usage:
 To customize the exception according to the user need.
 To implement Business logic exceptions, so that it gives god understanding for the application users.
 */

// Custom Exception or User defined Exception Example
class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        System.out.println("No right to vote");
    }
}

public class CustomException {
    public static void main(String args[]) {
        int age = 13;
        try{
            if(age<18) {
                throw new InvalidAgeException();
            }
            else {
                System.out.println("Right to vote");
            }
            } catch(InvalidAgeException e) { System.out.println(e);
        }

    }
}

