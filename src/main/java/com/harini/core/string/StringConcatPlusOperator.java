package com.harini.core.string;

public class StringConcatPlusOperator {
    public static void main(String[] args) {

        String str1 = "Hello" + "World" ;
        System.out.println(str1); // HelloWorld

        String str2 = 10 + 20 + 30 + "Sum" + 40 + 50 + true;
        System.out.println(str2); // 60Sum4050true, once the string is called, the next concatenation will occur as strings only

        String str3 = 10 + 20 + "Hello" + 10 ;
        System.out.println(str3); //30Hello10

    }
}
