package com.harini.core.polymorphism;
/*
The final keyword in java is used to restrict the user.
Final can be:
variable, method, class, parameter
Final keyword
1. stop value change
2. stop method overriding
3. stop inheritance

--Java final variable
variable : The uninitialized final variable can be initilised in constructor only.
           The blank final variable can be static also which will be initialized in the static block only.

-- Java final Method
If you make any method as final, you cannot override it.

--Java final class
If you make any class as final, you cannot extend it.

-- Java final parameter
If you declare any parameter as final, you cannot change the value of it.

-- static blank final variable
A static final variable that is not initialized at the time of declaration is known as static blank final variable. It can be initialized only in static block.

QUESTIONS:
1. Is final method inherited?
Ans) Yes, final method is inherited but you cannot override it.
2.What is blank or uninitialized final variable?
A final variable that is not initialized at the time of declaration is known as blank final variable.
If you want to create a variable that is initialized at the time of creating object and once initialized may not be changed, it is useful.
For example PAN CARD number of an employee.
It can be initialized only in constructor.
3. Can we initialize blank final variable?
Yes, but only in constructor.
4. Can we declare a constructor final?
No, because constructor is never inherited.

 */

// Java final variable
class TestFinal {
    final int x ; // CT error if not initialised in constructor
    static  int y; // may or may not be initialised with a value. And may or may not be initialised in static block , it can be initilised in constructor also
    static final int z; //CT error if not initialised in static block

    TestFinal() {
        x = 20; //  final variables must be initialised only in constructors
        y = 70;
           }

    static {
        //y = 30; // it can be initialised here . no CT error
        z = 30;
    }

    void display() {
        System.out.println("x value " + x + " Y Value: " + y + " Z value: " + z);
    }

}
public class FinalKeyword {
    public static void main(String args[]) {
        TestFinal testFinal = new TestFinal();
        testFinal.display();
    }
}

//Java final method
class Bike{
    final void run(){System.out.println("Bike is running ");}
}

class Honda extends Bike{
   // void run(){System.out.println("running safely with 100kmph");} //  CT error

    public static void main(String args[]){
        Honda honda= new Honda();
        honda.run();
    }
}

// Java final class
final class Bike2{}

class Honda1 extends Bike{ //  CT error if given Bike2
   // void run(){System.out.println("running safely with 100kmph");}

    public static void main(String args[]){
        Honda1 honda= new Honda1();
        honda.run();
    }
}

// Java final parameter
/*
class Bike11{
    int cube(final int n){
        n=n+2;//can't be changed as n is final
      n*n*n;
    }
    public static void main(String args[]){
        Bike11 b=new Bike11();
        b.cube(5);
    }
}  */