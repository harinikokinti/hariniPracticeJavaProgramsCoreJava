package com.harini.core.collections.map;
/*
-- TreeMap
TreeMap class is a red-black tree based implementation. It provides an efficient means of storing key-value pairs in sorted order.

public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>, Cloneable, Serializable

Java TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class.
Java TreeMap contains only unique elements.
Java TreeMap cannot have a null key but can have multiple null values.
Java TreeMap is non synchronized.
Java TreeMap maintains ascending order.


--difference between HashMap and TreeMap?
HashMap	                                TreeMap
1) HashMap can contain one null key.	TreeMap cannot contain any null key.
2) HashMap maintains no order.	        TreeMap maintains order


-- Hashtable class
Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary class and implements the Map interface.

Points to remember
A Hashtable is an array of a list. Each list is known as a bucket. The position of the bucket is identified by calling the hashcode() method.
A Hashtable contains values based on the key.
Java Hashtable class contains unique elements.
Java Hashtable class doesn't allow null key or value.
Java Hashtable class is synchronized.
The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75.

-- Difference between HashMap and Hashtable
HashMap and Hashtable both are used to store data in key and value form. Both are using hashing technique to store unique keys.

But there are many differences between HashMap and Hashtable classes that are given below.

HashMap	                                                                    Hashtable
1) HashMap is non synchronized.                                              Hashtable is synchronized.It is thread-safe and can be shared with many threads.
It is not-thread safe and can't be shared between many threads
without proper synchronization code.
2) HashMap allows one null key and multiple null values.	                Hashtable doesn't allow any null key or value.
3) HashMap is a new class introduced in JDK 1.2.	                        Hashtable is a legacy class.
4) HashMap is fast.	                                                        Hashtable is slow.
5) We can make the HashMap as synchronized by calling this code
Map m = Collections.synchronizedMap(hashMap);	                            Hashtable is internally synchronized and can't be unsynchronized.
6) HashMap is traversed by Iterator.	                                    Hashtable is traversed by Enumerator and Iterator.
7) Iterator in HashMap is fail-fast.	                                    Enumerator in Hashtable is not fail-fast.
8) HashMap inherits AbstractMap class.	                                    Hashtable inherits Dictionary class.


 */
import java.util.*;
class TreeMap1{
    public static void main(String args[]){
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");

        for(Map.Entry m:map.entrySet()){  //  outputs the data in ascending order based on the key
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}

// HashTable
class Hashtable1{
    public static void main(String args[]){
        Hashtable<Integer,String> hm=new Hashtable<Integer,String>();

        hm.put(100,"Amit");
        hm.put(102,"Ravi");
        hm.put(101,"Vijay");
        hm.put(103,"Rahul");

        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
