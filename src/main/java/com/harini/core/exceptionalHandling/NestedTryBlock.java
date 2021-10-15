package com.harini.core.exceptionalHandling;
/*
-- Nested Try block :  try block inside a try block
Sometimes a situation may arise where a part of a block may cause one error and the entire block itself may cause another error.
In such cases, exception handlers have to be nested.

Note:
1. When any try block does not have a catch block for a particular exception,
then the catch block of the outer (parent) try block are checked for that exception, and if it matches, the catch block of outer try block is executed.
If none of the catch block specified in the code is unable to handle the exception,
then the Java runtime system will handle the exception. Then it displays the system generated message for that exception.
2. When the try block within nested try block (inner try block 2) do not handle the exception.
The control is then transferred to its parent try block (inner try block 1).
If it does not handle the exception, then the control is transferred to the main try block (outer try block)
where the appropriate catch block handles the exception. It is termed as nesting.


 */

// Nested try Example
public class NestedTryBlock {
    public static void main(String args[]) {
        try {  // outer try block
            try { // inner try block 1
                int a[] = new int[5];
                System.out.println(a[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }

            try { // inner try block 2
                int x = 20 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            {
                System.out.println("handled the exception (outer catch)");
            }

        }
        System.out.println("Normal code inside the main method");
    }
}