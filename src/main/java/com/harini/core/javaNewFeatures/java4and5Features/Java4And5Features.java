package com.harini.core.javaNewFeatures.java4and5Features;
/*
Java 4/5 new features are
Assertion, For-eachLoop, Varargs, Static Import, Autoboxing, Enums, Annotations, Generics

1. --ASSERTION:
Assertion is a statement in java. It can be used to test your assumptions about the program.
While executing assertion, it is believed to be true. If it fails, JVM will throw an error named AssertionError. It is mainly used for testing purpose.

Advantage of Assertion:
It provides an effective way to detect and correct programming errors.

Syntax of using Assertion:
There are two ways to use assertion.
1. assert expression;
2. assert expression1 : expression2;

Assertions should not be used when
1. According to Sun Specification, assertion should not be used to check arguments in the public methods because it should result in appropriate runtime exception
e.g. IllegalArgumentException, NullPointerException etc.
2. Do not use assertion, if you don't want any error in any situation.

-----------------------------------------------

2.for-each loop or Enhanced for loop
Traverses the array or collection until the last element one by one. For each element, it stores the element in the variable and executes the body of the for-each loop
Syntax:
for(data_type variable : array | collection){
//body of for-each loop
}

Advantages
It makes the code more readable.
It eliminates the possibility of programming errors.

Disadvantages:
it cannot traverse the elements in reverse order.
Cannot skip any element

---------------------------------------------------



*/

import java.util.Scanner;

public class Java4And5Features {
}


// 1. Assertion Example
class AssertionEXample
{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter ur age: ");
        int ageValue = in.nextInt();
        /*
        if(ageValue < 18)
            System.out.println("Not eligible for voting");
        else
            System.out.println("Right to vote");  */

        assert ageValue > 18 : "Not eligible for voting";  // here if the condition fails , only then the AssertionError is thrown by JVM
        System.out.println(ageValue + " Right to Vote");

    }
}
/*
3. Variable Argument (Varargs):
        The varrags allows the method to accept zero or muliple arguments.
        Before varargs either we use overloaded method or take an array as the method parameter but it was not considered good because it leads to the maintenance problem.
        If we don't know how many argument we will have to pass in the method, varargs is the better approach.

        Advantage of Varargs:
        We don't have to provide overloaded methods so less code.

        Rules for varargs:
        There can be only one variable argument in the method.
        Variable argument (varargs) must be the last argument.
        */
// 3. varargs
class VarargsExample {
   static void display(int num, String... values) {  // it must be static because main method cannot access non static methods
        System.out.println("Number is : " + num);
        for(String s : values)
        {
            System.out.println(s);
        }
    }

    public static void main(String args[]) {
        display(100,"Hello");
        display(200,"Hi" , "welcome" ,"again");
   }
}

/*
 5. Autoboxing and Unboxing
The automatic conversion of primitive data types into its equivalent Wrapper type is known as boxing and opposite operation is known as unboxing.
The automatic conversion of wrapper class type into corresponding primitive type, is known as Unboxing.

Advantage of Autoboxing and Unboxing:
No need of conversion between primitives and Wrappers manually so less coding is required.

 */

class AutoboxingExample {
    public static void main(String args[]){
        int x = 10;
        Integer x1 = Integer.valueOf(x); // converting int into Integer explicitly (autoboxing)
        Integer x2 = x;// autoboxing automatically

        Integer y = 20;
        int y1 = y.intValue(); //  unboxing explicitly
        int y2 = y; // unboxing automatically

        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(y);
        System.out.println(y1);
        System.out.println(y2);

    }
}

/*
Autoboxing and Unboxing with method overloading
In method overloading, boxing and unboxing can be performed. There are some rules for method overloading with boxing:
Widening beats boxing (here widening means converting from smaller data type to bigger one (ex: int to long)
Widening beats varargs
Boxing beats varargs
 */

// Widening beats boxing
class WideningBoxing {
    static void display(int i) { System.out.println("int");}
    static void display(Integer i) { System.out.println("Integer");}
    public static void main(String args[]) {
        int x = 30;
        display(x);
    }
}

// Widening beats varargs
class WideningVarargs {
    static void display(Integer i, Integer j) { System.out.println("int");}
    static void display(int... i) { System.out.println("int...");}
    public static void main(String args[]) {
        int i = 10;
        int j = 20;
        display(i,j);

    }
}

// boxing beats varargs
class BoxingVarargs {
    static void display(int i) { System.out.println("int");}
    static void display(int... i) { System.out.println("int...");}
    public static void main(String args[]) {
        Integer i = 10;
        display(i);

    }
}

// Widening and Boxing can't be performed as given below:

class Boxing4{
    static void m(Long l){System.out.println("Long");}

    public static void main(String args[]){
        int a=30;
      //  m(a);  // compile time error since widening is not supported here without varargs
    }
}


