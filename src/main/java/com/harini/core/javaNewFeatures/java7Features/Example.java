package com.harini.core.javaNewFeatures.java7Features;
/*
Binary Literals
Switch with String
Java 7 Multi Catch
Try with Resources
Type Inference
Numeric Literals
Java 7 JDBC

-- Binary Literals:
Binary Literal in Java 7. I allows you to express integral types (byte, short, int, and long) in binary number system.
To specify a binary literal, add the prefix 0b or 0B to the integral value.

-- String in Switch Statement
Java allows you to use string objects in the expression of switch statement.
In order to use string, you need to consider the following points:
    It must be only string object.
    String object is case sensitive.
    No Null object

-- Catch Multiple Exceptions
to catch multiple type exceptions in a single catch block. It was introduced in Java 7 and helps to optimize code.
Use vertical bar (|) to separate multiple exceptions in catch block.
            try{
            int array[] = newint[10];
            array[10] = 30/0;
        }
        catch(Exception | ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

Note - Catch block which handles more than one exception type makes the catch parameter implicitly final.
       In the above example, the catch parameter "e" is final and therefore you cannot assign any value to it.

-- Try with Resources
The try-with-resources statement is a try statement that declares one or more resources.
The resource is as an object that must be closed after finishing the program.
You can pass any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable.
Exceptions which are thrown by try-with-resources are suppressed exceptions.

Note: In a try-with-resources statement, catch or finally block executes after closing of the declared resources.

-- Type Inference for Generic Instance Creation
Java provides improved compiler which is enough smart to infer the type of generic instance.
 Now, you can replace the type arguments with an empty set of type parameters (<>). This pair of angle brackets is informally called the diamond.

The following approach is used in Java 6 and prior version.
Ex. List<Integer> list  = new List<Integer>();
Now, you can use the following new approach introduced in Java 7.
Ex. List<Integer> list = new List<>(); // Here, we just used diamond

-- Numeric Literals
Java allows you to use underscore in numeric literals.
This feature was introduced in Java 7.
This feature enables you, for example, to separate groups of digits in numeric literals, which can improve the readability of your source code.

The following points are considerable:
You cannot use underscore at the beginning or end of a number.
Ex. int a = _10; // Error, this is an identifier, not a numeric literal
Ex. int a = 10_; // Error, cannot put underscores at the end of a number
You cannot use underscore adjacent to a decimal point in a floating point literal.
Ex. float a = 10._0; // Error, cannot put underscores adjacent to a decimal point
Ex. float a = 10_.0; // Error, cannot put underscores adjacent to a decimal point
You cannot use underscore prior to an F or L suffix
Ex. long a = 10_100_00_L; // Error, cannot put underscores prior to an L suffix
Ex. float a = 10_100_00_F; // Error, cannot put underscores prior to an F suffix
You cannot use underscore in positions where a string of digits is expected.

-- Java 7 JDBC
In Java 7, Java has introduced the following features:
1) It provides the ability to use a try-with-resources statement to automatically close resources of type Connection, ResultSet, and Statement.
2) RowSet 1.1: The introduction of the RowSetFactory interface and the RowSetProvider class, which enable you to create all types of row sets
               supported by your JDBC driver.







 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Example {
}

class tryWithResourceExample {
    public static void main(String args[]) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("text.txt") ) {
            String msg = "Welcome here";
            byte[] byteArray = msg.getBytes(); // converting string to byte
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfuly!");
        }
        catch(Exception exception) {
            System.out.println(exception);
        }
    }
}


// Numeric Literals
class UnderscoreInNumericLiteralExample {
    public static void main(String[] args) {
        // Underscore in integral literal
        int a = 10_00000;
        System.out.println("a = "+a);
        // Underscore in floating literal
        float b = 10.5_000f;
        System.out.println("b = "+b);
        // Underscore in binary literal
        int c = 0B10_10;
        System.out.println("c = "+c);
        // Underscore in hexadecimal literal
        int d = 0x1_1;
        System.out.println("d = "+d);
        // Underscore in octal literal
        int e = 01_1;
        System.out.println("e = "+e);
    }
}
