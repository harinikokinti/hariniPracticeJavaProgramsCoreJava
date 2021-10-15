package com.harini.core.javaNewFeatures.java4and5Features.annotations;
/*
Annotation is a tag that represents the metadata i.e. attached with class, interface, methods or fields
to indicate some additional information which can be used by java compiler and JVM.
It is an alternative option for XML and Java marker interfaces.
1. Built in annotations
2. Custom Annotations

1. Built in annotations
    -- builtin annotations used in java code
        @Override
        @SuppressWarnings
        @Deprecated
    -- builtin annotations used in custom annotation
        @Target
        @Retention
        @Inherited
        @Documented

@Override : To assure that sub class method is overriding the parent class method.
             Sometimes, we does the silly mistake such as spelling mistakes etc.
             So, it is better to mark @Override annotation that provides assurity that method is overridden.
@SuppressWarnings : is used to suppress warnings issued by the compiler.

@Deprecated : It marks that this method is deprecated so compiler prints warning.
              It informs user that it may be removed in the future versions. So, it is better not to use such methods.

 */

import java.util.ArrayList;

// built in Annotations Example  [ @Override, @SuppressWarnings, @Deprecated
class Parent {
    void display(){ System.out.println("hello");}

}

class Subclass extends Parent {
    @Override
    void display() { System.out.println("hello in sub class");} // here if by mistake method name spelling is wrong we get CT error becoz of the annotation
    @Deprecated
    void notUseful () {System.out.println("This method will be removed in future"); }

    }

public class BuiltinAnnotations {
    @SuppressWarnings("Unchecked")
    public static void main(String args[]) {
        ArrayList list=new ArrayList(); //  we get warnings at compile time if the @SuppressWarnings annotation is removed since we are using non generic collection
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");

        for(Object obj:list)
            System.out.println(obj);


        Subclass subclass = new Subclass();
        subclass.notUseful(); // get warning in CT

    }
}
