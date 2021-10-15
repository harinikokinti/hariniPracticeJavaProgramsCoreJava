package com.harini.core.polymorphism;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
--Before JDK 5.0, it was not possible to override a method by changing the return type.
When we override a parent class method, the name, argument types and return type of the
overriding method in child class has to be exactly same as that of parent class method.
Overriding method was said to be invariant with respect to return type.

-- COVARIANT RETURN TYPE
Java 5.0 onwards it is possible to have different return type for a overriding method in child class,
but child’s return type should be sub-type of parent’s return type. Overriding method becomes variant with respect to return type.
That means the return types must be compatible

Co-variant return type is based on Liskov substitution principle ( Substitutability is a principle in object-oriented programming stating that,
in a computer program, if S is a subtype of T, then objects of type T may be replaced with objects of type S (i.e., an object of type T may be substituted
with any object of a subtype S)

 */

//Example program with different return types if return type in overridden method is sub-type

class A {}
class B extends A {}

class Base {
    A fun() {
        System.out.println("Base Class");
        return new A();
    }
}

class Subclass extends Base {
    B fun() {
        System.out.println("Child Class");
        return new B();
    }
}

class CovariantReturnType {
    public static void main(String args[]) {
        Base base  = new Base();
        base.fun();

        Subclass subclass = new Subclass();
        subclass.fun();
    }
}



// HackerRank Java- Covariant Return Types

class Flower {
    String whatsYourName(){return "I have many names and types";}
}

class Jasmine extends Flower{
    String  whatsYourName() {return "Jasmine";}
}

class Lily extends Flower{
    String  whatsYourName() {return "Lily";}
}



class Region {
    Flower yourNationalFlower() {return new Flower(); }
}


class WestBengal extends Region {
    Jasmine yourNationalFlower()
    {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    Lily yourNationalFlower() {
        return new Lily();
    }
}

class CovariantReturnType2  {
    public static void main(String args[]) {
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WB":
                region = new WestBengal();
                break;
            case "AP":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
        catch(Exception e) {}

    }

}