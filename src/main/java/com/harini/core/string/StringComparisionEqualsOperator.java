package com.harini.core.string;

public class StringComparisionEqualsOperator {
    public static void main(String[] args) {

        String str1 = "Siva";
        String str2 = "Siva";

        String str3 = new String("Siva");
        String str4 = "Parvathi";

        System.out.println(str1 == str2); // true , it compares the references, since str1 is a literal, str2 also refers the same "Siva" object in the String constant pool
        System.out.println(str1 == str3); // false, since == compares the reference, str1 and str3 has diff reference str3 is another instance created in heap
        System.out.println(str1 == str4); // false

        String str5 = "SIVA";
        System.out.println(str1 == str5);  // false
    }
}
