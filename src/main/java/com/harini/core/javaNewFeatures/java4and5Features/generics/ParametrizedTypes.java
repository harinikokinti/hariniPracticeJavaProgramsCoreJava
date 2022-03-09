package com.harini.core.javaNewFeatures.java4and5Features.generics;
/*
A generic type is a type with formal type parameters. A parameterized type is an instantiation of a generic type with actual type arguments.
 */

import java.util.ArrayList;
import java.util.List;

class Box2<T,S> {
    T t;
    S s;
    void setValues(T t,S s) {
        this.t = t;
        this.s = s;
    }

    T getFirstGeneric()
    {
        return t;
    }

    S getSecondGeneric() {
        return s;
    }
}


public class ParametrizedTypes {
    public static void main(String args[]) {
        Box2<Integer, List<String>> box2 = new Box2<>(); //  here T = integer and S = LIST<String> are te type arugments  = parameterised type.

        List<String> listData = new ArrayList<>();
        listData.add("Ravi");
        listData.add("Kumar");

        box2.setValues(Integer.valueOf(10),listData);  // or    box2.setValues(10,listData);

        System.out.println(box2.getFirstGeneric() + "   " + box2.getSecondGeneric());
    }
}
