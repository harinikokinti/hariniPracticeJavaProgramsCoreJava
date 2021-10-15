package com.harini.core.exceptionalHandling;
/*
--finalize is the method in Java which is used to perform clean up processing just before object is garbage collected.
 */

public class Finalize {
    public static void main(String[] args)
    {
        Finalize obj = new Finalize();
        // printing the hashcode
        System.out.println("Hashcode is: " + obj.hashCode());
        obj = null;
        // calling the garbage collector using gc()
        System.gc();
        System.out.println("End of the garbage collection");
    }
    // defining the finalize method
    protected void finalize()
    {
        System.out.println("Called the finalize() method");
    }
}
