package com.harini.core.string;

public class StringSubstring {
    public static void main(String[] args) {
        String str1 = "Learn Java Course";

        System.out.println("Original String message:" + str1); //Learn Java Course
        System.out.println("Substring starting from index 6:" + str1.substring(6)); //Java Course
        System.out.println("Substring starting from index 0 to 6:" + str1.substring(0,6)); //Learn

        String str = new String("Welcome home");
        System.out.println(str); //Welcome home
        System.out.println(str.substring(8)); //home

    }
}
