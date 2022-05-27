package com.harini.core.string;
/*
-- String
-- COMPARE Strings using equals()
-- Swap strings
-- reverse string and ts words
-- palindrome
-- Convert int to String
String.valueOf(i)  or Integer.toString(i)
-- Convert String to int
Integer.ParseInt(str)  or Integer.valueOf(str)
 */

public class StringExamples { }

// Compare two Strings using equals()
// equals() method matches values of the strings, == operator matches object or reference of the strings
class StringsComparison{

    public static void main (String args[]) {

        String str1 = "xyz";  // stored in string constant pool
        String str2 = "abc";  // stored in string constant pool

        if(str1.equals(str2)) {   // can be compared with == sign also, since the strings are not objects
            System.out.println("Strings are not equal");
        }

        String str3 = new String("xyz");
        String str4 = new String("xyz");

        if(str3.equals(str4)) {  //  here str3, str4 can be compared only with equals() method  not with == sign
            System.out.println("Strings are  equal");
        }
    }
}


// Swap 2 strings without 3rd variable

class SwapStrings {
    public static void main (String args[]) {

        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Before Swap: " + str1 + " " + str2);

        str1 = str1 + str2;

        str2 = str1.substring(0,str1.length()-str2.length());
        str1 = str1.substring(str2.length(),str1.length());

        System.out.println("After Swap: " + str1 + " " + str2);

    }

}

// reversing the String

class ReverseString {
    public static void main(String args[]) {
        String str = "Hi All the Best";

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());  //  reverse the whole string


        String words[] = str.split("\\s");  //  reverse the words in the string
        for (String w : words) {
            StringBuilder sb2 = new StringBuilder(w);
            System.out.print(sb2.reverse() + " ");
        }
    }
}

// Check for String Palindrome

class Palindrome {
    public static void main(String args[]) {
        String str = "MADAM";
        StringBuilder sb = new StringBuilder(str);
        String str2 = sb.reverse().toString();
        if(str.equals(str2)) {
            System.out.println("Yes it is Palindrome");
        }
        else
        System.out.println("No it is not Palindrome");


    }
}



