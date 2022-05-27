package com.harini.core.collections;

import java.util.*;




/*
Set allows duplicates, no ordering
HashSet:   Uses Hash technique
LinkedHashSet: sorts the data
TreeSet: sorts the data, The  objects must implement Comparable
 */

public class SetExample2 {
    public static void main(String[] args) {
        // HashSet

        Set<String> countries = new HashSet<>();
        countries.add("India");
        countries.add("USA");
        countries.add("India");
        countries.add("Japan");
        countries.add("UK");
        countries.add(null);  // it allows null

        System.out.println("----- Hash Set----");
        for(String i : countries) {
            System.out.println(i);
        }

        // TreeSet
        Set<String>  countries2 = new TreeSet<>();
        countries2.add("India");
        countries2.add("USA");
        countries2.add("India");
        countries2.add("INDIA");
        countries2.add("Japan");
        countries2.add("UK");
        // countries2.add(null);  // treeset does not allow null, it throws nullpointerexception

        System.out.println("---- Tree Set---");
        for(String i : countries2) {
            System.out.println(i);  // sorted output
        }


        // Employee Set
        System.out.println("---Employee Set ------");
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee(1,"Ramu",21,"Dev","IT","India"));
        employees.add(new Employee(2,"Seetha",25,"Manager","IT","USA"));

        for(Employee e : employees) {
            System.out.println(e);  // it prints the employees but no order
        }


        System.out.println("---Employee LinkedHash Set & Tree Set ------");
        Set<Employee> employees2 = new LinkedHashSet<>();
       // Set<Employee> employees2 = new TreeSet<>();

        employees2.add(new Employee(1,"Ramu",21,"Dev","IT","India"));
        employees2.add(new Employee(2,"Seetha",25,"Manager","IT","USA"));

        for(Employee e : employees2) {
            System.out.println(e);  // it prints the employees in no order because of LinkedHashSet or Tree Set
        }

    }
}


// Example 2


 class TreeSetEx {

    public static void main(String[] args) {

        // Employees are sorted by age
        Comparator EMPLOYEE_SORT_BY_AGE = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    return ((Employee) o1).getAge() - ((Employee) o2).getAge();
                }
                return 0;
            }
        };

        Set employees = new TreeSet(EMPLOYEE_SORT_BY_AGE);

        System.out.println("Employees sorted based on age");

        employees.add(new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT"));
        employees.add(new Employee(101, "Mukesh", 25, "Male", "Developer", "IT"));
        employees.add(new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT"));
        employees.add(new Employee(103, "John", 28, "Male", "Developer", "IT"));
        employees.add(new Employee(104, "Mathew", 30, "Male", "Developer", "IT"));
        employees.add(new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT"));

        for (Object emp : employees) {
            System.out.println(emp);
        }
    }
}
