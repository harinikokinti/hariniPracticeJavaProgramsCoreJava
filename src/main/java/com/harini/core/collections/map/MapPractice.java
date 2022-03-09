package com.harini.core.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapPractice {

    public static void main(String args[]) {
        Map<Integer,Employee> map = new HashMap<>();
        map.put(1,new Employee(206,"Harini"));
        map.put(2,new Employee(156,"Yashu"));
        map.put(3,new Employee(823,"Dhilli"));

        map.keySet();  // set of keys
        map.values(); // set of values
        map.entrySet(); // set of entries with keys and values

        // method 1   Traverse and Print the map -keySet(), values()
        Iterator itrKeys = map.keySet().iterator();

       Iterator itrValues = map.values().iterator();
        System.out.println(itrKeys);
        System.out.println(itrValues);

        while(itrKeys.hasNext() && itrValues.hasNext()) {
            Object key = itrKeys.next();
           Employee emp = (Employee) itrValues.next();
            System.out.println( key + " " + emp.empID + " " + emp.empName);
        }

        // method 2 Tranverse and Print the map using Map.Entry interface - entrySet(), getKey(), getValue()

        for(Map.Entry<Integer,Employee> m : map.entrySet()) {
            System.out.println(m.getKey() + "  " + m.getValue().empID + "  " + m.getValue().empName);
        }

        // method 3 Traverse using Streams
        System.out.println("Using Streams");
        map.entrySet().stream().forEach(p->System.out.println(p.getKey()  + " " + p.getValue().empID + " " + p.getValue().empName));


               // forEach(System.out::println);

    }
}
