package com.harini.core.polymorphism;
/*
-- instanceof operator or type comparison operator :
To test whether the object is an instance of the specified type (class or subclass or interface).
It returns either true or false.If the variable is null , it returns false.
Ex:
Sample s =  new Sample();
System.out.println(s instanceof Sample);
o/p: true;

-- Downcasting
When Subclass type refers to the object of Parent class, it is known as downcasting.

1. If we perform downcasting by typecasting, ClassCastException is thrown at runtime.
Ex: NexonCar nexoncar = (NexonCar)new Car; //  Compiles successfully but ClassCastException is thrown at runtime
2. We can perform downcasting with or without instanceof operator

Usage:when we want to access specific behaviors of a subtype.
Here in the below example, if we want to get the subclass specific method (speed() ) ,
we check if there is an instance of a NexonCar object passed in, downcast it to the NexonCar type and invoke its specific method, speed().


 */
// Example of instanceof operator
class X {}
class Y extends X{}
public class InstanceOperator {
    public static void main(String args[]) {
        X x = new X();
        Y y = new Y();
        X s = null;
        System.out.println(x instanceof X);
        System.out.println(y instanceof X); // returns true since an object of subclass type is also the parent class type
        System.out.println(x instanceof Y); // false
        System.out.println(s instanceof X); // here it returns false for the null variable

    }
}

// Downcasting Realtime Example
class Car {
    void engine() { System.out.println("Basic Car Engine");}
}
 class NexonCar extends Car {
     void engine() { System.out.println("Nexon Car Engine");} // overriden method
     void speed() {System.out.println("Nexon Car Speed");}
 }
class TestCar {
    public static void main(String args[]) {
        Car car = new NexonCar(); // upcasting
        if(car instanceof NexonCar) {  // check if there is an instance of a NexonCar object passed in,
            NexonCar nexonCar = (NexonCar) car; // downcast it to the NexonCar type
            car.engine();
            ((NexonCar) car).speed(); // get NexonCar specific method
        }
    }
}



// Example 2 for downcasting
class Happy{
    void laugh() { System.out.println("Happy Laughing"); }
}
class Happychild extends Happy {
    void laugh() {System.out.println("Happy child Overriden method"); }
    void displayChild()  {System.out.println("Happy child display method"); }
}


class TestDownCasting {
    public static void main(String args[]){
       Happy happy =  new Happychild(); // Upcasting
        if(happy instanceof Happychild){
            Happychild happychild = (Happychild)happy; // Downcasting
            System.out.println("ok downcasting performed");
            happy.laugh();
            ((Happychild) happy).displayChild();
        }
    }
}
