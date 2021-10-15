package com.harini.core.javaNewFeatures.java8Features;
/*
--Method Parameter Reflection
Java provides a new feature in which you can get the names of formal parameters of any method or constructor.
The java.lang.reflect package contains all the required classes like Method and Parameter to work with parameter reflection.

--Method class
It provides information about single method on a class or interface. The reflected method may be a class method or an instance method.

-- Parameter class
Parameter class provides information about method parameters, including its name and modifiers.
It also provides an alternate means of obtaining attributes for the parameter.
 */

// Method Parameter Reflection Example


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Calculation{
    int addition(int a , int b)
    {
        return (a+b);
    }

    int multiplication(int a, int b) {
        return (a*b);
    }
}


class ParameterReflection {
    public static void main(String[] args) {
        // Creating object of a class
        Calculation calculate = new Calculation();
        // instantiating Class class
        Class cls = calculate.getClass();
        // Getting declared methods inside the Calculate class
        Method[] method = cls.getDeclaredMethods(); // It returns array of methods
        // Iterating method array
        for (Method method2 : method) {
            System.out.print(method2.getName() + " ");    // getting name of method
        // Getting parameters of each method
        Parameter parameter[] = method2.getParameters(); // It returns array of parameters
        // Iterating parameter array
        for (Parameter parameter2 : parameter) {
            System.out.print(""+parameter2.getParameterizedType() + " "); // returns type of parameter
            System.out.print(""+parameter2.getName() + " "); // returns parameter name
        }
        System.out.println();
    }
}
}


/*
Above code will produce the below output if you use -parameters flag to compile the Calculate.java file.
multiplication int a int b
addition int a int b
 */