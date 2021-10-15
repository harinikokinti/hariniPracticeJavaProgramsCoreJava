package com.harini.core.synchronization;
/*
Synchronized block
It can be used to perform synchronization on any specific resource of the method.
Scenario: Suppose we have 50 lines of code in our method, but we want to synchronize only 5 lines, in such cases, we can use synchronized block.
If we put all the codes of the method in the synchronized block, it will work same as the synchronized method.

Points to Remember
Synchronized block is used to lock an object for any shared resource.
Scope of synchronized block is smaller than the method.
A Java synchronized block doesn't allow more than one JVM, to provide access control to a shared resource.
The system performance may degrade because of the slower working of synchronized keyword.
Java synchronized block is more efficient than Java synchronized method.



 */
// Synchronized Block Example Using Anonymous Class
public class SynchronizationBlock {
}


// A Sender class
class Sender
{
    public void SenderMsg(String msg)
    {
        System.out.println("\nSending a Message: "  + msg);
        try
        {
            Thread.sleep(800);
        }
        catch (Exception e)
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" +msg+ "Sent");
    }
}
// A Sender class for sending a message using Threads
class SenderWThreads extends Thread
{
    private String msg;
    Sender sd;

    // Receiver method to receive a message object and a message to be sent
    SenderWThreads(String m, Sender obj)
    {
        msg = m;
        sd = obj;
    }

    public void run()
    {
        // Checks that only one thread sends a message at a time.
        synchronized(sd)
        {
            // synchronizing the sender object
            sd.SenderMsg(msg);
        }
    }
}
// Driver Code
 class ShynchronizedMultithreading
{
    public static void main(String args[])
    {
        Sender sender = new Sender();
        SenderWThreads sender1 = new SenderWThreads( "Hola " , sender);
        SenderWThreads sender2 =  new SenderWThreads( "Welcome to Javatpoint website ", sender);

        // Start two threads of SenderWThreads type
        sender1.start();
        sender2.start();

        // wait for threads to end
        try
        {
            sender1.join();
            sender2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}