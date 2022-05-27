package com.harini.core.collections;
/*
--Comparable interface  (Method: compareTo(Object), Collections.sort(List list) ) - natural ordering
---------------------------------------------------------------------------------------------------------------------------------------------
Java Comparable interface is used to order the objects of the user-defined class.
This interface is found in java.lang package and contains only one method named compareTo(Object).
It provides a single sorting sequence only, i.e., you can sort the elements on the basis of single data member only.
For example, it may be rollno, name, age or anything else.

--compareTo(Object obj) method
public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
positive integer, if the current object is greater than the specified object.
negative integer, if the current object is less than the specified object.
zero, if the current object is equal to the specified object.

--We can sort the elements of:
String objects
Wrapper class objects
User-defined class objects

--Collections class
Collections class provides static methods for sorting the elements of collections.
If collection elements are of Set or Map, we can use TreeSet or TreeMap.
However, we cannot sort the elements of List.
Collections class provides methods for sorting the elements of List type elements.
public void sort(List list): It is used to sort the elements of List. List elements must be of the Comparable type.

Note:
1. String class and Wrapper classes implement the Comparable interface by default.
So if you store the objects of string or wrapper classes in a list, set or map, it will be Comparable by default.
2. If you use objects of user defined class, the class must implement Comparable interface to sort the collection(list or set or map)
Ex: Set<Employee> ,Employee must implement comparable

 */
import java.util.*;

// Example 1

public class ComparableInterface {
    public static void main(String args[]) {
        // Sorting the integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(67);
        numbers.add(23);
        Collections.sort(numbers);
        for(int i : numbers) {
            System.out.println(i);
        }

        // Sorting the strings
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Apple");
        strings.add("Zebra");
        Collections.sort(strings);  // Since String class implement the comparble interface by default, no need to implement again
        for(String i : strings) {
            System.out.println(i);
        }
    }
}

// Example 2

class EmployeeNew implements Comparable<EmployeeNew> { // EmployeeNew is user defined and hence implements comparable interface
    int id;
    String name;
    Float salary;

    EmployeeNew(int id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    Float getSalary() {
        return salary;
    }


    @Override
    public int compareTo(EmployeeNew e) {
     return this.getId() - e.getId();  // sorting based on id
/*
      if(this.id == e.id)  return 0;  // sorting based on id  2nd method
        else if(this.id > e.id) return 1;
        else return -1;  */

        /* if(this.salary == e.salary)  return 0;  //  sorting based on salary
        else if(this.salary > e.salary) return 1;
        else return -1; */

         //return this.name.compareTo(e.name);  // // sorting based on name

        // To print in reverse
        /*
        if(this.id == e.id)  return 0;  // sorting based on id
        else if(this.id > e.id) return -1;
        else return 1;
         */

    }
}

class TestComparableInterface {
    public static void main(String args[]) {

        // sorting with List ( it needs Collections.sort()
        List<EmployeeNew> employees = new ArrayList<>();
        employees.add(new EmployeeNew(1,"Ravi", 45000f));
        employees.add(new EmployeeNew(3,"Ayesha", 35000f));
        employees.add(new EmployeeNew(2,"Sukumar", 75000f));
        Collections.sort(employees);

        System.out.println("Print the Employee List");
        for(EmployeeNew e : employees) {
            System.out.println(e.id + " " + e.name + " " + e.salary);
        }

        // Sorting with Set
       // Set<EmployeeNew> employeeSet = new HashSet<>();  // will not sort
        Set<EmployeeNew> employeeSet = new LinkedHashSet<>();  // should sort , here not sorting, doubt
        //Set<EmployeeNew> employeeSet = new TreeSet<>();  // sorts the set
        employeeSet.add(new EmployeeNew(1,"Ravi", 45000f));
        employeeSet.add(new EmployeeNew(3,"Ayesha", 35000f));
        employeeSet.add(new EmployeeNew(2,"Sukumar", 75000f));
        employeeSet.add(new EmployeeNew(4,"Sukumar", 75000f));

        System.out.println("Print the Employee Set");
        for(EmployeeNew e : employeeSet) {
            System.out.println(e.id + " " + e.name + " " + e.salary);
        }

    }

}


