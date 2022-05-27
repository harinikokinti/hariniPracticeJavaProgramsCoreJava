package com.harini.OtherJavaConcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPrograms {

    public static void main(String args[]) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1, "ABC");
        map.put(2,"XYZ");

        // Traverse using map.entry
        Set<Map.Entry<Integer,String>> entry = map.entrySet();
        for(Map.Entry<Integer,String> m : entry) {
            System.out.println(m.getKey() + " " + m.getValue());

        // traverse using
            map.keySet();
            map.values();

        }
    }
}
