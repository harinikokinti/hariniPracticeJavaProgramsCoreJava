package com.harini.core.collections.arrayListLinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class ProgramsOnArrayList {
}

// 1. sorting an array in Ascending and Descending orders
class SortArrrayAscendingDescending {
    public static void main(String args[])
    {
//creating an object of ArrayList class
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(55);
        list.add(34);
        list.add(98);
        list.add(67);
        list.add(39);
        list.add(76);
        list.add(81);
//printing ArrayList before sorting
        System.out.println("ArrayList Before Sorting:");
        for(int marks: list)
        {
            System.out.println(marks);
        }
//sorting ArrayList in ascending order
        Collections.sort(list);
//printing ArrayList after sorting
        System.out.println("ArrayList After Sorting:Ascending");
        for(int marks: list)
        {
            System.out.println(marks);
        }
//sorting ArrayList in descending order
        Collections.sort(list, Collections.reverseOrder());
        //printing ArrayList after sorting
        System.out.println("ArrayList After Sorting DEscending:");
        for(int marks: list)
        {
            System.out.println(marks);
        }
    }
}

// 2. Difference between Array and ArrayList
/*
Array                                                ArrayList
Array is static in size.                                ArrayList is dynamic in size.
An array is a fixed-length data structure.	            ArrayList is a variable-length data structure. It can be resized itself when needed.
Must provide size while initializing                    Not mandatory
Fast operation because of the fixed sizze               The Resize operation slows down the ArrayList in performnace
An array can store both objects and primitives type.	We cannot store primitive type in ArrayList. It automatically converts primitive type to object.
Array can be multi-dimensional.                         ArrayList is always single-dimensional.

--Similarities
Array and ArrayList both are used for storing elements.
Array and ArrayList both can store null values.
They can have duplicate values.
They do not preserve the order of elements.
 */

/*
-- Difference between ArrayList and LinkedList
ArrayList	                                                                                LinkedList
1) ArrayList internally uses a dynamic array to store the elements.	            LinkedList internally uses a doubly linked list to store the elements.
2) Manipulation with ArrayList is slow because it internally uses an array.     Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.
If any element is removed from the array, all the bits are shifted in memory.
3) An ArrayList class can act as a list only because it implements List only.	LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
4) ArrayList is better for storing and accessing(searching) data.               LinkedList is better for manipulating(add/remove) data.


-- When to use ArrayList and LinkedList in Java
ArrayList is better to access data(search operation)  time complexity to access elements O(1)
LinkedList is better to manipulate(add and remove operations) data. time complexity to access elements O(n/2)

-- COMPARE ARRAYLISTS
There are following ways to compare two ArrayList in Java:
Java equals() method
Java removeAll() method
Java retainAll() method
Java ArrayList.contains() method
Java contentEquals() method
Java Stream interface  : System.out.print("Common elements: " +firstList.stream().filter(secondList::contains).collect(Collectors.toList()));

-- REVERSE ArrayList
  Collections.reverse(lIST);

-- convert ArrayList to Array AND Array to ArrayList
 System.out.println("Converting ArrayList to Array" );
 String[] item = fruitList.toArray(new String[fruitList.size()]);

System.out.println("Converting Array to ArrayList" );
List<String>l2 = new ArrayList<>();
l2 =  Arrays.asList(item);

 */
