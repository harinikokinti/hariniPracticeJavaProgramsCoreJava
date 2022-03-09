package com.harini.core.javaNewFeatures.java4and5Features.annotations;
/*
2. Custom annotations:
Custom annotations or Java User-defined annotations are easy to create and use. The @interface element is used to declare an annotation.

Points to remember for java custom annotation signature
    Method should not have any throws clauses
    Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
    Method should not have any parameter.
    We should attach @ just before interface keyword to define annotation.
    It may assign a default value to the method.

How built-in annotaions are used in real scenario?
    In real scenario, java programmer only need to apply annotation. He/She doesn't need to create and access annotation.
    Creating and Accessing annotation is performed by the implementation provider.
    On behalf of the annotation, java compiler or JVM performs some additional operations.

Types of Annotation
    1. Marker Annotation: An annotation that has no method, is called marker annotation.
                           Example: @interface MyAnnotation{}
                          The @Override and @Deprecated are marker annotations.
    2. Single-Value Annotation: An annotation that has one method, is called single-value annotation
                            Example: @interface MyAnnotation{
                                     int value() default 0;  //  we can give default values also
                                     }
                           How to apply Single-Value Annotation:
                           @Myannotation(value=10)

    3. Multi-Value Annotation: An annotation that has more than one method, is called Multi-Value annotation.
                            Example: @interface Myannotation{
                                     int value1();
                                     String value2();
                                     String value3();
                                     }
                            How to apply Multi-Value Annotation
                            @MyAnnnotation(value1=20,value2="Hi" ,value3="Welcome")


Builtin annotations used in custom annotation are
        @Target
        @Retention
        @Inherited
        @Documented

 1. @Target : @Target tag is used to specify at which type the annotation is used.
 java.lang.annotations.ElementType enum declares many constants to specify the type of element where annotation is to be applied such as TYPE, METHOD, FIELD etc.

 Element Types	                Where the annotation can be applied
TYPE	                        class, interface or enumeration
FIELD	                        fields
METHOD	                        methods
CONSTRUCTOR	                    constructors
LOCAL_VARIABLE	                local variables
ANNOTATION_TYPE	                annotation type
PARAMETER	                    parameter

Example to specify annotation for a class
@Target(ElementType.TYPE)
@interface MyAnnotation{
int value1;
String value2;
}

Example to specify annotation for a class,method,field
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@interface MyAnnotation {
int value1;
String value2;
}

2. @Retention
@Retention annotation is used to specify to what level annotation will be available.

RetentionPolicy	                Availability
RetentionPolicy.SOURCE	        refers to the source code, discarded during compilation. It will not be available in the compiled class.
RetentionPolicy.CLASS	        refers to the .class file, available to java compiler but not to JVM . It is included in the class file.
RetentionPolicy.RUNTIME	        refers to the runtime, available to java compiler and JVM .

Example to specify the RetentionPolicy
@RETENTION(RetentionPolicy.RUNTIME)
@TARGET(ElementTypeTYPE)
@interface MyAnnotation
{
int valye1;
String value2;
}

3. @Inherited
By default, annotations are not inherited to subclasses. The @Inherited annotation marks the annotation to be inherited to subclasses.

4. @Documented
The @Documented Marks the annotation for inclusion in the documentation.


-- Reflection API is a new feature in java used to fethc the features or values of the object

 */

// Custom Annotation Creating, applying and Accessing  at METHOD level Example 1


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.lang.annotation.*;

//Creating annotation

// meta annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)   //  creating the annotation at method level
@interface MyAnnotation {
    int value();
}

class Sample {
    @MyAnnotation(value = 10)  // accessing annotation
  public    void display() {  // this method must be public
        System.out.println("Hello annotation at method");
    }
}


public class CustomAnnotations
{
    public static void main(String args[]) throws Exception {
        Sample sample = new Sample();
        sample.display();
        Class c = sample.getClass(); // using Reflection API feature, fetch the classname
        Method m = c.getMethod("display");
        MyAnnotation myannotation = m.getAnnotation(MyAnnotation.class);
        System.out.println("Value is: " + myannotation.value());

    }
}


// Custom Annotation Creating, applying and Accessing  at CLASS level Example 2
// not gt ouptut  ERROR

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  //  creating the annotation at class level
@interface MyAnnotation2 {
    int value();
}

@MyAnnotation2(value = 100)  // accessing annotation
class Sample2 {
    public void display() {  // this method must be public
        System.out.println("Hello annotation at class ");
    }
}


 class CustomAnnotations2
{
    public static void main(String args[]) throws Exception {
        Sample2 sample2 = new Sample2();
        sample2.display();
        Class c = sample2.getClass(); // using Reflection API feature, fetch the classname
        Method m = c.getMethod("display");
        Integer value = m.getAnnotation(MyAnnotation2.class).value();
       // Annotation annotation = c.getAnnotation(MyAnnotation2.class);
      // Integer value =    annotation.annotationType().getAnnotation(MyAnnotation2.class).value();
       System.out.println(value);
    }
}