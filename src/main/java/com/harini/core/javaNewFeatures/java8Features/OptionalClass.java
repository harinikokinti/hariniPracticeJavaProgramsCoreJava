package com.harini.core.javaNewFeatures.java8Features;
/*
Optional Class
Java introduced a new class Optional in jdk8. It is a public final class and used to deal with NullPointerException in Java application.
You must import java.util package to use this class. It provides methods which are used to check the presence of value for particular variable.
 */


// Program without using Optional
//In the following example, we are not using Optional class. This program terminates abnormally and throws a nullPointerException.

import java.util.Optional;

class WithoutOptionalExample {
     public static void main(String[] args) {
         String[] x = new String[10];
         String lowerCaseString = x[5].toLowerCase();
         System.out.println(lowerCaseString);  // throws nullpointer exception
     }
 }


 // With Optional class
 public class OptionalClass {
     public static void main(String[] args) {
         String[] x = new String[10];
         Optional<String> checkNull = Optional.ofNullable(x[5]);
         if(checkNull.isPresent())
            {
                String lowerCaseString = x[5].toLowerCase();
                System.out.println(lowerCaseString);
         }else
             System.out.println("String Value not present");

     }
 }
  // methods in optionsl class
  class OptionalExample {
      public static void main(String[] args) {
          String[] str = new String[10];
          str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
          // It returns an empty instance of Optional class
          Optional<String> empty = Optional.empty();
          System.out.println(empty);
          // It returns a non-empty Optional
          Optional<String> value = Optional.of(str[5]);
          // If value is present, it returns an Optional otherwise returns an empty Optional
          System.out.println("Filtered value: "+value.filter((s)->s.equals("Abc")));
          System.out.println("Filtered value: "+value.filter((s)->s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
          // It returns value of an Optional. if value is not present, it throws an NoSuchElementException
          System.out.println("Getting value: "+value.get());
          // It returns hashCode of the value
          System.out.println("Getting hashCode: "+value.hashCode());
          // It returns true if value is present, otherwise false
          System.out.println("Is value present: "+value.isPresent());
          // It returns non-empty Optional if value is present, otherwise returns an empty Optional
          System.out.println("Nullable Optional: "+Optional.ofNullable(str[5]));
          // It returns value if available, otherwise returns specified value,
          System.out.println("orElse: "+value.orElse("Value is not present"));
          System.out.println("orElse: "+empty.orElse("Value is not present"));
          value.ifPresent(System.out::println);   // printing value by using method reference
      }
  }

