package com.harini.core.multithreading;
/*
-- Sleep method : to sleep a thread for the specified amount of time.
As you know well that at a time only one thread is executed. If you sleep a thread for the specified time,the thread shedular picks up another thread and so on.

-- Can we start a thread twice
No. After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown.
In such case, thread will run once but for second time, it will throw exception.

-- What if we call run() method directly instead start() method?
Each thread starts in a separate call stack.
Invoking the run() method from main thread, the run() method goes onto the current call stack rather than at the beginning of a new call stack.
It means the thread object is treated as normal class object and thread fucntionality(context switching) does not occur.

-- The join() method
The join() method waits for a thread to die.
In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.

-- Naming Thread
The Thread class provides methods to change and get the name of a thread. By default, each thread has a name i.e. thread-0, thread-1 and so on.
public String getName(): is used to return the name of a thread.
public void setName(String name): is used to change the name of a thread.

--  Current Thread
The currentThread() method returns a reference of currently executing thread.

-- Thread Priority
Each thread have a priority. Priorities are represented by a number between 1 and 10.
 In most cases, thread schedular schedules the threads according to their priority (known as preemptive scheduling).
 But it is not guaranteed because it depends on JVM specification that which scheduling it chooses.Default priority of a thread is 5 (NORM_PRIORITY)

 3 constants defined in Thread class:
    public static int MIN_PRIORITY  : value 1
    public static int NORM_PRIORITY   : value 5
    public static int MAX_PRIORITY    :value 10

 */

public class ThreadPrograms {
}

// Sleep  method example

class SleepMethod extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
class TestSleepMethod {
        public static void main(String args[]) {
            SleepMethod sleepMethod1 = new SleepMethod();
            sleepMethod1.start();
            // sleepMethod.start(); throws IllegalStateException  exception because, After starting a thread, it can never be started again.
            SleepMethod sleepMethod2 = new SleepMethod();
            sleepMethod2.start();
        }
}

// Start Thread twice
class ThreadExample extends Thread {
    public void run(){
        System.out.println("running...");
    }
    public static void main(String args[]){
        ThreadExample t1=new ThreadExample();
        t1.start();
        t1.start(); //  throws IllegalStateException  exception because, After starting a thread, it can never be started again.
    }
}


// thread with only run() method
class ThreadExample2 extends Thread {
    public void run(){
        for(int i = 1; i<=5; i++) {
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        ThreadExample2 t1=new ThreadExample2();
        ThreadExample2 t2=new ThreadExample2();
        t1.run();
        t2.run(); //  here is no context-switching because here t1 and t2 will be treated as normal object not thread object.
    }
}

// Join()  method
class ThreadJoin extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try{
                sleep(500);
            }
            catch(Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
class TestThreadJoin {
    public static void main(String args[]) {
        ThreadJoin t1 =new ThreadJoin();
        ThreadJoin t2 =new ThreadJoin();
        ThreadJoin t3 =new ThreadJoin();
        t1.start();
        try {
            t1.join();
        }
        catch ( Exception e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();
// when t1 completes its task then t2 and t3 starts executing.
    }
}

// Join(long milliseconds)  method
class ThreadJoin2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try{
                sleep(500);
            }
            catch(Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
class TestThreadJoin2 {
    public static void main(String args[]) {
        ThreadJoin2 t1 = new ThreadJoin2();
        ThreadJoin2 t2 = new ThreadJoin2();
        ThreadJoin2 t3 = new ThreadJoin2();
        t1.start();
        try {
            t1.join(1500);
        } catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();
        // when t1 is completes its task for 1500 miliseconds(3 times) then t2 and t3 starts executing.
    }
}

// Naming Thread

class NamingThread extends Thread {
    public void run() {
        System.out.println(getName());
    }
}
class TestNamingThread {
    public static void main(String args[]) {
        NamingThread t1 = new NamingThread();
        NamingThread t2 = new NamingThread();
        NamingThread t3 = new NamingThread();
        System.out.println("Name of thread 1: " + t1.getName());
        System.out.println("Name of thread 2: " + t2.getName());

        t1.start();

        t1.setName("Recording");
        System.out.println("After changing name of t1:"+t1.getName());
    }
}

// Current Thread
class CurrentThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
class TestCurrentThread {
    public static void main(String args[]) {
        CurrentThread t1 = new CurrentThread();
        CurrentThread t2 = new CurrentThread();

        t1.start();
        t2.start();
    }
}

// Thread Priority
class ThreadPriority extends Thread{
    public void run(){
        System.out.println("running thread name is:"+Thread.currentThread().getName());
        System.out.println("running thread priority is:"+Thread.currentThread().getPriority());

    }
    public static void main(String args[]){
        ThreadPriority m1=new ThreadPriority();
        ThreadPriority m2=new ThreadPriority();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();

    }
}