package com.harini.core.exceptionalHandling;
/*
Difference:

throw
1. To throw an exception explicitly in the code, inside the function or the block of code.
2. The checked exception cannot be propagated using throw only, not Unchecked exceptions.
3. The throw keyword is followed by an instance of Exception to be thrown.
4. throw is used within the method.
5. we cannot throw multiple exceptions.

throws:
1. Used in the method signature to declare an exception which might be thrown by the function while the execution of the code.
2. we can declare both checked and unchecked exceptions. However, the throws keyword can be used to propagate checked exceptions only.
3. The throws keyword is followed by class names of Exceptions to be thrown.
4. throws is used with the method signature.
5. We can declare multiple exceptions using throws keyword that can be thrown by the method.
 */

import java.io.IOException;

// Example with both throw and throws
public class throwThrows {
    static void calculate() throws IOException {
        System.out.println("Inside the method");
        throw new IOException("Device error");
    }

    public static void main(String args[])  {
        try {
            calculate();
        } catch (IOException e) { System.out.println("caught in main() method"); }
        System.out.println("Rest of the code");
    }
}
