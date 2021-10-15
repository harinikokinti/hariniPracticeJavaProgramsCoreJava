package com.harini.core.exceptionalHandling;
/*
-- Multi Catch Block
A try block can be followed by one or more catch blocks. Each catch block must contain a different exception handler.
So, if you have to perform different tasks at the occurrence of different exceptions, use java multi-catch block.

Note:
1. At a time only one exception occurs and at a time only one catch block is executed.
2. All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.
 */

// Example of  Multi-catch block.
public class MultiCatchBlock {
    public static void main(String[] args) {
        try{
            int a[]=new int[5];
            a[5]=30/0;
            System.out.println("rest of the code inside the try block");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code inside the main method");
    }
}

// Try block with 2 exceptions
// At a time only one exception occurs and its corresponding catch block is executed.
 class MultiCatchBlock2 {
    public static void main(String[] args) {
        try{
            int a[]=new int[5];
            a[5]=30/0;
            System.out.println(a[10]);
            System.out.println("rest of the code inside the try block");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code inside the main method");
    }
    }

// In this example, we generate NullPointerException, but didn't provide the corresponding exception type.
// In such case, the catch block containing the parent exception class Exception will invoked.

class MultiCatchBlock3 {
    public static void main(String[] args) {
        try{
            String s=null;
            System.out.println(s.length());
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}

// example, to handle the exception without maintaining the order of exceptions (i.e. from most specific to most general).
class MultiCatchBlock4{
    public static void main(String args[]){
        try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(Exception e){System.out.println("common task completed");}
      //  catch(ArithmeticException e){System.out.println("task1 is completed");}    // CT error
      //  catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");}   // CT error
        System.out.println("rest of the code...");
    }
}
