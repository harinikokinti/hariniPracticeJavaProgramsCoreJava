package com.harini.OtherJavaConcepts;

public class FibonacciSeries {
    public static void main(String args[]) {
        int a=0, b=1, c;
        System.out.println(a);
        System.out.println(b);
        for(int i=2; i<10; i++) {  //  here  i =2, since the first 2 numbers are already printed
            c = a+b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}


// Using Recursion

class FibonacciSeriesRecursion {
    static int a = 0, b = 1, c;

   static void fibonacciRecursive(int count) {

        if(count>0)
        {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
            fibonacciRecursive(count-1);
        }

    }
    public static void main(String args[]) {
        System.out.println(a);
        System.out.println(b);
        int count = 10;
        fibonacciRecursive(count-2);
    }
    }