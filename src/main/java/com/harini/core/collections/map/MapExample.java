package com.harini.core.collections.map;
/*
-- Map interface:
A map contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. A Map contains unique keys.
A Map is useful if you have to search, update or delete elements on the basis of a key.

MAP <-- SORTEDMAP <-- TreeMap
MAP <-- HasMap <-- LinkedHashMap

--Map.Entry Interface
Entry is the subinterface of Map.
It can be accessed it by Map.Entry name.
It returns a collection-view of the map, whose elements are of this class.
It provides methods getKey(), getValue() to get key and value.

 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Employee
{
  protected   int empID;
    protected String empName;

    Employee(int empID, String empName)
    {
        this.empID = empID;
        this.empName = empName;
    }

}

public class MapExample {
    public static void main(String args[]) {

// 1 way to traverse the map
        System.out.println("Get map values having Employee details");
        Map<Integer,Employee> map = new HashMap<>();
        map.put(1, new Employee(1, "Ravi"));
        map.put(2, new Employee(2, "Anuskha"));

        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()) {
            Integer i = itr.next();
            Employee emp = map.get(i);
            System.out.println(emp.empID + " " + emp.empName);
        }



// 2nd way to traverse the map
        System.out.println("Get map values with direct data");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1,"A");
        map2.put(2,"B");

    Iterator itrValues = map2.values().iterator();
        Iterator itrKeys = map2.keySet().iterator();


    while(itrValues.hasNext()) {
        System.out.println(itrKeys.next() +  " " + itrValues.next());
    }

    }
}

// Using Map entry interface
class mapUsingMapentry {
    public static void main(String args[]) {
        System.out.println("Get map values using Map.Entry interface");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1,"A");
        map2.put(2,"B");

        for(Map.Entry m : map2.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("Get map values using Map.Entry interface for Employee");
        Map<Integer,Employee> mapNew = new HashMap<>();
        mapNew.put(1, new Employee(1, "Ravi"));
        mapNew.put(2, new Employee(2, "Anuskha"));

        Iterator<Map.Entry<Integer,Employee>> itr = mapNew.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Employee> entry = itr.next();  // it gets the current row with key and pair value for each iteration
            System.out.println(entry.getKey() + " " + entry.getValue().empID + " " + entry.getValue().empName);
        }
        // 2nd way

        System.out.println("Get map values using Map.Entry interface for Employee 2nd way");

        for(Map.Entry<Integer,Employee> entry:mapNew.entrySet()) {
            int key = entry.getKey();
            Employee e = entry.getValue();
            System.out.println(key + " " + e.empID + " " + e.empName);
        }

    }
}

// Using Stream

class mapUsingStream {
    public static void main(String args[]) {
        Map<Integer,String> mapData = new HashMap<>();
        mapData.put(1,"A");
        mapData.put(2,"B");
        mapData.entrySet().stream().forEach(System.out::println); // get map data both key and values

        mapData.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);  //  get only values

        System.out.println("Get map values using Streams for Employee");
        Map<Integer,Employee> mapemployees = new HashMap<>();
        mapemployees.put(1, new Employee(1, "Ravi"));
        mapemployees.put(2, new Employee(2, "Anuskha"));
     //   mapemployees.entrySet().stream().

    }

}


// Comparing by key ysing Stream
class mapUsingStreamComparingByKey {
    public static void main(String args[]) {
        Map<Integer, String> mapData2 = new HashMap<>();
        mapData2.put(100,"Amit");
        mapData2.put(103,"Vijay");
        mapData2.put(102,"Rahul");
        //Returns a Set view of the mappings contained in this map
        mapData2.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())  //   .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))   for descending order
                //Performs an action for each element of this stream
                .forEach(System.out::println);
    }
}

// Comparing by value ysing Stream
class mapUsingStreamComparingByVlalue {
    public static void main(String args[]) {
        Map<Integer, String> mapData2 = new HashMap<>();
        mapData2.put(100,"Zaheer");
        mapData2.put(103,"Vijay");
        mapData2.put(102,"Rahul");
        //Returns a Set view of the mappings contained in this map
        mapData2.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByValue()) //  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))   for descending order
                //Performs an action for each element of this stream
                .forEach(System.out::println);
    }
}