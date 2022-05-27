package com.harini.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OverrideEqualsHashcode {
}
/*
-- Why to override equals() and hashcode()?  Not to allow duplicate objects inserted into the has based collections
https://www.techiedelight.com/why-override-equals-and-hashcode-methods-java/#:~:text=Overriding%20only%20equals()%20method,on%20each%20of%20the%20two

The hash based collecitons like HashSet, HashMap, HashTable are organized like a sequence of buckets,
and the hash code value of an object is used
 1. to determine the bucket to store the object.
 2. to search the object position during retrieval , along with hshcode, equals() also used to search

Note:
1. equal objects must have equal hash codes but not vice versa.
2. if two objects are equal according to the equals(Object) method,
then calling the hashCode method on each of the two objects must produce the same integer result.
3. hascode() returns  distinct integers for distinct objects

-- equals() Contract :
The equals() method must be:
reflexive: an object must equal itself
symmetric: x.equals(y) must return the same result as y.equals(x)
transitive: if x.equals(y) and y.equals(z), then also x.equals(z)
consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)


 */


class Student {
    int studentID;
    String studentName;

    Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName  = studentName;
    }
// Override equals() method to compare the object memebers' values
  public  boolean equals(Object obj) {

      if(! (obj instanceof Student))  // check if the obj s is an instance of Student
          return false;

      Student s =  (Student)obj;  // cast the obj to the Student object

      if(this.studentID != s.studentID)
          return false;
      if(! this.studentName.equals(s.studentName)) //  here equals() is String class method
          return false;

        return true;  // if both the above conditions are not false, then returns true

    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName);
    }
}


class TestStudent {
    public static void main(String args[]) {
        Student s1 = new Student(101, "Hari");
        Student s2 = new Student(101, "Hari");

        if (s1.equals(s2))   // it compares the objects with their location and memory not with the values
        {
            System.out.println("The objects are same");
        } else
            System.out.println("The objects are not same");


        Map<Student, String> map = new HashMap<Student, String>();
        map.put(s1, "boy");
        map.put(s2, "boy");

        System.out.println(map.size()); // if hashcode() is not overrriden, the size is 2, allows duplicates




    }
}

