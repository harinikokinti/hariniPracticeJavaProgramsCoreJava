package com.harini.core.javaNewFeatures.java4and5Features.generics;
/*
--Generic Method
a method which can accept any type of arguments in it.
Here, the scope of arguments is limited to the method where it is declared. It allows static as well as non-static methods.

 */

// Generic method to print array elements. We are using here E to denote the element.

public class GenericMethod {
    static   <E> void printArray(E[] elements) {
        for (E e : elements) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        Integer[] intArray = {1,2,3,4,5};
        String[] strings = {"ABC", "DEF", "GHI", "JKL"};
        Double[] doubleArray = {20.00,13.4,49.0,34.67};
        System.out.println( "Printing Integer Array" );
        printArray(intArray);
        System.out.println( "Printing Strings" );
        printArray(strings);
        System.out.println( "Printing Double Array" );
        printArray(doubleArray);


    }
}