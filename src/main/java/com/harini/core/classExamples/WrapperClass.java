package com.harini.core.classExamples;
/*
Wrapper classes
The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

Since J2SE 5.0, autoboxing and unboxing feature convert primitives into objects and objects into primitives automatically.
 The automatic conversion of primitive into an object is known as autoboxing and vice-versa unboxing.

 Use of Wrapper classes:
 Change the value in Method
 Serialization
 Synchronization :  thread realted methods are available with the wrapper classes instance methods
 java.util package:
 Collection Framework : collections make use of wrapper classes instead of primitive datatypes

 Primitive Type	Wrapper class
boolean	        Boolean
char	        Character
byte	        Byte
short	        Short
int	            Integer
long	        Long
float	        Float
double	        Double

Example of Autoboxing:
int a=20;
Integer i=Integer.valueOf(a);//converting int into Integer explicitly
Integer j=a;//autoboxing, now compiler will write Integer.valueOf(a) internally

Example of Unboxing:
Integer a=new Integer(3);
int i=a.intValue();//converting Integer to int explicitly
int j=a;//unboxing, now compiler will write a.intValue() internally

 */
import java.util.OptionalInt;

public class WrapperClass {

    public static void main(String args[]) {
        int x = 9;
        Integer y = 6;
        System.out.println("PRint y value " +y.intValue()); // unboxing explcitly, but no need in higher versions , it does automatically
       int z =  y.compareTo(x); //  to comapre with other int vales
       System.out.println(z);

        Integer str = Integer.valueOf("123"); // to assign a string value
        int str1 = Integer.valueOf("123");


    }

}
