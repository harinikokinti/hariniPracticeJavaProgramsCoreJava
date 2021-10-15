package com.harini.core.javaNewFeatures.java8Features;
/*
An Interface that contains exactly one abstract method is known as functional interface.
It can have any number of default, static methods but can contain only one abstract method.
It can also declare methods of object class.
Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
A functional interface can extend a non-functional interface.If not it becomes an invalid functional interface

-- Predefined-Functional Interfaces
Java provides predefined functional interfaces to deal with functional programming by using lambda and method references.

Predefined Functional Interfaces:

INTERFACE	                                DESCRIPTION
BiConsumer<T,U>	It represents an operation that accepts two input arguments and returns no result.
Consumer<T>	It represents an operation that accepts a single argument and returns no result.
Function<T,R>	It represents a function that accepts one argument and returns a result.
Predicate<T>	It represents a predicate (boolean-valued function) of one argument.
BiFunction<T,U,R>	It represents a function that accepts two arguments and returns a a result.
BinaryOperator<T>	It represents an operation upon two operands of the same data type. It returns a result of the same type as the operands.
BiPredicate<T,U>	It represents a predicate (boolean-valued function) of two arguments.
BooleanSupplier	It represents a supplier of boolean-valued results.
DoubleBinaryOperator	It represents an operation upon two double type operands and returns a double type value.
DoubleConsumer	It represents an operation that accepts a single double type argument and returns no result.
DoubleFunction<R>	It represents a function that accepts a double type argument and produces a result.
DoublePredicate	It represents a predicate (boolean-valued function) of one double type argument.
DoubleSupplier	It represents a supplier of double type results.
DoubleToIntFunction	It represents a function that accepts a double type argument and produces an int type result.
DoubleToLongFunction	It represents a function that accepts a double type argument and produces a long type result.
DoubleUnaryOperator	It represents an operation on a single double type operand that produces a double type result.
IntBinaryOperator	It represents an operation upon two int type operands and returns an int type result.
IntConsumer	It represents an operation that accepts a single integer argument and returns no result.
IntFunction<R>	It represents a function that accepts an integer argument and returns a result.
IntPredicate	It represents a predicate (boolean-valued function) of one integer argument.
IntSupplier	It represents a supplier of integer type.
IntToDoubleFunction	It represents a function that accepts an integer argument and returns a double.
IntToLongFunction	It represents a function that accepts an integer argument and returns a long.
IntUnaryOperator	It represents an operation on a single integer operand that produces an integer result.
LongBinaryOperator	It represents an operation upon two long type operands and returns a long type result.
LongConsumer	It represents an operation that accepts a single long type argument and returns no result.
LongFunction<R>	It represents a function that accepts a long type argument and returns a result.
LongPredicate	It represents a predicate (boolean-valued function) of one long type argument.
LongSupplier	It represents a supplier of long type results.
LongToDoubleFunction	It represents a function that accepts a long type argument and returns a result of double type.
LongToIntFunction	It represents a function that accepts a long type argument and returns an integer result.
LongUnaryOperator	It represents an operation on a single long type operand that returns a long type result.
ObjDoubleConsumer<T>	It represents an operation that accepts an object and a double argument, and returns no result.
ObjIntConsumer<T>	It represents an operation that accepts an object and an integer argument. It does not return result.
ObjLongConsumer<T>	It represents an operation that accepts an object and a long argument, it returns no result.
Supplier<T>	It represents a supplier of results.
ToDoubleBiFunction<T,U>	It represents a function that accepts two arguments and produces a double type result.
ToDoubleFunction<T>	It represents a function that returns a double type result.
ToIntBiFunction<T,U>	It represents a function that accepts two arguments and returns an integer.
ToIntFunction<T>	It represents a function that returns an integer.
ToLongBiFunction<T,U>	It represents a function that accepts two arguments and returns a result of long type.
ToLongFunction<T>	It represents a function that returns a result of long type.
UnaryOperator<T>	It represents an operation on a single operand that returnsa a result of the same type as its operand.



 */
// Example 1 : Functional Interface

import java.util.*;
import java.util.function.*;

@FunctionalInterface
interface SayableNew {
    void say();
    // it can have Object class methods
    int hashCode();
    String toString();
    boolean equals(Object obj);
    // can have dafault methods
    default void defaultMethod() {System.out.println(" DEFAULT method body of functional interface");}
    static void staticMethod() {System.out.println("Static method body of functional interface");}

}
public class FunctionalInterfaces {
    public static void main(String args[]) {
        SayableNew sn = () -> { System.out.println("Expression to print a functional interface info"); };
            sn.say();
            sn.defaultMethod();
            SayableNew.staticMethod();

    }
}
// Example 2
class PrintSomething implements SayableNew {
   public void say(){ System.out.println("Overriding the abstract method of functional interface");
    }
}
 class FunctionalInterfaceExample2 {
     public static void main(String args[]) {
         PrintSomething p = new PrintSomething(); // refering non static method with the class obj reference
         p.say();
         p.defaultMethod();
         SayableNew.staticMethod();
     }
 }


 // Example 3
interface doable {
    default void doIt() { System.out.println("Default method of Non functional interface ");}
 }

interface SayableNew1 extends doable {
    void say();
}

class PrintSomethingNew implements SayableNew1 {
    public void say(){ System.out.println("Overriding the abstract method of functional interface");
    }
}
class FunctionalInterfaceExample3 {
    public static void main(String args[]) {
        PrintSomethingNew p = new PrintSomethingNew();
        p.say();
        p.doIt();
    }
}

