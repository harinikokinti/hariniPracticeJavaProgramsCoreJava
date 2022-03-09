package com.harini.core.polymorphism;
/*
If a class has multiple methods having same name but different in parameters, it is known as Method Overloading.

--Advantage of method overloading
Method overloading increases the readability of the program.

--Different ways to overload the method
There are two ways to overload the method in java
1. By changing number of arguments
2. By changing the data type

--RULES
1. Must have same method name
2. Can have different argument lists or parameters with different data types
3. Can have different return types.Method Overloading is not possible just by changing the return type of the method alone
4. Have different access modifiers.You can vary the access levels in any direction.
5. Throw different checked or unchecked exceptions.
6. You can prevent a method from being overwritten by making it final, or static , but you cannot prevent a method from being overloaded.

 */

//Method Overloading: changing data type of arguments

class Calculation
{
    void add(int x,int y)
    {
        System.out.println("Addition of int values:" + (x+y));
    }
    void add(int x,float y){
       System.out.println("Addition of int and double values" + (x+y));
    }
}

public class MethodOverloading {
    public static void main(String args[]) {
        Calculation calculation = new Calculation();
        calculation.add(2,3);
        calculation.add(2,4.2f);
    }
}

//Method Overloading: changing no. of arguments

class Calculation2
{
    int add(int x,int y)
    {
       return 2;
        // System.out.println("Addition of int values:" + (x+y));
    }

    double  add(int x,int y, double z){
        return 3;
        //System.out.println("Addition of int and double values" + (x+y+z));
    }
}

 class MethodOverloadingWithNoOfAargument {
    public static void main(String args[]) {
        Calculation2 calculation2 = new Calculation2();
        System.out.println(calculation2.add(2,3));
        System.out.println(calculation2.add(2,4,3.2));
    }
}

//Why Method Overloading is not possible by changing the return type of method only?
//In java, method overloading is not possible by changing the return type of the method only because of ambiguity. Let's see how ambiguity may occur:
/*
class Adder{
    static int addition(int a,int b){return a+b;}
    static double addition(int a,int b){return a+b;}
}
class TestOverloading3{
    public static void main(String[] args){
        System.out.println(Adder.add(11,11));//ambiguity
    }}

 */



// Can we overload java main() method?
// Yes, by method overloading. You can have any number of main methods in a class by method overloading.
// But JVM calls main() method which receives string array as arguments only. Let's see the simple example:

class TestOverloading4{
    public static void main(String[] args){System.out.println("main with String[]");}
    public static void main(String args){System.out.println("main with String no array");}
    public static void main(){System.out.println("main without args");}
}

// Method Overloading and Type Promotion

/*
 If there is no matching datatype found, one datatype is promoted to another implicitly
byte-short-int-long-float-double
char-int-long-float-double


byte - 8 bits
short - 16 bits
int - 32 bits
long - 64 bits
float - 32 bits
double - 64 bits
char - 16 bits
boolean - 1 bit


-- Java performs type conversion when you perform an arithmetic operation with unlike data types.
For example, when you add an int and a  double, the result is a double.
In a similar way, when you pass an argument to a method, Java can promote one data type to another.
For example, If a method has a double parameter and you are passing in an integer, the compiler promotes an integer to a double.

One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.

 */
// Type Promotion 1
class TypePromotion1
{
    static void display(float x) { System.out.println("float value argument");}
    static void display(double x) { System.out.println("Double value argument");}

    public static void main(String args[]){
        TypePromotion1.display(2); //  here 2 is int and no match is found. so int is promoted to float
    }

}

// Type Promotion 2 gives compile time error
/*
class TypePromotion2
{
    static void display(short x) { System.out.println("float value argument");}
    static void display(byte x) { System.out.println("Double value argument");}

    public static void main(String args[]){
        TypePromotion2.display(2); //  here 2 is int and no match is found. so int is not depromoted to short and byte
        since  short and byte both are small size data types than int
    }

}
*/

// type Promotion 3  -  important for interview

class TypePromotion3
{
    public void display(int i)
    {
        System.out.println("Hello");
    }
    public void display(float f)
    {
        System.out.println("Java");
    }
    public static void main(String[] args)
    {
        TypePromotion3 t = new TypePromotion3();
        t.display(10);
        t.display(10.5f);
        t.display('a');
        t.display(10l); // it is 10L long value promoted to float
       // t.display(10.5); // its double value so it cannot be depromoted to given int and float values. Gives Compile time error.
    }
}







