package com.harini.core.collections;
/*
--List Interface
    to maintain the ordered collection
    It can have the duplicate elements also
    Using ListIterator, we can iterate the list in forward and backward directions.
    The implementation classes of List interface are ArrayList, LinkedList, Stack and Vector.

--Important methods:
    add(),get(),set()

--Convert array to List
    String array[] = {"Java","Python","PHP","C++"};
    List<String> list=new ArrayList<String>();
    for(String lang:array){
    list.add(lang);
    }

--convert List to array
     String[] array = fruitList.toArray(new String[fruitList.size()]);

--Sort a List
    Collections.sort(list);

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListInterface {

    public static void main(String args[]) {
        String arr[] = {"Java","Python","PHP","C++"};

        //convert array to list
        List<String> list = new ArrayList<>();
        for(String s : arr) {
            list.add(s);
        }

        System.out.println(list);
        System.out.println("Print using Streams");
        list.stream().forEach(p->System.out.println( p));  // print using streams and forEach

        //convert list to array

        String arr2[] = new String[4];
        list.toArray(arr2);

        System.out.println("Print using Streams");
        Arrays.stream(arr2).forEach(p->System.out.println( p));  // print using streams and forEach

        System.out.println();
        for (String a: arr2 ) {
            System.out.println(a);
        }

        // sorting the list
        Collections.sort(list);
        System.out.println(list);

        // print the size of the list
        System.out.println(list.size());


    }
}


