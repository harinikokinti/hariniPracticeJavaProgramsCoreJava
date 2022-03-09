package com.harini.core;
/*
In java, a method can return any type of data, including objects. F
 */


class ObjectReturnDemo
{
    int a;

    ObjectReturnDemo(int i)
    {
        a = i;
    }

    // This method returns an object
    ObjectReturnDemo incrByTen()
    {
        ObjectReturnDemo temp =
                new ObjectReturnDemo(a+10);
        return temp;
    }
}

public class ReturningObjectsExample
{
    public static void main(String args[])
    {
        ObjectReturnDemo ob1 = new ObjectReturnDemo(2);
        ObjectReturnDemo ob2;

        ob2 = ob1.incrByTen();

        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob2.a: " + ob2.a);
    }
}


