package com.harini.core.serialization;
/*

-- Serialization is the process of converting an object into a stream of bytes to store or save the object or transmit it to memory, a database, or a file.
Its main purpose is to save or store the state(value) of an object in order to be able to recreate it when needed.
The reverse process is called deserialization

 Note: By default, its not possible to store object. Its possible only if the class implements Serializable interface

-- transient keyword is used to deserialize the variable .
When an object is deserialized the transient variables retains the default value depending on the type of variable declared and hence will not lose its original value.

-- Volatile keyword is used to modify the value of a variable by different threads
Every thread has its own private memory where it stores a copy of the variable.
When a variable is declared as volatile, it lets JVM know that any thread accessing the variable must always sync with its local copy with
the copy in the main memory(heap memory).

The volatile variables are always visible to other threads.
The copy of volatile variable is stored in the main memory, so every time a thread access the variable even for reading purpose,
It can be used as an alternative way of achieving synchronization in Java.
You can use the volatile keyword with variables. Using volatile keyword with classes and methods is illegal.
the local copy is updated each time from the main memory.
Ex: count variable to hold

Note: Accessing a volatile variable synchronizes all the cached copied of the variables in the main memory.
Volatile can only be applied to instance variables, which are of type object or private.
A volatile object reference can be null.

 */

import java.io.*;

class SaveObject implements Serializable
{
    int x;
}


public class TestSerialize {
    public static final long serialVersionID = -34523444; // optional as a reference while deserializing the object
    public static void main(String args[]) throws Exception{

        SaveObject saveObj = new SaveObject();
        saveObj.x = 20;

        File f = new File("obj.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos); //ObjectOutputStream  does serializaiton
        oos.writeObject(saveObj); // save the object into the file , it is allowed only if the class of the object implements Serializable

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SaveObject objRetrieved = (SaveObject) ois.readObject(); // read as an object
        System.out.println(objRetrieved.x); // the data can be retrived from the  file where obj is saved.

    }
}


// volatile keyword Example

