package com.harini.core.string;
/*
-- There are two ways we can create a string object
1. by using String literal
2. by new keyword

1. string literal
using double quotes we can create string
String str = "Hello";

Each time you create a string literal, the JVM check the string constant pool(resides on metaspace). if the string already exist in the pool
a reference to the pool instance is returned. if the string does not exist in the pool, new string instance is created and placed
in the pool

-- why java uses the concept of String literal|?
to make java memory efficient (because no new object are created if it exist already in the string constant pool)

2. by new keyword
String str = new String("Hello")
JVM will create a new string in normal heap memory and the literal hello will be placed in the string constant pool
the variable str will refer to the object in the heap
 */

public class StringExample {
    public static void main(String[] args) {

        String str1 = "Hello";  // creating string using string literal
        char c1[] = {'H', 'E', 'L', 'L', 'O'};

        String str2 = new String(c1); // converting char array to string
        String str3 = new String("Hello"); // creating java string using new keyword

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }
}
