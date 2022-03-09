package com.harini.core.collections;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.*;

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
List	                                                            Set
1. The List is an ordered sequence.	                                1. The Set is an unordered sequence.
2. List allows duplicate elements	                                2. Set doesn’t allow duplicate elements.
3. Elements by their position can be accessed, index based.         3. Position access to elements is not allowed, not index based.
4. Multiple null elements can be stored.	                        4. Null element can store only once.
5. List implementations are ArrayList, LinkedList, Vector, Stack	5. Set implementations are HashSet, LinkedHashSet.

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
class SetExample {
    public static void main(String args[]) {
        Set<String> set = new HashSet<>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ajay");

        // Traverse the SET
        System.out.println("Traverse using for loop");
        for(String s: set) {
            System.out.println(s);
        }

        System.out.println("Traverse using while loop " );
        Iterator itr = set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("Traverse using forEach " );
        set.forEach(p->System.out.println(p));

        System.out.println("Get particular element from the SET .  Here get String Ajay" );
        System.out.println("Method 1: convert to Array " );
        String[] arraySet = new String[set.size()];
        set.toArray(arraySet);
       // String[] arraySet = set.toArray(new String[set.size()]);
        System.out.println("The element is : " + arraySet[1]);

        System.out.println("Method 2: Using for loop " );
        int currentIndex = 0;
        int desiredIndex = 2;
        for(String s: set)
        {
            if(currentIndex == desiredIndex) {
                System.out.println("The element is : " + s);
            }
            currentIndex++;
        }

        System.out.println("Method 1: convert to ArrayList " );
        ArrayList<String> list = new ArrayList<>(set);  // convert list to set
        System.out.println("The element is : " + list.get(0));

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
        System.out.println("Traversing element through Iterator in descending order");
        System.out.println(set.descendingSet());
    }
}


