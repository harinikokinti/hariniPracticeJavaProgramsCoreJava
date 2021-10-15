package com.harini.core.synchronization;
/*
--  Interrupting a Thread:
If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked), calling the interrupt() method on the thread,
 breaks out the sleeping or waiting state throwing InterruptedException
If the thread is not in the sleeping or waiting state, calling the interrupt() method performs normal behaviour and doesn't interrupt
the thread but sets the interrupt flag to true.

-- The 3 methods provided by the Thread class for interrupting a thread
public void interrupt()
public static boolean interrupted()
public boolean isInterrupted()

--isInterrupted : The isInterrupted() method returns the interrupted flag either true or false.
-- The static interrupted() method returns the interrupted flag, then it sets the flag to false if it is true.

 */

// Example of interrupting a thread that stops working
public class InterrutingThread extends Thread{
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Task");
        } catch (InterruptedException e) {
          // System.out.println(e);
            throw new RuntimeException("Thread Interrupted" + e);
        }
        System.out.println(Thread.currentThread().getName() + " is running");

    }
    public static void main(String args[]) {
        InterrutingThread t1 = new InterrutingThread();
        t1.start();
        try{
            t1.interrupt();
        }
        catch(Exception e){System.out.println("Exception handled "+e);}
    }
}

// Example of interrupting a thread that does not stop working
// In this example, after interrupting the thread, we handle the exception, so it will break out the sleeping but will not stop working.
class InterrutingThread2 extends Thread{
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Task");
        } catch (InterruptedException e) {
             System.out.println(e);  //  Exception handled
            //throw new RuntimeException("Thread Interrupted" + e);
        }
        System.out.println(Thread.currentThread().getName() + " is running");

    }
    public static void main(String args[]) {
        InterrutingThread2 t1 = new InterrutingThread2();
        t1.start();
        try{
            t1.interrupt();
        }
        catch(Exception e){System.out.println("Exception handled "+e);}
    }
}

// Example of interrupting thread that behaves normally
// If thread is not in sleeping or waiting state, calling the interrupt() method sets the interrupted flag to true, and can be used to stop the thread later by programmer
class InterrutingThread3 extends Thread{

    public void run(){
        for(int i=1;i<=5;i++)
            System.out.println(i);
    }

    public static void main(String args[]){
        InterrutingThread3 t1=new InterrutingThread3();
        t1.start();

        t1.interrupt();

    }
}