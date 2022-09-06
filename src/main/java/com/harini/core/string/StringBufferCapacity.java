package com.harini.core.string;

public class StringBufferCapacity {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity()); // 16
        sb.append("World");
        System.out.println(sb.capacity()); // 16, since the appending string is small, no change in the capacity
        sb.append("Welcome Welcome Welcome");
        System.out.println(sb.capacity()); // 34 , since the string is big, it changes te capacity
    }
}

