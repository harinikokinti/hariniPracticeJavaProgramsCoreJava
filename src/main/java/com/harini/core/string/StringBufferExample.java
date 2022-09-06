package com.harini.core.string;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
// append
        sb.append("World");
        System.out.println(sb); // HelloWorld   ,, it is mutable
// insert
        sb.insert(0, "Universe");
        System.out.println(sb); // UniverseHelloWorld
        // replace
        sb.replace(0,3, "Hiiiii");
        System.out.println(sb); // HiiiiiverseHelloWorld
        // delete
        sb.delete(0,5);
        System.out.println(sb); //iverseHelloWorld
        //reverse
        sb.reverse();
        System.out.println(sb); //dlroWolleHesrevi


    }
}
