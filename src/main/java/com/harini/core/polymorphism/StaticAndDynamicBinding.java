package com.harini.core.polymorphism;
/*
BINDING:
Binding is a mechanism of creating link between method call and method actual implementation(method body).
As per the polymorphism concept in Java , object can have many different forms. Object forms can be resolved at compile time and run time.

--There are two types of binding
1. Static Binding or Early Binding or Compile time binding : The type of object is determined at Compile time.
                                                            If there is any private, final or static method in a class, there is static binding.
2. Dynamic Binding or Late Binding or Run time Binding :  The type of the object is determined at Run time


 Key                       Static Binding                                                           Dynamic Binding
 Basic                  It is resolved at compile time                                              It is resolved at run time
 Resolve mechanism      static binding use type of the class and fields                             Dynamic binding uses object to resolve binding
 Example                Overloading is an example of static binding                                 Method overriding is the example of Dynamic binding
 Type of Methods        private, final and static methods and variables uses static binding         Virtual methods use dynamic binding

 */

// Example of static binding
class Doggy {
    private void eat() {
        System.out.println("dog is eating...");
    } //  If there is any private, final or static method in a class, there is static binding.

    public static void main(String args[]) {
        Doggy d1 = new Doggy();
        d1.eat();
    }
}




//Example of dynamic binding
//Here, the object type cannot be determined by the compiler, because the instance of Dog is also an instance of Animal.
// So compiler doesn't know its type, only its base type.
class AnimalInDB {
    void eating() {
        System.out.println("animal is eating...");
    }
}

class DogInDB extends AnimalInDB {
    void eating() {
        System.out.println("dog is eating...");
    }

}

public class StaticAndDynamicBinding {

    public static void main(String args[]) {
        AnimalInDB a = new DogInDB();
        a.eating();
    }
}