package com.harini.core.multithreading;
/*
-- How to create thread
   There are two ways to create a thread:
   1. By extending Thread class
   2. By implementing Runnable interface.

    1. Extending Thread class
      Java provides Thread class to achieve thread programming. Thread class provides constructors
      and methods to create and perform operations on a thread. Thread class extends Object class
      and implements Runnable interface.
      --Java Thread Methods  : start(), run(), sleep(), currentThread(), join(), destroy()  etc
      --Starting a thread:
      start() method of Thread class is used to start a newly created thread. It performs following tasks:
        A new thread starts(with new callstack).
        The thread moves from New state to the Runnable state.
        When the thread gets a chance to execute, its target run() method will run.

    2. Implementing Runnable Interface:
    The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Runnable interface have only one method named run().
    public void run(): is used to perform action for a thread.
 */

// Java Thread example by Extending thread Class
public class CreateThread  extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}
    class Test {
    public static void main(String args[]) {
        CreateThread createThread = new CreateThread();
        createThread.start();
    }

}

// Java Example by implementing runnable interface

class CreateThreadRunnableInterface implements Runnable {
    public void run() {
        System.out.println("Thread is running : runnable Interface");
    }

    public static void main(String args[]) {
        CreateThreadRunnableInterface createThread2 = new CreateThreadRunnableInterface();
        /*
        If you are not extending the Thread class,your class object would not be treated as a thread object.
        So you need to explicitely create Thread class object.We are passing the object of your class that
        implements Runnable so that your class run() method may execute.
         */
        Thread t = new Thread(createThread2);
        t.start();
    }
}

// Threads can be created without Extending the thread class or implementing Runnable interface
class Calculate {
    int z;
    void addition(int x,int y) {
        z = x+y;
        System.out.println("Addition of x and y are: " + z);
    }
}
class ThreadWithoutExtendsAndRunnable {
    public static void main(String args[]) {
        Calculate c = new Calculate();
        Thread t1 = new Thread() {
            public void run() {
              //  System.out.println("Thread 1  ");
                c.addition(2,3);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
              //  System.out.println("Thread 2  ");
                c.addition(20,30);
            }
        };

        t1.start();
        t2.start();
    }
}