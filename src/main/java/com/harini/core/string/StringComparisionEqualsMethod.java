package com.harini.core.string;
/*
equals()  method compares the actual value or content present in the string variables


 */

public class StringComparisionEqualsMethod {
    public static void main(String[] args) {
        String str1 = "Siva";
        String str2 = "Siva";
        String str3 = new String("Siva");

        String str4 = "Parvathi";

        System.out.println(str1.equals(str2)); // true    compares the value
        System.out.println(str1.equals(str3)); // true    compares the value
        System.out.println(str1.equals(str4)); // false   compares the value

        String str5 = "SIVA";
        System.out.println(str1.equals(str5)); // false
        System.out.println(str1.equalsIgnoreCase(str5)); // true
    }
}




