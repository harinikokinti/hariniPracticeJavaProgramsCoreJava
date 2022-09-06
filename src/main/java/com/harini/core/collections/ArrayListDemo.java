package com.harini.core.collections;
/*
ArrayList -  not synchronised, faster random access , for frequent reads
Vector -  synchronized, thread safe
Iterator - the pointer moves only in 1 direction , forward
ListIterator  - the pointer can move forward and backward both directions
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Declare, instantiate, initialization array
        int n[] = new int[3];
        n[0] = 10;
        n[1] = 20;
        n[2] = 30;

        for(int i: n) {
           // System.out.println(i);
        }
    /* to add element into array, index is needed,   n[index] = 50;
       to update , idex is needed,   n[index] = 100;
       to search ,
       */

        //colleciton
        // List
        // ArrayList
        ArrayList list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List elements");
        for(Object item: list) {
            System.out.println(item);
        }
        // remove element
        list.remove(2);  // remove at the index
        System.out.println("AFter removal");
        for(Object item: list) {
            System.out.println(item);
        }

        // update element
        list.set(1,100);  // update at given index
        System.out.println("After updation");
        for(Object item: list) {
            System.out.println(item);
        }


        // ArrayList wth raw type

      List<Integer> list1 = new ArrayList();
      //  Collection<Integer> list1 = new ArrayList();
       // List<Integer> list1 = new Vector<>(); //ArrayList and Vector both same
        list1.add(100);
        list1.add(200);
        list1.add(300);
        list1.add(400);
        list1.add(500);
        System.out.println("Array List elements with generics");
        for(Object item: list1) {
            System.out.println(item);
        }
        // remove element
        list1.remove(2);  // remove at the index
        System.out.println("AFter removal");
        for(Object item: list1) {
            System.out.println(item);
        }

        // update element
        list1.set(1,1000);  // update at given index
        System.out.println("After updation");
        for(Object item: list1) {
            System.out.println(item);
        }

        System.out.println("Using Iterator"); // the pointer moves only in 1 direction , forward
        Iterator<Integer> itr = list1.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }


        System.out.println("Using ListIterator");  // the pointer can move forward and backward both directions
        ListIterator<Integer> itr2 =list1.listIterator();
        while(itr2.hasNext()) {
            System.out.println(itr2.next());  // 100, 1000, 400, 500
        }

        System.out.println("Print in reverse");
        while(itr2.hasPrevious()) {
            System.out.println(itr2.previous()); // 500, 400, 1000, 100
        }




    }
}
