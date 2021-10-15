package com.harini.core.exceptionalHandling;
/*
-- Throwable is a root class for all the Exception classes and the Error classes.
--Throwable Methods
    getMessage() : prints the detailed message given in the Throwable class or its sub calsses
    getSuppressed()
    getStackTrace()
    fillInStackTrace()
    getLocalizedMessage()
    initCause()
    getCause()
    printStackTrace()  : prints the class naem, method,  line number where the exception occurred.
                         The method printStackTrace prints the stack of methods that have been called when the exception has occured.
 */

// printStackTrace() method Example
public class ThrowableClass {
    static void validate(int x) throws Exception {
        if(x>1) { System.out.println("Positive number"); }
            else { throw new Exception("Not Positive Number");}

    }
    public static void main(String args[]) {
        try {
            validate(0);
        }catch(Exception e) {
          e.printStackTrace();// here the printStackTrace prints the class naem, method,  line number where the exception occurred.
           System.out.println(e.getMessage()); // here getMessage() method prints the detailed message given in the Throwable class or its sub calsses
        }
        System.out.println("Rest of the code");

    }
}
