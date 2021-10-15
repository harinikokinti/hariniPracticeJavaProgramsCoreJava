package com.harini.core.collections;
/*
--Comparator interface  (Methods: compare(Object obj1,Object obj2), equals(Object element),  Collections.sort(List list, Comparator c) ) - multiple sorting sequences
---------------------------------------------------------------------------------------------------------------------------------------------
Java Comparator interface is used to order the objects of a user-defined class.
This interface is found in java.util package and contains 2 methods compare(Object obj1,Object obj2) and equals(Object element).
It provides multiple sorting sequences, i.e., you can sort the elements on the basis of any data member, for example, rollno, name, age or anything else.

--Methods of Java Comparator Interface
Method	                                        Description
public int compare(Object obj1, Object obj2)	It compares the first object with the second object.
public boolean equals(Object obj)	            It is used to compare the current object with the specified object.

--Collections class
Collections class provides static methods for sorting the elements of a collection.
If collection elements are of Set or Map, we can use TreeSet or TreeMap. However, we cannot sort the elements of List.
Collections class provides methods for sorting the elements of List type elements also.
void sort(List list, Comparator c): is used to sort the elements of List by the given Comparator.

*/
// Comparator Example
/*
Example of sorting the elements of List on the basis of age and name. In this example, we have created 4 java classes:
Student.java
AgeComparator.java
NameComparator.java
ComparatorInterface.java
 */

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

class StudentOld {
    int rollno;
    String name;
    int age;
    StudentOld(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }

}


class AgeComparator implements Comparator<StudentOld> {
    @Override
    public int compare(StudentOld o1, StudentOld o2) {
        if(o1.age == o2.age) return 0;
        else if(o1.age > o2.age) return 1;
        else return -1;
    }
}

class NameComparator implements Comparator<StudentOld> {
    @Override
    public int compare(StudentOld o1, StudentOld o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class ComparatorInterface {
    public static void main(String args[]) {
        List<StudentOld> studentList = new ArrayList<>();
        studentList.add(new StudentOld(101,"VijayOld",23));
        studentList.add(new StudentOld(106,"AjayOld",27));
        studentList.add(new StudentOld(105,"JaiOld",21));

        //Sorting based on Age
        System.out.println("Sorting based on Age");
        Collections.sort(studentList, new AgeComparator());
       for(StudentOld s: studentList) {
           System.out.println(s.rollno + " " + s.name + " " + s.age);
       }

       //soritng based on Name
        System.out.println("Sorting based on Name");
        Collections.sort(studentList, new NameComparator());
        for(StudentOld s: studentList) {
            System.out.println(s.rollno + " " + s.name + " " + s.age);
        }
    }
}

// Java 8 Comparator interface is a functional interface that contains only one abstract method.
// Now, we can use the Comparator interface as the assignment target for a lambda expression or method reference.
class Student {
    int rollno;
    String name;
    int age;
    Student() {}
    Student(int rollno,String name,int age){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class ComparatorFunctionalInterfaceExample {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101,"Ravi",33));
        studentList.add(new Student(106,"Kumar",36));
        studentList.add(new Student(105,"Raju",19));

        //Sorting based on Age
        System.out.println("Sorting based on Age");
        //Comparator<Student> studentComparator = (o1,o2) -> new AgeComparator().compare(o1,o2);
        Function<Student,Integer> keyExtractorAge = Student::getAge; // here getAge provides implementation(returns age) for apply method present in Function interface
        Comparator<Student> compareByAge = Comparator.comparing(keyExtractorAge);
        // Here comparing() method,  accepts a function that extracts a Comparable sort key from a type T, and returns a Comparator that compares by that sort key.
        Collections.sort(studentList,compareByAge);
        Consumer<List<Student>> printSortedListByAge = new Print()::printValues;
        printSortedListByAge.accept(studentList);

        //Sorting based on Name
        System.out.println("Sorting based on Name");
       Function<Student,String> keyExtractorName = Student::getName;
       Comparator<Student> compareByName = Comparator.comparing(keyExtractorName);
       Collections.sort(studentList,compareByName);
       Consumer<List<Student>> printSortedListByName = new Print()::printValues;
        printSortedListByName.accept(studentList);

        
    }
}

// Sorting the list with null elements using Comparator Functional Interface

class ComparatorFunctionalInterfaceNullCheck {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101, "Ravi", 33));
        studentList.add(new Student(106, null, 36));
        studentList.add(new Student(105, "Anil", 19));
        // Sort by name but with null elements must come first
        System.out.println("Considers null to be less than non-null");
        Function<Student, String> keyExtractorName = Student::getName;
        Comparator<String> keyComparator = Comparator.nullsFirst(String::compareTo);
        Comparator<Student> comparebyNameWithNullsFirst = Comparator.comparing(keyExtractorName, keyComparator);
        Collections.sort(studentList, comparebyNameWithNullsFirst);
        Consumer<List<Student>> printStudentsWithNullsFirst = new Print()::printValues; //  print the list
        printStudentsWithNullsFirst.accept(studentList);


        // Sort by name but with null elements must come last
        System.out.println("Considers null to be greater than non-null");
      //  Function<Student, String> keyExtractorName2 = Student::getName;
        Comparator<Student> comparebyNameWithNullsLast = Comparator.comparing(keyExtractorName, Comparator.nullsLast(String::compareTo));
        Collections.sort(studentList, comparebyNameWithNullsLast);
        Consumer<List<Student>> printStudentsWithNullsLast = new Print()::printValues; //  print the list
        printStudentsWithNullsLast.accept(studentList);


    }
}


class Print{
    public void printValues(List<Student> studentList){
        for(Student s : studentList) {
            System.out.println(s.rollno + " " + s.name + " " + s.age);
        }
    }
}
