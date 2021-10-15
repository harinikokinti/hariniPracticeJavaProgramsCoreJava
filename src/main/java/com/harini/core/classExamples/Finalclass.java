package com.harini.core.classExamples;

/*

The final keyword in java is used to restrict the user. for security purpose.
final can be a variable, method, class, parameter.

final variabe:
-------------

1. If you make any variable as final, you cannot change the value of final variable(It will be constant).
2. A final variable that is not initialized at the time of declaration is known as blank final variable or uninitialized final variable.
3. We can initialize blank final variable only in constructor.
4. A static final variable that is not initialized at the time of declaration is known as static blank final variable.
   It can be initialized only in static block.

final method:
-------------

1. final method cannot be overriden, but can be inherited.

final class:
------------
A class declared as final cannot be iherited by any subclass

final parameter:
---------------

cannot change the value of the parameter


Constructors cannot be declared as final , because by default, constructors are not inherited (only invoked using super keyword in subclass).
So no need to declare them as final


Example : Wrapper Classes like String,Integer,Float are declared final , no one can override these.
 */

public final class Finalclass {

    void run(){
        System.out.println("I cannot be overriden");
    }

}
/*  throws error
 class FinalClassDemo extends Finalclass {
 } */

 class test {
     public static void main(String args[]) {
         Finalclass childObject = new Finalclass();
         childObject.run();
     }

}
