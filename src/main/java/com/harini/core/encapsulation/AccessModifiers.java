package com.harini.core.encapsulation;
import com.harini.core.classExamples.NormalClass;
import com.harini.core.constructorExamples.ConstructorChaining;
/*
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



 */

// private
class Sample1 {
    private int data=40;
    private void msg(){System.out.println("Hello java");}
}

public class AccessModifiers {

    public static void main(String args[]) {
        Sample1 sample1 = new Sample1();
   //    System.out.println(sample1.data); // CT error
     //   sample1.msg(); // CT Error
    }
}


// default

 class DefaultAccessModifier {
    public static void main(String args[]) {
        PackageClass packageClass = new PackageClass(); // can access the class within the same package
        System.out.println(packageClass.getClass());

     //   Calculation calculation = new Calculation(); //  CT error
       // calculation.addition(20,40); // CT error
        // Here Calculation class is not public in the different package [classExamples], hence CT error
        // default provides more accessibility than private. But, it is more restrictive than protected, and public.

    }
}

// protected
//The protected access modifier is accessible within package and outside the package but through inheritance only
// The protected access modifier can be applied on the data member, method and constructor. It can't be applied on the class.
// It provides more accessibility than the default modifer.

class Sample extends NormalClass {
    public static void main(String args[]) {
        Sample sample = new Sample();
        sample.addition(30,50); // here it can access the class NormalClass through inheritance and cann access the protected method
        //sample.multiply(7,5); // CT error since the method multiply is default
    }

}

// public
//The public access modifier is accessible everywhere. It has the widest scope among all other modifiers.

class Sample2 {
    public static void main(String args[]) {
        ConstructorChaining constructorChaining = new ConstructorChaining(); // can access any class from anywhere since it is public
        System.out.println(constructorChaining.getClass());
    }
}

// Access Modifiers with Method Overriding --  gives compile time error

class A
{
    protected void msg(){System.out.println("Hello java");}
}
class B extends A {
  // void msg(){System.out.println("Hello java");} //  compile time error since the default access specifier is more restrictive then protected
    public void msg() {System.out.println("Hello java");}
    public static void main(String args[]){
        B obj=new B();
        obj.msg();
    }
}
