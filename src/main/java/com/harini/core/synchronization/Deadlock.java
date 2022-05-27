package com.harini.core.synchronization;
/*
-- Deadlock: When a thread is waiting for an object lock, that is locked by another thread,  which inturn is waiting for the lock acquired by 1st thread.

-- More Complicated Deadlocks
A deadlock may also include more than two threads
Thread 1 locks A, waits for B
Thread 2 locks B, waits for C
Thread 3 locks C, waits for D
Thread 4 locks D, waits for A
Thread 1 waits for thread 2, thread 2 waits for thread 3, thread 3 waits for thread 4, and thread 4 waits for thread 1.



 */

// Example to Show Deadlock between the threads
public class Deadlock extends Thread {
    public static void main(String args[]) {
        String resource1 = "Happy";
        String resource2 = "Welcome";
       // String resource3 = "Hi";
        //String resource4 = "Good Luck";
        Thread t1 = new Thread() {   //  // t1 tries to lock resource1 then resource2
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 locked  resource1");
                    try{ Thread.sleep(100);  }
                    catch (Exception e)  {  System.out.println(e);  }
                    synchronized (resource2) {
                        System.out.println("Thread 1 locked resource 1 and resource2");
                    }
                    }
                }
        };

        Thread t2 = new Thread() {   // t2 tries to lock resource2 then resource1
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 locked  resource2");
                    try{ Thread.sleep(100);  }
                    catch (Exception e)  {  System.out.println(e);  }
                    synchronized (resource1) {
                        System.out.println("Thread 2 locked resource2 and  resource1");
                    }
                }

                }
            };
        t1.start();
        t2.start();

        }
    }

// Example to avoid Deadlock arised in the abo e program

class DeadlockSolved extends Thread {
    public static void main(String args[]) {
        String resource1 = "Happy";
        String resource2 = "Welcome";
        // String resource3 = "Hi";
        //String resource4 = "Good Luck";
        Thread t1 = new Thread() {   //  // t1 tries to lock resource1 then resource2
            @Override
            public void run() {
                try{ Thread.sleep(100);  }   // Adding delay so that both threads can start trying to lock resources  to avoid deadlock
                catch (Exception e)  {  System.out.println(e);  }
                synchronized (resource1) {
                    System.out.println("Thread 1 locked  resource1");
                    synchronized (resource2) {
                        System.out.println("Thread 1 locked  resource 1 and resource2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {   // t2 tries to lock resource2 then resource1
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 locked  resource2");
                    synchronized (resource1) {
                        System.out.println("Thread 2 locked  resource2 and resource1");
                    }
                }

            }
        };
        t1.start();
        t2.start();

    }
}



