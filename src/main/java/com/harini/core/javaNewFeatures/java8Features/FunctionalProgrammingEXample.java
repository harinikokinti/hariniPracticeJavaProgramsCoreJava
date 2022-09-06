package com.harini.core.javaNewFeatures.java8Features;
/*
Funcitonal Programming features:
----------------------------

First-class funcitons
higer order funcitons
Immutable data
Pure functions
Recursion
manipulation of lists
Lazy Evalution
 */

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

// Without Funcitonal Programming
class Calculator {
    int a,b;

    public int add() {
        return a+b;
    }
    public int subtract() {
        return a-b;
    }

}

public class FunctionalProgrammingEXample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.a = 20;
        cal.b = 10;

        cal.add(); // 30
        cal.subtract(); // 20

        cal.a = 40; // if we change the value, the object value also changes for add and subtract,
        cal.add(); // 50
        cal.subtract(); // 30

    }
}



// With Funcitonal Programming  (Can pass as arguments , the object state will not change
class CalculatorFunctional {
    int a,b;

    public int add(int a, int b) {
        return a+b;
    }
    public int subtract(int a, int b) {
        return a-b;
    }

}

 class FunctionalProgrammingEXample2 {
    public static void main(String[] args) {
        CalculatorFunctional cal = new CalculatorFunctional();

        cal.add(20,10); // 30
        cal.subtract(20,10); // 20

        cal.add(40,10); // 50
        cal.subtract(40,10); // 30

    }
}


// With Funcitonal Programming  more flexible using LAMBDA

interface ICalculator {
    public void  calculate(int a, int b);
}

class CalculatorExample {
    public static void main(String[] args) {
//        ICalculator add = (a,b) -> System.out.println(a+b);
//        ICalculator subtract = (a,b) -> System.out.println(a-b);
//        ICalculator multiply = (a,b) -> System.out.println(a*b);
//        ICalculator divide = (a,b) -> System.out.println(a/b);
//
//        doCalculate(40,20,add);
//        doCalculate(40,20,subtract); //   or it can be given as below
//        doCalculate(40,20,multiply);
//        doCalculate(40,20,divide);

        doCalculate(60,30,(a,b)->System.out.println(a+b));
        doCalculate(60,30,(a,b)->System.out.println(a-b));
        doCalculate(60,30,(a,b)->System.out.println(a*b));
        doCalculate(60,30,(a,b)->System.out.println(a/b));
        doCalculate(60,30,(a,b)->System.out.println(a%b));
    }

    public static void doCalculate(int a, int b, ICalculator operation) {
        operation.calculate(a,b);
    }
}

// Calculator app using Predefined funcitonal interface BiFunction<T,T,T>

class CalculatorBiFunction {
    public static void main(String[] args) {
        // BIFunction  2 arguments 1 return value
        BiFunction<Integer, Integer,Integer> add = (a,b)-> { System.out.println(a+b); return a + b;};
        BiFunction<Integer, Integer,Integer> sub = (a,b)-> { System.out.println(a+b); return a - b;};
        BiFunction<Integer, Integer,Integer> mul = (a,b)-> { System.out.println(a+b); return a * b;};
        BiFunction<Integer, Integer,Integer> div = (a,b)-> { System.out.println(a+b); return a / b;};

        doCalculate(60,30,add);
        doCalculate(60,30,sub);
        doCalculate(60,30,mul);
        doCalculate(60,30,div);

    }

    public static void doCalculate(int a, int b, BiFunction<Integer,Integer,Integer> operation) {
        operation.apply(a,b);
    }
}

// Funcitonal Interface Demo

// Function -> 1 argument 1 return value
// BIFunction  -> 2 arguments 1 return value
// Consumer -> take 1 argument and no return value
// BiConsumer -> take 2 arguments and no return value
// Supplier -> no arguments and return value
// Predicate -> take arguments and return value

class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // Function -> 1 argument 1 return value
        Function<Integer,String>  fun = a -> {if(a%2 == 0) return "even" ; else return "odd";};
        System.out.println("I am Function fun interface: " + fun.apply(200));

        // BIFunction  -> 2 arguments 1 return value
        BiFunction<Integer, Integer, Integer> bifun = (a,b) -> a+b ;
        System.out.println("I am BiFunction fun interface: " + bifun.apply(20,30));

        // Consumer -> take 1 argument and no return value
        Consumer<String> con = a -> System.out.println(a);
        con.accept("I am Consumer Fun Interface");

        // BiConsumer -> take 2 arguments and no return value
        BiConsumer<String,String> bicon = (a,b) -> System.out.println(a.concat(b));
        bicon.accept("I am BiConsumer Fun Interface"," with 2 arguments ");

        // Supplier -> no arguments and return value
        Supplier<String> sup = () -> "I am Supplier Fun Interface";  // it returns value, so no need to write sout
        Supplier<Integer> supInt = () -> 1234;
        System.out.println(sup.get());
        System.out.println(supInt.get());

        // Predicate -> taken 1 argument and return value
        Predicate<Integer> pred = (age) -> age > 20;
        System.out.println("I am Predicate fun interface: " + pred.test(30));


    }
}
