package com.harini.core.javaNewFeatures.java4and5Features.generics;
/*
--Generic class
A class that can refer to any type
Here, we are using the T type parameter to create the generic class of specific type.
It can refer to any type (like String, Integer, and Employee).

syntax:
public class ClassName<T> {
        private T t;
}

T − The generic type parameter passed to generic class. It can take any Object.
t − Instance of generic type T.


--Type Parameters
The type parameters naming conventions are important to learn generics thoroughly. The common type parameters are as follows:
T - Type        to represent first generic type parameter.
S - Type        to represent second generic type parameter.
U - Type        to represent third generic type parameter.
E - Element     used by Java Collections framework.
K - Key         to represent parameter type of key of a map.
V - Value       to represent parameter type of value of a map.
N - Number      to represent numbers.


-- Raw Type
A Raw type is an object of the generic class or interface with no type arguments passed during its creation.





 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericClassExamples {
}


// Generic class example

class MyGenericClass<T> {
    T obj;
    void add(T obj) {
        this.obj = obj;
    }
    T get(){
        return obj;
    }
}

class GenericClass {
    public static void main(String args[]) {
        MyGenericClass<Integer> intObj = new MyGenericClass<>();
        intObj.add(12); // we can add only integer objects
        //intObject.add("hi"); // CT error
        System.out.println(intObj.get());

        MyGenericClass<String> stringObj = new MyGenericClass<>();
        stringObj.add("Hello"); // can add only string objects
        System.out.println(stringObj.get());

    }
}




// Example to explain type parameters usage

class Box<T,S> {   //  Genericc class with  multiple type parameters
    T t;
    S s;
    void setValues(T t,S s) {
        this.t = t;
        this.s = s;
    }

    T getFirstGeneric() {
        return t;
    }

    S getSecondGeneric() {
        return s;
    }
}


class Pair<K,V> {  // Generic class with key and value type parameters
    Map<K,V> map = new HashMap<K,V>();
    void addKeyValue(K key, V value) {
        map.put(key,value);
    }
    V getValue(K key) {
        return map.get(key);
    }
}

class CustomList<E> { //  Generic class with ype parameter having collection
    List<E>  list  = new ArrayList<>();

    void addValuestoList(E value) {
        list.add(value);
    }

    E getValuea(int index) {
     return list.get(index);
    }
}


class TestGenerics {
    public static void main(String args[]) {
        Box<Integer,Character> box = new Box<>();
        box.setValues(10,'A');
        System.out.println(box.getFirstGeneric() + " " + box.getSecondGeneric());

       Pair<Integer,String> pair = new Pair<>();
       pair.addKeyValue(101,"Ravi");
        pair.addKeyValue(102,"RaviKumar");
       System.out.println(pair.getValue(102));

       CustomList<Box> customList = new CustomList<>();
       customList.addValuestoList(box);
       System.out.println(customList.getValuea(0).getFirstGeneric());


    }
}

// Example with Raw types

class RawTypeExample {
    public static void main(String args[]) {
        Box<Integer,String> box = new Box<>();
        box.setValues(20,"Ravi");
        Box rawBox = new Box();
        rawBox = box;  //No warning
        rawBox.setValues(30,"Kumar"); //Warning for unchecked invocation to setValues()
        System.out.println(rawBox.getFirstGeneric() + " " + rawBox.getSecondGeneric());
        box = rawBox; //Warning for unchecked conversion
        System.out.println(box.getFirstGeneric());

    }
}