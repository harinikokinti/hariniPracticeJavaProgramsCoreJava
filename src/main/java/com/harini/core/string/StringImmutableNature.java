package com.harini.core.string;
/*
# Immutable string in Java
In java string object are immutable - means unchangeable or unmodifiable
once string object is created its data or state cannot be changed but we can create a new instance

why string objects are immutable in java
because java uses the concept of string literal
suppose there are 10 reference variable all refer to one object "Hello”.
if one reference variable changes the value of the object it will affect to all reference variables that is why string object are immutable in java


 */

public class StringImmutableNature {
    public static void main(String[] args) {
        String str = "Hello";
        str.concat("World"); // we are using concat() method to append the string at the end
        System.out.println(str);// prints Hello bcoz strings are immutable objects, dont change their value

        String str1 = "Hello";
        str1 = str1.concat("World");
        System.out.println(str1); // prints HelloWorld
    }
}
