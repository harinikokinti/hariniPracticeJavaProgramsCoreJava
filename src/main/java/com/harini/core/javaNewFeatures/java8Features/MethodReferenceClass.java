package com.harini.core.javaNewFeatures.java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/*
Method reference is used to refer method of functional interface.
A lambda expression is replaced with the method reference if it is used multiple times(more compact way).

--Types of Method References
1. Reference to a static method
    Syntax: ContainingClass::staticMethodName
2. Reference to an instance method
    Syntax: containingObject::instanceMethodName
3. Reference to a constructor -- can refer a constructor by using the new keyword.
    Syntax: ClassName::new



 */
// Reference to a static method Example 1
interface Sayable1 {
    void say();
}
public class MethodReferenceClass {
    static void print(){
        System.out.println("This is a static method called by Lambda Expr with static Method Reference ");
    }
    public static void main(String args[]) {
        // Lambda expr without Method Reference
        Sayable1 s = ()-> {System.out.println("Lambda Expr Without Method Reference"); };
        s.say();
        // Lambda expr with Method Reference
        Sayable1 s1 = MethodReferenceClass::print;
        s1.say();
    }
}

// Reference to an instance method
class Sample {
    void message() { System.out.println("Hi This is an Instance Method");}
}

class MethodReferenceInstanceMethod {
    public static void main(String args[] ) {
        Sample sample = new Sample();
        Sayable1 s2 = sample::message; // Referring non-static method using reference
        s2.say(); // calling interface
        Sayable1 s3 = new Sample()::message;  // Referring non-static method using anonymous object
        s3.say();

    }

}

// Reference to a constructor
class Sample1 {
    Sample1(){
        System.out.println("This is a constructor");
    }
}

class MethodReferenceConstructor {
    public static void main(String args[] ) {
        Sayable1 s1 = Sample1::new; // refer constructor using new keyword
        s1.say();
    }

}


// Iterating by passing method reference
class IterateByMethodReference {
    public static void main(String args[] ) {
        List<String>  strings = new ArrayList<>();
        strings.add("Hi");
        strings.add("welcome");
        strings.add("India");
        strings.forEach(s -> System.out.println(s)); //  Iterate using Lambda
        strings.forEach(System.out::println); // Iterate using method reference
    }

}









