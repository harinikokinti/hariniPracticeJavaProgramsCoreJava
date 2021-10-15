package com.harini.core.javaNewFeatures.java4and5Features.generics;
/*
Generics force the java programmer to store a specific type of objects.
Java Generic methods and generic classes enable programmers to specify,
with a single method declaration, a set of related methods, or
with a single class declaration, a set of related types, respectively.

Almost all reference types can be generic.
This includes classes, interfaces, nested (static) classes, nested interfaces, inner (non-static) classes, and local classes.
The enum types, anonymous inner classes and exception class types cannot be generic:

Advantages:
1) Type-safety: We can hold only a single type of objects in generics. It doesn?t allow to store other objects.
                Example:
                List list = new ArrayList();
                list.add(10);
                list.add("10");
                with Generics, you need to specify which type of objects you are storing
                List<Integer> list = new ArrayList<Integer>();
                list.add(10);
                list.add("10"); // CT error
2) Type casting is not required: There is no need to typecast the object.
                List list = new ArrayList();
                list.add("Hello");
                String s = (String)list.get(0); //  here type casting is required
                List<String> list = new ArrayList<String>();
                list.add("Hello");
                String s = list.get(0); // no need to type cast

3) Compile-Time Checking: It makes the code stable by detecting the bugs at compile time.
                List<String> list = new ArrayList<String>();
                list.add("hello");
                list.add(32);//Compile Time Error

Syntac for Generics:
ClasssorInterace<Type>



 */
// Generic Example using ArrayList

import java.util.*;
import java.util.Iterator;

public class GenericExample {
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<String>();
        list.add("rahul");
        list.add("jai");
//list.add(32);//compile time error

        String s=list.get(1);//type casting is not required
        System.out.println("element is: "+s);

        Iterator<String> itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

// Example of Java Generics using Map

 class GenericExampleMap {
    public static void main(String args[]) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        // Traversing the map  method 1
        Iterator<Integer> itrKeys = map.keySet().iterator();
        Iterator<String> itrValues = map.values().iterator();
        while(itrValues.hasNext()) {
            System.out.println(itrKeys.next() +  " " + itrValues.next());
        }

        // Traversing the map method2 using EntrySet
        Iterator<Map.Entry<Integer,String>> itr = map.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry entry =itr.next(); // no need to type cast
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}










