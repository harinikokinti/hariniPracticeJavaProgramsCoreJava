package com.harini.core.collections;

import java.util.TreeSet;

/*
-- HashSet:
HashSet class is used to create a collection that uses a hash table for storage. no duplicates, no order, allows null
ITERABLE <-- COLLECTION <-- SET <-- AbstractSet <-- HashSet
    HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
    HashSet stores the elements by using a mechanism called hashing.
    HashSet contains unique elements only.
    HashSet allows null value.
    HashSet class is non synchronized.
    HashSet is the best approach for search operations.
    The initial default capacity of HashSet is 16, and the load factor is 0.75.

-- Difference between List and Set
A list can contain duplicate elements whereas Set contains unique elements only.

-- LinkedHashSet:
    LinkedHashSet class is a Hashtable and Linked list implementation of the set interface.
ITERABLE <-- COLLECTION <-- SET <-- AbstractSet <-- HashSet <-- LinkedHashSet

-- TreeSet:
TreeSet class implements the Set interface that uses a tree for storage. no duplicates, no null, by default ascending order
ITERABLE <-- COLLECTION <-- SET <-- SORTEDSET <-- NAVIGABLESET <-- TreeSet
    Java TreeSet class contains unique elements only like HashSet.
    Java TreeSet class access and retrieval times are quiet fast.
    Java TreeSet class doesn't allow null element.
    Java TreeSet class is non synchronized.
    Java TreeSet class maintains ascending order.


 */
public class SetHashSetHashLinkedSetTreeSet {
}


// example of traversing elements in descending order.
class TreeSet1 {
    public static void main(String args[]) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ajay");
        System.out.println("Traversing element through Iterator in descending order");
        System.out.println(set.descendingSet());
    }
}

// an example to retrieve and remove the First and Last Value.
class TreeSet2{
    public static void main(String args[]){
        TreeSet<Integer> set=new TreeSet<Integer>();
        set.add(24);
        set.add(66);
        set.add(12);
        set.add(15);
        System.out.println("First Value: "+set.pollFirst());
        System.out.println("Last Value: "+set.pollLast());
    }
}
