package com.harini.core.javaNewFeatures.java8Features;
/*
Type Inference
Type inference is a feature of Java which provides ability to compiler to look at each method invocation and corresponding declaration to determine the type of arguments.
Java provides improved version of type inference in Java 8. the following example explains, how we can use type inference in our code:
Here, we are creating arraylist by mentioning integer type explicitly at both side.

The following approach is used earlier versions of Java.
List<Integer> list = new ArrayList<Integer>();

Java8 version
List<Integer> list = new ArrayList<>();  //  leave the second side blank the cmpileer can infer the tyoe

 */

import java.util.ArrayList;
import java.util.List;

public class TypeInference {
    public static void showList(List<Integer> list){
        if(!list.isEmpty()){
            list.forEach(System.out::println);
        }else System.out.println("list is empty");
    }
    public static void main(String[] args) {
        // An old approach(prior to Java 7) to create a list
        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        showList(list1);
        // Java 7
        List<Integer> list2 = new ArrayList<>(); // You can leave it blank, compiler can infer type
        list2.add(12);
        showList(list2);
        // Compiler infers type of ArrayList, in Java 8
        showList(new ArrayList<>());
    }

}
