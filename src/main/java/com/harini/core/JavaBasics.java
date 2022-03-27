package com.harini.core;
/*
JAVA uses the Just-in-time (JIT) interpreter along with the compiler for the program execution.


-- DIFFERENCE BETWEEN JVM, JRE, JDK
JVM (Java Virtual ?Machine) It is a abstract machine. It is a specification that provides runtime environment in which java bytecode (.class files)
are executed.
JRE (Java Runtime Environment): It is a set of class libraries used by JVM to execute the code
JDK (Java Development Kit) it is a tool used to compile, document java programs. It contains set of spi s(class libraries) along with
 tools(java, javac) It includes JRE .

JAVA VARIABLES:
A variable is a container which holds the value while the Java program is executed
There are three types of variables in Java:

local variable : declared inside the body of the method. Cannot be declared as static
instance variable : declared inside the class but outside the body of the method. not declared as static.
static variable : A variable which is declared as static is called static variable. It cannot be local.
                  You can create a single copy of static variable and share among all the instances of the class.
                  Memory allocation for static variable happens only once when the class is loaded in the memory.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

MEMORY ALLOCATION:
1. STACK Memory:
Local Variables or Stack variables and Method invocations live on the STACK memory.
But if there is any object reference variable (instance variable) inside a method, it gets allocated on the HEAP memory
2. HEAP Memory:OR Garbage Collectible Heap area
All Instance variables live on the HEAP, even inside a method body, it gets allocated on the HEAP not on the STACK
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

DATA TYPES:
There are two types of data types in Java:
1. Primitive data types: There are 8 primitive data types include boolean, char, byte, short, int, long, float and double.
2. Non-primitive data types: The non-primitive data types include Classes, Interfaces, and Arrays.

Data Type	    Default Value	Default size   VALUE RANGE
boolean	            false	    1 bit
char	            '\u0000'	2 byte (16 bits)         Its value-range lies between '\u0000' (or 0) to '\uffff' (or 65,535 inclusive).
byte	            0	        1 byte (8 bits)         -128 to 127
short	            0	        2 byte (16 bits)         -32,768 to 32,767
int	                0	        4 byte (32 bits)        - 2,147,483,648 (-2^31) to 2,147,483,647 (2^31 -1)
long	            0L	        8 byte (64 bits)         -9,223,372,036,854,775,808(-2^63) to 9,223,372,036,854,775,807(2^63 -1)
float	            0.0f	    4 byte (32 bits)        The float data type is a single-precision 32-bit IEEE 754 floating point.Its value range is unlimited.
double	            0.0d        8 byte (64 bits)         The double data type is a double-precision 64-bit IEEE 754 floating point. Its value range is unlimited.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ACCESS MODIFIERS
There are two types of modifiers in Java: access modifiers and non-access modifiers.
ACCESS MODIFIERS: private, protected, public,default
NON ACCESS MODIFIERS:static, final, abstract,synchronized, native, volatile, transient etc.

-- Understanding Java Access Modifiers
Access Modifier	Within class	Within package	Outside package by subclass only	Outside package
Private	            Y	            N	            N	                            N
Default	            Y	            Y	            N	                            N
Protected	        Y	            Y	            Y	                            N
Public	            Y	            Y	            Y	                            Y
Note:Here default is more restrictive than protected. If you don't use any modifier, it is treated as default by default
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- TYPE CASTING
Convert a value from one data type to another data type is known as type casting.
The automatic conversion is done by the compiler and manual conversion performed by the programmer.
Types:
1. Widening Casting (automatically) - converting a smaller type to a larger type size.
                                      byte -> short -> char -> int -> long -> float -> double.
                                      Ex: int x = 10;
                                          long y = x ;  //automatically converts the integer type into long type
                                          float z = y; //automatically converts the long type into float type

2. Narrowing Casting (manually) - converting a larger type to a smaller size type.
                                   double -> float -> long -> int -> char -> short -> byte.
                                   Ex: double d = 123.66;
                                       long l = (long)d; //converting double data type into long data type
                                       int i = (int)l; //converting long data type into int data type

                                       output: d = 123.66
                                               l = 123
                                               i = 123
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--UPCASTING and DOWNCASTING
Upcasting:
If the reference variable of Parent class refers to the object of Child class, it is known as upcasting.
For upcasting, we can use the reference variable of class type or an interface type
class A{}
class B extends A{}
A a=new B();//upcasting

DownCasting:
When Subclass type refers to the object of Parent class, it is known as downcasting.

1. If we perform downcasting by typecasting, ClassCastException is thrown at runtime.
Ex: NexonCar nexoncar = (NexonCar)new Car; //  Compiles successfully but ClassCastException is thrown at runtime
2. We can perform downcasting with or without instanceof operator

Usage:when we want to access specific behaviors of a subtype.
Here in the below example, if we want to get the subclass specific method (speed() ) ,
we check if there is an instance of a NexonCar object passed in, downcast it to the NexonCar type and invoke its specific method, speed().
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
OBJECT CLASS:
The Object class is the parent class of all the classes in java by default.
The Object class is beneficial if you want to refer any object whose type you don't know.
Notice that parent class reference variable can refer the child class object, know as upcasting.

The Object class provides some common behaviors to all the objects such as object can be compared, object can be cloned, object can be notified etc.

Let's take an example, there is getObject() method that returns an object but it can be of any type like Employee,Student etc, w
e can use Object class reference to refer that object. For example:

Object obj=getObject();//we don't know what object will be returned from this method


-- Methods of Object class:
public final Class getClass()
public int hashCode()
public boolean equals(Object obj)
protected Object clone() throws CloneNotSupportedException
public String toString()

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Object Cloning
The object cloning is a way to create exact copy of an object. The clone() method of Object class is used to clone an object.
The java.lang.Cloneable interface must be implemented by the class whose object clone we want to create.
If we don't implement Cloneable interface, clone() method generates CloneNotSupportedException.

The clone() method is defined in the Object class.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Wrapper classes
The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.

Since J2SE 5.0, autoboxing and unboxing feature convert primitives into objects and objects into primitives automatically.
 The automatic conversion of primitive into an object is known as autoboxing and vice-versa unboxing.

 Use of Wrapper classes:
 Change the value in Method:
 Serialization
 Synchronization
 java.util package:
 Collection Framework

 Primitive Type	Wrapper class
boolean	        Boolean
char	        Character
byte	        Byte
short	        Short
int	            Integer
long	        Long
float	        Float
double	        Double

Example of Autoboxing:
int a=20;
Integer i=Integer.valueOf(a);//converting int into Integer explicitly
Integer j=a;//autoboxing, now compiler will write Integer.valueOf(a) internally

Example of Unboxing:
Integer a=new Integer(3);
int i=a.intValue();//converting Integer to int explicitly
int j=a;//unboxing, now compiler will write a.intValue() internally




 */

public class JavaBasics {

}
