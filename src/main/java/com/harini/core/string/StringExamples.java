package com.harini.core.string;

public class StringExamples {

    public static void main (String args[]) {

        String str1 = "xyz";
        String str2 = "abc";

        if(str1.equals(str2)) {   // can be compared with == sign also, since the strigns are not objects
            System.out.println("Strings are not equal");
        }

        String str3 = new String("xyz");
        String str4 = new String("xyz");

        if(str3.equals(str4)) {  //  here str3, str4 can be compared only with equals() method  not with == sign
            System.out.println("Strings are  equal");
        }
    }
}
