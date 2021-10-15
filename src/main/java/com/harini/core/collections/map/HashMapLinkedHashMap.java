package com.harini.core.collections.map;

import java.util.Map;

/*
-- Hashing
It is the process of converting an object into an integer value. The integer value helps in indexing and faster searches.

--HashMap:
Java HashMap contains values based on the key.
Java HashMap contains only unique keys.
Java HashMap may have one null key and multiple null values.
Java HashMap is non synchronized.
Java HashMap maintains no order.
The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

HashMap uses a technique called Hashing. It implements the map interface. It stores the data in the pair of Key and Value.
HashMap contains an array of the nodes, and the node is represented as a class.
It uses an array and LinkedList data structure internally for storing Key and Value.

-- Difference between HashSet and HashMap
HashSet contains only values whereas HashMap contains an entry(key and value).

--
equals(): It checks the equality of two objects. It compares the Key, whether they are equal or not.
          It is a method of the Object class. It can be overridden. If you override the equals() method,
          then it is mandatory to override the hashCode() method.
hashCode(): This is the method of the object class. It returns the memory reference of the object in integer form.
            The value received from the method is used as the bucket number. The bucket number is the address of the element inside the map.
            Hash code of null Key is 0.
Buckets: Array of the node is called buckets. Each node has a data structure like a LinkedList. More than one node can share the same bucket.
         It may be different in capacity.


-- LinkedHashMap
LinkedHashMap class is Hashtable and Linked list implementation of the Map interface, with predictable iteration order.
It inherits HashMap class and implements the Map interface.
 */
public class HashMapLinkedHashMap { }

// HashMap Example
 class HashMap {
    public static void main(String args[]) {
        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "Mango");  //Put elements in Map
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(4, "Grapes");

        System.out.println("Iterating Hashmap...");
        for(Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