//  BiConsumer Interface : example 1
//Accepts two input arguments and does not return any result.
// It provides a functional method accept(Object, Object) to perform custom operations.
class BiConsumerInterfaceExample {
    static void showDetails(String name, Integer age){
        System.out.println(name+" "+age);
    }
    public static void main(String[] args) {
        // using method reference
        BiConsumer<String, Integer> biCon = (a,b) ->  showDetails(a,b); // Here, showDetails provides implementation for the method accept present in Biconsumer
        BiConsumer<String, Integer> biCon1 = BiConsumerInterfaceExample::showDetails; // replaced with method reference, h
        biCon.accept("Rama", 20);
        biCon.accept("Shyam", 25);
        // Using lambda expression
        BiConsumer<String, Integer> biCon2 = (name, age)->showDetails(name,age);
        biCon2.accept("Peter", 28);
    }
}

// BiConsumer Interface : example 2

class BiConsumerInterfaceExample2 {
    static void showDetails(Map<Integer,String> map, String mapName)
        {
            System.out.println( "Student Details");
            map.forEach((key,value) -> System.out.println(key + " " + value) );
        }
        public static void main(String args[]) {
        Map<Integer,String> studentMap = new HashMap<>();
        studentMap.put(101,"Ravi");
            studentMap.put(102,"Kumar");
            studentMap.put(103,"Raju");
            studentMap.put(104,"Seeetha");

       BiConsumer<Map<Integer,String>,String> bicon = (map,mapName) -> showDetails(map,mapName);
            BiConsumer<Map<Integer,String>,String> bicon2 = BiConsumerInterfaceExample2::showDetails;
            bicon2.accept(studentMap,"Student");

    }
}


 // Consumer interface
// It is a functional interface defined in java.util.function package.
// It contains an abstract accept() and a default andThen() method.
// It can be used as the assignment target for a lambda expression or method reference.
//The Consumer Interface accepts a single argument and does not return any result.
// Example 1
class ConsumerInterfaceExample1 {
    static void printName(String name) {
        System.out.println("The Student name is : " + name);
    }
    public static void main(String args[]) {
     //   Consumer<String> consumer = (name) -> printName(name);
        Consumer<String> consumer = ConsumerInterfaceExample1::printName; // here printName provides implementation for accept method present in Consumer interface
        consumer.accept("RaviKumar");
    }
}
// Example 2
class ConsumerInterfaceExample2 {
    static void printNumbers(List<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(numbersList.get(i));
        }
    }
    public static void main(String args[]) {
        Consumer<List<Integer>> consumer = ConsumerInterfaceExample2::printNumbers;
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(4);
        consumer.accept(numbersList);
    }
}

//  Function Interface Example
//It is a functional interface.
// It is used to refer method by specifying type of parameter.
// It returns a result back to the referred function.


class FunctionInterfaceExample {
    static String printName(String name) {
        return "The student name is: " + name;
    }
    public static void main(String args[]) {
        //   Consumer<String> consumer = (name) -> printName(name);
        Function<String,String> fun = FunctionInterfaceExample::printName; // here printName provides implementation for apply method present in Function interface
        String name =  fun.apply("Ravikumar");
        System.out.println(name);
    }
}


//  Function Interface Example 2

class FunctionInterfaceExample1 {
    static int addList(List<Integer> integersList) {
        int sum = 0;
        for(Integer i : integersList){
            sum = sum +i;
        }
        return sum;

    }
    public static void main(String args[]) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(20);
        integerList.add(56);
        integerList.add(45);
        integerList.add(70);
        Function<List<Integer>, Integer> fun = FunctionInterfaceExample1::addList;
        int result = fun.apply(integerList);
        System.out.println("the sum of the numbers is : " + result);
    }
}

//  Function Interface Example 3
class Boy{
    String name;
    int age;
    Boy(){}

    Boy(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNewboyAge(int age){
        return age;
    }
}

class TestBoy{
    public static void main(String args[]) {
        Function<Integer,Integer> getBoyAge2 = new Boy()::getNewboyAge;
        System.out.println(getBoyAge2.apply(24));

        Function<Boy,Integer> getBoyAge = Boy::getAge;   // no need to give Boy reference and also getAge() shall not pass any argument for apply method
        System.out.println(getBoyAge.apply(new Boy("Kumar",17)));

    }

}
// Predicate Interface
// It is a functional interface which represents a predicate (boolean-valued function) of one argument.
// It always return a boolean value true or false
// It is defined in the java.util.function package and contains test() a functional method.
// boolean test(T t)	It evaluates this predicate on the given argument
// It is used when passing conditions in a filter etc.,
class PredicateInterfaceExample {
    public static void main(String args[]) {
        Predicate<Integer> pr = age -> age > 18;
       System.out.println(pr.test(10));
    }
}

// Example 2

class Calculate {
    int age;
    boolean testAge(int age){
        if(age > 18) return true;
        else return false;
    }
}

class PredicateInterfaceExample2 {
    public static void main(String args[]) {
        Predicate<Integer> pr = new Calculate()::testAge;
       System.out.println(pr.test(23));
    }
}

// BiFunction Onterface
//Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.
/*
interface BiFunction<T, U, R> {
     * Applies this function to the given arguments.
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
R apply(T t, U u);
 */

class BiFunctionExample {
    static int addition(int a, int b)
    {
       return  a+b;
    }
    public static void main(String args[] ) {
       // BiFunction<Integer,Integer,Integer> bifun = (a,b) ->a+b; // Lambda expre
        BiFunction<Integer,Integer,Integer> bifun2 = BiFunctionExample::addition;
        int result =  bifun2.apply(400,500);
        System.out.println(result);
    }

}



