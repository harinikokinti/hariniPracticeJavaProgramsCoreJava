package com.harini.core.string;
/*
compareTo() method return a positive number, negative number or 0
         if s1 > s2 return positive number
         if s1 < s2 return negative number
         if s1==s2 return 0
compareTo() inturn checks the value of the string object references or literals, and calculates the integer
equals() and compareTo()  have little bit logic inside the classes, character comparision
 */
public class StringComparisionCompareToMethod {
    public static void main(String[] args) {
        String str1 = "Siva";
        String str2 = "Siva";

        String str3 = new String("Siva");
        String str4 = "Parvathi";

        System.out.println(str1.compareTo(str2)); // returns 0
        System.out.println(str1.compareTo(str3)); // returns 0 , though str1 == str3 , it checks the value of the strings,
                                // equals() and compareTo()  have little bit logic inside the classes, character comparision
        System.out.println(str1.compareTo(str4)); // returns 3

        String s1="hello";
        String s2="hello";
        String s3="meklo";
        String s4="hemlo";
        String s5="flag";
        System.out.println(s1.compareTo(s2));//0 because both are equal
        System.out.println(s1.compareTo(s3));//-5 because "h" is 5 times lower than "m"
        System.out.println(s1.compareTo(s4));//-1 because "l" is 1 times lower than "m"
        System.out.println(s1.compareTo(s5));//2 because "h" is 2 times greater than "f"

        /*
        While comparing with empty string, the method returns the length of the string
        if 1st string is empty, the method returns negative
        if 2nd string is empty, the method retuns positve


         */
        String s6 = "";

        System.out.println(s1.compareTo(s6)); // 5  (length of s1 ="hello"
        System.out.println(s6.compareTo(s5)); // -4 (length of s5 = "flag"


    }
}
