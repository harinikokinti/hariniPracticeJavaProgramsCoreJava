package com.harini.core.javaNewFeatures.java4and5Features.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The question mark (?), represents the wildcard, stands for unknown type in generics.
Wildcards can be used in three ways −
    --Upper bound Wildcard − ? extends Type : to relax the restrictions on a variable.
    --Lower bound Wildcard − ? super Type.
    --Unbounded Wildcard − ? when any object can be used when a method can be implemented
                             using functionality provided in the Object class or When the code is independent of the type parameter

In order to decide which type of wildcard best suits the condition, let's first classify the type of parameters passed to a method as in and out parameter.
in variable − An in variable provides data to the code. For example, copy(src, dest). Here src acts as in variable being data to be copied.
out variable − An out variable holds data updated by the code. For example, copy(src, dest). Here dest acts as in variable having copied data.

Guidelines for Wildcards.
    --Upper bound wildcard − If a variable is of in category, use extends keyword with wildcard.
    --Lower bound wildcard − If a variable is of out category, use super keyword with wildcard.
    --Unbounded wildcard − If a variable can be accessed using Object class method then use an unbound wildcard.
    --No wildcard − If code is accessing variable in both in and out category then do not use wildcards.

 */

// UpperBound Example 1
class Animal { }
class Dog extends Animal {}
class StreetDog extends Dog {}
class Cat extends Animal{}
public class WildCards {
    public static void addAnimals(List<? extends Animal> dogsList) {
       for(Object dog : dogsList) {
            System.out.println(dog);
        }
    }
    public static void main(String args[]) {
        List<Animal> animals = new ArrayList<>();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        animals.add(dog1);
        animals.add(dog2);

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

       // animals.add(cat1); // CTerror since cat is not a child class of Animal
        // animals.add(cat2); // Ct error

        StreetDog streetDog1 = new StreetDog();
        StreetDog streetDog2 = new StreetDog();
        animals.add(streetDog1);
        animals.add(streetDog2);
        addAnimals(animals);

    }
}


// UpperBound Example 2

class UpperBoundWildCardExample {
    static void addData(List<? extends Number> dataList) { // Here ? is substituted with only the child classes of Number
        for (Object obj : dataList) {
            System.out.println(obj);
        }
    }
    public static void main(String args[]) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(Integer.valueOf(10));
        integerList.add(20);
        integerList.add(30);
        System.out.println("Integers");
        addData(integerList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(Double.valueOf(89.45));
        doubleList.add(34.6);
        doubleList.add(23.0);
        System.out.println("Double Values");
        addData(doubleList);

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
       // addData(dogList); // CT error since the wildcard is only the child classes of the class Number

        List<String> stringList = new ArrayList<>();
        stringList.add("Ravi");
        stringList.add("Kumar");
        //addData(stringList); // CT error since the wildcard is only the child classes of the class Number
    }
}

// LowerBound Example
 class LowerBoundExample {
    public static void addDog(List<? super Dog> dogList) { // The wildcard ? allows only the Parent class of the class Dog
        dogList.add(new StreetDog());
        System.out.println("Dog Added");
    }

    public static void main(String[] args) {
        List<Animal> animalList= new ArrayList<Animal>();
        List<Dog> dogList= new ArrayList<Dog>();
        List<StreetDog> streetDogList= new ArrayList<StreetDog>();
        List<Cat> catList= new ArrayList<Cat>();

        addDog(animalList);  //add list of super class Animal of Dog class
        addDog(dogList); //add list of Dog class
        //addDog(streetDogList); // CT error  cannot add list of subclass RedCat of Cat class
        //addDog(catList); // CT error  cannot add list of subclass Dog of Superclass Animal of Cat class

    }
}

// Unbounded wildcard Example

class UnboundedWildCardExample {
    static void addData(List<?> dataList) {
        for(Object obj : dataList) {
            System.out.println(obj);
        }
    }

    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(10,20,30);
        System.out.println("Integers");
        addData(integerList);

        List<Double> doubleList = Arrays.asList(56.67,34.2,12.5);
        System.out.println("Double Values");
        addData(doubleList);

        List<String> stringsList = Arrays.asList("RAvi", "Kumar");
        System.out.println("Strings");
        addData(stringsList);

        List<Dog> dogList = Arrays.asList(new Dog(), new Dog());
        System.out.println("Dogs");
        addData(dogList);
    }
}


// Real World Example of Wildcards Usage metioning all the above concepts
class GenericsTester {

    //Upper bound wildcard
    //in category
    public static void deleteCat(List<? extends Cat1> catList, Cat1 cat) {
        catList.remove(cat);
        System.out.println("Cat Removed");
    }

    //Lower bound wildcard
    //out category
    public static void addCat(List<? super RedCat> catList) {
        catList.add(new RedCat("Red Cat"));
        System.out.println("Cat Added");
    }

    //Unbounded wildcard
    //Using Object method toString()
    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }

    public static void main(String[] args) {

        List<Animal1> animalList= new ArrayList<Animal1>();
        List<RedCat> redCatList= new ArrayList<RedCat>();

        //add list of super class Animal of Cat class
        addCat(animalList);
        //add list of Cat class
        addCat(redCatList);
        addCat(redCatList);

        //print all animals
        printAll(animalList);
        printAll(redCatList);

        Cat1 cat = redCatList.get(0);
        //delete cat
        deleteCat(redCatList, cat);
        printAll(redCatList);
    }
}

class Animal1 {
    String name;
    Animal1(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Cat1 extends Animal1 {
    Cat1(String name) {
        super(name); //Invoking Parent class Constructor using super()
    }
}

class RedCat extends Cat1 {
    RedCat(String name) {
        super(name); //  Invoking Parent class Constructor using super()
    }
}

class Dog1 extends Animal1 {
    Dog1(String name) {
        super(name); // Invoking Parent class Constructor using super()
    }
}

// Difference Between  a wildcard bound and a type parameter bound?

/*
A wildcard can have only one bound, while a type parameter can have several bounds.
A wildcard can have a lower or an upper bound, while there is no such thing as a lower bound for a type parameter.
A wildcard can have only one bound, either a lower or an upper bound. A list of wildcard bounds is not permitted.
A type parameter, in constrast, can have several bounds, but there is no such thing as a lower bound for a type parameter.

-- EXAMPLE
Tt depends on what you need to do. You need to use the bounded type parameter if you wanted to do something like this:
        public <T extends Shape> void addIfPretty(List<T> shapes, T shape) {
                     if (shape.isPretty()) {
                            shapes.add(shape);
                                    }
                                }
For maximum flexibility, use wildcard types on input parameters that represent producers or consumers. […]
PECS stands for producer-extends, consumer-super .
Applying the PECS principle, we can now go back to our addIfPretty example and make it more flexible by writing the following:
        public <T extends Shape> void addIfPretty(List<? super T> list, T shape) { … }
Now we can addIfPretty, say, a Circle, to a List<Object>.
This is obviously typesafe, and yet our original declaration was not flexible enough to allow it.



SUMMARY:
    --Do use bounded type parameters/wildcards, they increase flexibility of your API
    --If the type requires several parameters, you have no choice but to use bounded type parameter
    --if the type requires a lowerbound, you have no choice but to use bounded wildcard
    --"Producers" have upperbounds, "consumers" have lowerbounds
    --Do not use wildcard in return types

 */







