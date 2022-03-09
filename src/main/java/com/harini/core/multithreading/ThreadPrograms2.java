package com.harini.core.multithreading;
/*
-- Daemon Thread
It is a service provider thread runs automaticaaly(example gc, finalizer)
Its life depends on user threads. when user thread dies, jVM terminates this thread automatically.
It is a low priority thread.
Note: If you want to make a user thread as Daemon, it must not be started otherwise it will throw IllegalThreadStateException.

--jconsole tool
You can see all the detail by typing the jconsole in the command prompt.
The jconsole tool provides information about the loaded classes, memory usage, running threads etc.

-- Thread pool: It represents a group of worker threads that are waiting for the job and reuse many times.
In case of thread pool, a group of fixed size threads are created.
A thread from the thread pool is pulled out and assigned a job by the service provider.
After completion of the job, thread is contained in the thread pool again.

Advantage of Java Thread Pool
Better performance It saves time because there is no need to create new thread.

Real time usage
It is used in Servlet and JSP where container creates a thread pool to process the request.

-- Thread Group
A ThreadGroup represents a set of threads.
Grouping multiple threads in a single object so that we can suspend, resume or interrupt group of threads by a single method call.

A thread group can also include the other thread group. The thread group creates a tree in which every thread group except the initial thread group has a parent.
A thread is allowed to access information about its own thread group, but it cannot access the information about its thread group's parent thread group or any other thread groups.

-- Shutdown Hook
The shutdown hook can be used to perform cleanup resource or save the state when JVM shuts down normally or abruptly.
Performing clean resource means closing log file, sending some alerts or something else.
So if you want to execute some code before JVM shuts down, use shutdown hook.

The JVM shuts down when:
user presses ctrl+c on the command prompt
System.exit(int) method is invoked
user logoff
user shutdown etc.

The addShutdownHook() method of Runtime class is used to register the thread with the Virtual Machine.
The object of Runtime class can be obtained by calling the static factory method(The method that returns the instance of a class is known as factory method.) getRuntime().
The shutdown sequence can be stopped by invoking the halt(int) method of Runtime class.

-- How to perform single task by multiple threads?
If you have to perform single task by many threads, have only one run() method.

-- How to perform multiple tasks by multiple threads (multitasking in multithreading)?
If you have to perform multiple tasks by multiple threads,have multiple run() methods.

-- Garbage Collection : destroy the unused objects.
In java, garbage means unreferenced objects.
Garbage Collection is process of reclaiming the runtime unused memory automatically.
To do so, we were using free() function in C language and delete() in C++. But, in java it is performed automatically. So, java provides better memory management.

Advantage of Garbage Collection
It makes java memory efficient because garbage collector removes the unreferenced objects from heap memory.
It is automatically done by the garbage collector(a part of JVM) so we don't need to make extra efforts

How can an object be unreferenced?
By nulling the reference
By assigning a reference to another
By anonymous object etc.

1) By nulling a reference:
Employee e=new Employee();
e=null;
2) By assigning a reference to another:
Employee e1=new Employee();
Employee e2=new Employee();
e1=e2;//now the first object referred by e1 is available for garbage collection
3) By anonymous object:
new Employee();

--Garbage Collection:
gc() method - invoked by Garbage collector(Daemon thread), found in System and Runtime classes, cleans up the objects which are created using new keyword
finalize() method - invoked each time before the object is garbage collected, found in Object class, cleans up the objects which are not created using new keyword

The objects can be created without new keyword by following ways
Using Class.forName() and Class.newInstance()
ClassLoader loadClass()
Using Object.clone()
Deserialization
Using reflection


-- Create object using Class.newInstance()
Class ref = Class.forName("DemoClass");
DemoClass obj = (DemoClass) ref.newInstance();
Class.forName() loads the class in memory. To create an instance of this class, we need to use newInstance().

-- Create object using class loader’s loadClass()
Just like above method, class loader’s loadClass() method does the same thing. It creates a new instance of class using an existing instance of same class.

instance.getClass().getClassLoader().loadClass("NewClass").newInstance();

--Create object using Object.clone()
This is also a way to have a new independent instance of a class.
NewClass obj = new NewClass();
NewClass obj2 = (NewClass) obj.clone();

-- Create new object using serialization and deserialization
If you have gone through this article, you can understand that serialization and de-serialization is also a way to have another instance of a class in system.

ObjectInputStream objStream = new ObjectInputStream(inputStream);
 NewClass obj = (NewClass ) inStream.readObject();

-- Create new object using reflection  [refer reflectionAPI package)
Reflection is also a popular way to create new instances in most of available frameworks.
constructor.newInstance(); or
class.newInstance();

-- Runtime class  : to interact with java runtime environment
Java Runtime class provides methods to execute a process, invoke GC, get total and free memory etc.
There is only one instance of java.lang.Runtime class is available for one java application.
The Runtime.getRuntime() method returns the singleton instance of Runtime class.
Methods:
static Runtime getRuntime()
void addShutdownHook(Thread hook)
long freeMemory()
long totalMemory()



 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPrograms2 {
}

// Daemon Thread Example

class Daemonthread extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " this is a daemon thread");
        } else {
            System.out.println(Thread.currentThread().getName() + " this is a user thread");
        }
    }

    public static void main(String args[]) {
        Daemonthread t1 = new Daemonthread();
        Daemonthread t2 = new Daemonthread();
        t1.setDaemon(true);  // now t1 is daemon thread
        t1.start();
        t2.start();
    }
}

// Example of Java Thread Pool
// Let's see a simple example of java thread pool using ExecutorService and Executors.
class WorkerThread implements Runnable {
    private String message;
    public WorkerThread(String s){
        this.message=s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);
        processmessage();//call processmessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name
    }
    private void processmessage() {
        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }
    }
}



class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");
    }
}

// Thread Group

class ThreadGroup implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
public static void main(String[] args) {
    ThreadGroup runnable = new ThreadGroup();
    java.lang.ThreadGroup tg1 = new java.lang.ThreadGroup("Parent ThreadGroup");
    Thread t1 = new Thread(tg1, runnable, "one");
    t1.start();
    Thread t2 = new Thread(tg1, runnable, "two");
    t2.start();
    Thread t3 = new Thread(tg1, runnable, "three");
    t3.start();
}

}

// Shutdown Hook
class MyThread extends Thread{
    public void run(){
        System.out.println("shut down hook task completed..");
    }
}

class TestShutdown1{
    public static void main(String[] args)throws Exception {

        Runtime r=Runtime.getRuntime();
        r.addShutdownHook(new MyThread());

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(3000);}catch (Exception e) {}
    }
}

// Program of performing single task by multiple threads 1
class MultiTaasking extends Thread {
    public void run() {
        System.out.println("task one");
    }
    public static void main(String args[]){
        MultiTaasking t1=new MultiTaasking();
        MultiTaasking t2=new MultiTaasking();
        MultiTaasking t3=new MultiTaasking();

        t1.start();
        t2.start();
        t3.start();
    }
}

// Program of performing single task by multiple threads 2 using anonymous class
class Multitasking2 implements Runnable{
    public void run(){
        System.out.println("task one");
    }

    public static void main(String args[]){
        Thread t1 =new Thread(new Multitasking2());//passing annonymous object of Multitasking2 class
        Thread t2 =new Thread(new Multitasking2());

        t1.start();
        t2.start();

    }
}

// Note: Each thread run in a separate callstack.

// Program of performing multiple tasks by multiple threads

class Task1 extends Thread {
    public void run() {
        System.out.println("task one");
    }
}

class Task2 extends Thread {
    public void run() {
        System.out.println("task two");
    }
}

class Multitasking3 {
    public static void main(String  args[]) {
        Task1 t1 = new Task1();
        t1.start();
        Task2 t2 = new Task2();
        t2.start();

    }
}

// Program of performing multiple tasks by multiple threads using anonymous [Extending Thread]

class Multitasking4  extends Thread{
    public static void main(String args[]){
        Thread t1 =  new Thread() {
            @Override
            public void run() {
                System.out.println("task one");
            }
        };

        Thread t2 =  new Thread() {
            @Override
            public void run() {
                System.out.println("task two");
            }
        };

        t1.start();
        t2.start();
    }

    }
// Program of performing multiple tasks by multiple threads using anonymous [ implementing Runnable
class Multitasking5 {
    public static void main(String args[]){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("task one");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("task two");
            }
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();


    }

    }

// Garbage Collection

class TestGarbage1{
    public void finalize(){System.out.println("object is garbage collected");}
    public static void main(String args[]){
        TestGarbage1 s1=new TestGarbage1();
        TestGarbage1 s2=new TestGarbage1();
        s1=null;
        s2=null;
        System.gc();
    }
}

// Runtime class
// Runtime exec() method
class Runtime1{
    public static void main(String args[])throws Exception{
        Runtime.getRuntime().exec("notepad");//will open a new notepad
    }
}

















