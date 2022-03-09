package com.harini.core.javaNewFeatures.java8Features;
/*
Lambda Expression:  A function that can be shared or referred to as an object.
1. To provide the implementation of Functional interface(one abstract method interface).
2. Less coding.

Java lambda expression consists of three components.
1) Argument-list: It can be empty or non-empty as well.
2) Arrow-token: It is used to link arguments-list and body of expression.
3) Body: It contains expressions and statements for lambda expression.

No Parameter Syntax
() -> {
//Body of no parameter lambda
}

One Parameter Syntax
(p1) -> {
//Body of single parameter lambda
}

Two Parameter Syntax
(p1,p2) -> {
//Body of multiple parameter lambda
}

Note: Lambda expresssion is the implementation of the single method of functional interface

 */

import java.util.*;
import java.util.stream.Stream;

// With and Without Lambda Expression Example
interface Drawable {
    void draw();
}

public class LambdaExpression {



    public static void main(String args[]) {
        int width = 10;

        //without lambda, Drawable implementation using anonymous class
        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println( " Without Lambda " + width );
            }
        };
        d.draw();

        // With Lambda Expression
       // Drawable d1 = () -> System.out.println( " With Lambda" + width ); //  can be written like this
        Drawable d1 = () -> { System.out.println( " With Lambda " + width ); };
        d1.draw();
    }
}

// Lamba Expression with single and multiple parameters
interface Sayable {
  public  String say(String a);
}

interface Sayable2 {
    int add(int a, int b);
}
class LambdaExpressionWithArguments {
    public static void main(String[] args) {
        Sayable s = (a) -> { return "Single Parameter with String value :  " + a; };
        System.out.println(s.say("Ravi"));

        Sayable2 s2 = (a,b) -> { return  (a + b)  ; };
        System.out.println("Multiple Parameter with Addition od 2 int values  : "  + s2.add(20,30));
    }
}

// Foreach loop

class LambdaExpressionForEach {
    public static void main(String args[]) {
        List<String> names = new ArrayList<>();
        names.add("Ravi");
        names.add("Kumar");
        names.add("Raju");

        names.forEach(n -> System.out.println(n));
    }
}

// multiple statements in Lambda expr

@FunctionalInterface
interface Sayable3{
    String say(String message);
}
 class LambdaExpressionMultiStatemnts{
    public static void main(String[] args) {
        Sayable3 s3 = message ->
        {
            String s1 = "Hello";  // You can pass multiple statements in lambda expression
            String s2 = message + s1;
            return s2;
        };
        System.out.println(s3.say("Say"));
        }
    }


//Lambda Expression Example: Creating Thread
//You can use lambda expression to run thread. In the following example, we are implementing run method by using lambda expression.

 class LambdaExpressionThread{
    public static void main(String[] args) {

        //Thread Example without lambda
        Runnable r1=new Runnable(){
            public void run(){
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();
        //Thread Example with lambda
       Runnable r2=() -> {
            System.out.println("Thread2 is running...");
        };

        //Runnable r3 = LambdaExpressioncllectios::println;
        Thread t2=new Thread(r2);
        t2.start();
    }
 }


//Lambda expression can be used in the collection framework. It provides efficient and concise way to iterate, filter and fetch data


class LambdaExpressioncllections {
    public static void println(Product product) {
        System.out.println(product.id + " " + product.name + " " +  product.price);
    }

    public static void main(String args[]) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Laptop", 30000f));
        list.add(new Product(2,"Tab", 20000f));
        list.add(new Product(3,"SmartPhone", 10000f));
        list.add(new Product(4,"BluetoothDevice", 5000f));
        list.add(new Product(5,"BluetoothDevice", 5000f));


        // Sorting  without Lambda Expressions
        System.out.println("Sorting on the basis of name... using comparable ");
        Collections.sort(list); // used comparable (natural sorting)

        list.forEach(n -> System.out.println(n.id + " " + n.name + " " + n.price));

        // Sorting with lambda expression

        Collections.sort(list, (o1, o2) -> (o1.price > o2.price? 1 : 0));
        System.out.println("Print  the sorted data using Lambda");
        list.forEach(LambdaExpressioncllections::println);

        // filter data using Lambda
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 5000);
        System.out.println("Get the filtered data");
        filtered_data.forEach(LambdaExpressioncllections::println);

    }
 }


