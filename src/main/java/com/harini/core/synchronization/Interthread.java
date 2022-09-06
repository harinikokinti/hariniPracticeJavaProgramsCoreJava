package com.harini.core.synchronization;
/*
-- Inter-thread communication  or Co-operation  is all about allowing synchronized threads to communicate with each other.
Cooperation (Inter-thread communication) is a mechanism in which a thread is paused running in its critical section
and another thread is allowed to enter (or lock) in the same critical section to be executed.
It is implemented by following methods of Object class:
    1. wait()   :  It releases the current thread and waits until it gets notified (by invoking notify() or notifyall() methods)
                    by any other thread in  for the same object
                    Note: The current thread must own this object's monitor, so it must be called from the synchronized method only otherwise
                          it will throw exception.
    2. notify() : It wakes up any of the single thread which is waiting in the same object's monitor. The choice is arbitrary.
    3. notifyAll() : Wakes up all threads that are waiting on this object's monitor.

-- Why wait(), notify() and notifyAll() methods are defined in Object class not Thread class?
It is because they are related to lock and object has a lock.

-- Difference between wait and sleep?
wait()	                                                    sleep()
The wait() method releases the lock.	                    The sleep() method doesn't release the lock.
It is a method of Object class	                            It is a method of Thread class
It is the non-static method	                                It is the static method
It should be notified by notify() or notifyAll() methods	After the specified amount of time, sleep is completed.
 */

public class Interthread {
}

// Inter thread communiaation example using Banking transactions

class Customer  {
    int balance = 10000;

    synchronized void withdraw(int amount) {
        if (this.balance < amount) {
            try {
                wait();  // the thread releases the lock and waits
            } catch (Exception e) {
                System.out.println(e);
            }  // here if there is no enough amount to withdraw, the thread waits by releasing the lock on the object
        } else {
            this.balance -= amount;
            System.out.println("Amount Withdraw Completed");
        }
    }

    synchronized void deposit(int amount) {
        this.balance+= amount;
        System.out.println("Amount Deposit Completed");
        notify();   //  it wakes up any thread which is in waiting state
    }
}

class TestInterThreadCooperation {
    public static void main(String args[]) {
        Customer c = new Customer();
        new Thread () {
            public void run() {
                c.withdraw(5000); }
            }.start();

        new Thread () {
            public void run() {
                c.deposit(10000); }
        }.start();

       }

    }

