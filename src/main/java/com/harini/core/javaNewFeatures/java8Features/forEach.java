package com.harini.core.javaNewFeatures.java8Features;

import java.util.ArrayList;
import java.util.List;
/*

Java provides a new method forEach() to iterate the elements.
It is defined in Iterable and Stream interface. It is a default method defined in the Iterable interface.
Collection classes which extends Iterable interface can use forEach loop to iterate elements.
This method takes a single parameter which is a functional interface.
So, you can pass lambda expression as an argument or a method reference

--Use of forEach:
There are two forEach() method in Java 8, one defined inside Iterable, and the other inside java.util.stream.Stream class.
If the purpose of forEach() is just iteration then you can directly call it like list.forEach() or set.forEach() but
if you want to perform some operations like filter or map then it better first get the stream and then perform that operation and finally call forEach() method.



 */


// Iterating by passing method reference
public class forEach {
    public static void main(String args[] ) {
        List<String> strings = new ArrayList<>();
        strings.add("Hi");
        strings.add("welcome");
        strings.add("India");
        strings.forEach(s -> System.out.println(s)); //  Iterate using Lambda
        strings.forEach(System.out::println); // Iterate using method reference
    }

}
