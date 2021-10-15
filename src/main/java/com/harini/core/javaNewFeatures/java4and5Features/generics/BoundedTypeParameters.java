package com.harini.core.javaNewFeatures.java4and5Features.generics;
/*
--Bounded Type Parameters:
There may be times when you'll want to restrict the kinds of types that are allowed to be passed to a type parameter.
For example, a method that operates on numbers might only want to accept instances of Number or its subclasses. This is what bounded type parameters are for.

To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword, followed by its upper bound.

--Multiple Bounds : <T extends C & I>
A type parameter can have multiple bounds.
Syntax
public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z)
Where
maximum − maximum is a generic method.
T − The generic type parameter passed to generic method. It can take any Object.
here,the T is a type parameter passed to the generic class Box and should be subtype of Number class and must implments Comparable interface. In case a class is passed as bound, it should be passed first before interface otherwise compile time error will occur.


 */

//This example is Generic method to return the largest of three Comparable objects

public class BoundedTypeParameters {
    static <T extends Comparable<T> > T getMaxNumber(T x, T y, T z) {
        T max = x;  //  Initially assume x as the largest
        if(y.compareTo(max) > 0) { max = y ; }  // y is the largest
        if(z.compareTo(max) > 0) { max = z; }   // z is the largest
        return max;
    }
    public static void main(String args[]) {
        System.out.printf("Max of %d, %d and %d is %d \n\n",3,5,1, getMaxNumber(3,5,1));
        System.out.printf("Max of %f, %f and %f is %f \n\n",8.9,5.4,19.45, getMaxNumber(8.9,5.4,19.45));
        System.out.printf("Max of %s, %s and %s is %s \n\n","App","Tree","Um", getMaxNumber("Apple","Tree","Um"));
    }
}


//

class MultipleBoundedTypeParameters {
    static <T extends Number & Comparable<T>> T getMaxNumber(T x, T y, T z) {
        T max = x;  //  Initially assume x as the largest
        if(y.compareTo(max) > 0) { max = y ; }  // y is the largest
        if(z.compareTo(max) > 0) { max = z; }   // z is the largest
        return max;

    }
    public static void main(String args[]) {
        System.out.printf("Max of %d, %d and %d is %d \n\n",3,5,1, getMaxNumber(3,5,1));
        System.out.printf("Max of %f, %f and %f is %f \n\n",8.9,5.4,19.45, getMaxNumber(8.9,5.4,19.45));
      //  System.out.printf("Max of %s, %s and %s is %s \n\n","App","Tree","Um", getMaxNumber("Apple","Tree","Um")); // CT error
    }
}


