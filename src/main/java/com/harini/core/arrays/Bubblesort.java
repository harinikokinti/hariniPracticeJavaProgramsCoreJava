package com.harini.core.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bubblesort {
    public static void main(String args[]) {
        int a[] = {5,2,9,6,10};
        int temp=0;

        for(int i=0; i<a.length; i++)
        {
            for(int j=i+1; j<a.length;j++) {
                if(a[i]>a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for(int i:a)
        System.out.println(i);
    }
}
