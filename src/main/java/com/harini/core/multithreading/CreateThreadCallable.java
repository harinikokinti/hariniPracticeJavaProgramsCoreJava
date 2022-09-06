package com.harini.core.multithreading;

/*
-- Callable interface
To return an object after completing its execution
It has call()  method like run() method in Runnable
Using Executors class, can create a thread pool and create Future tasks and submit the tasks to the threads which
implement Callable interface

-- Executor Framework
Executor, ExecutorService, Executors are part of Java's Executor Framework
Since the creation and management of Threads are expensive and the operating system also imposes restrictions
on how many Threads an application can spawn, it's a good idea is to use a pool of threads to execute tasks in parallel,
instead of creating a new thread every time a request comes in. This not only improves the response time of the application
but also prevent resource exhaustion errors like "java.lang.OutOfMemoryError: unable to create new native thread".

Read more: https://javarevisited.blogspot.com/2017/02/difference-between-executor-executorservice-and-executors-in-java.html#ixzz7Y2aLet1d

-- Executor - It is a core interface used to execute the submitted Runnable tasks.
              An Executor is normally used instead of explicitly creating threads.
              It has only execute() method.
-- ExecutorService - It is an extension to Executor interface which provides a facility for returning a Future object and terminate,
             or shut down the thread pool, and the ability to wait for and look at the status of jobs.
             Once the shutdown is called, the thread pool will not accept new tasks but complete any pending task.
             It also provides a submit() method which extends Executor.execute() method and returns a Future.
             Future<T> submit(Callable<T> task);
             Future<?> submit(Runnable task);
             The Future object provides the facility of asynchronous execution, which means you don't need to wait until the execution
             finishes, you can just submit the task and go around, come back and check if the Future object has the result,
             if the execution is completed then it would have a result which you can access by using the Future.get() method.
             Just remember that this method is a blocking method i.e. it will wait until execution finish and the result is available
             if it's not finished already.

-- Executors - It is a utility class similar to Collections , which provides factory methods
               to create diff types of thread pools(ex:fixed and cached thread pools)


Ex: ExecutorService exs = Executors.newFixedThreadPool(5); // creates 5 threads
Future<String> f1 = exs.submit(c1); // it can accept both Callable/Runnable tasks
System.out.println(f1.get());

Advantage: Using thread pool, the threads can be reused once they finish their task.

 */
import java.util.concurrent.*;

class SampleThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " - " + i);
        }
        return "Thread Execution completed ";
    }
}


public class CreateThreadCallable implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Approach 1
        SampleThread c1 = new SampleThread();
        ExecutorService exs = Executors.newFixedThreadPool(5); // creates 5 threads
//        ExecutorService exs = Executors.newCachedThreadPool(); // it creates 2 threads and reuse them
//        ExecutorService exs = Executors.newSingleThreadExecutor(); // single Thread
        Future<String> f1 = exs.submit(c1);
        System.out.println("Future Task f1 :");
        System.out.println(f1.get());

        // approach 2
        Future<String> f2 = exs.submit(new SampleThread());
        System.out.println("Future Task f2 :");
        System.out.println(f2.get());

        //approach 3
        Future<String> f3 =exs.submit(new CreateThreadCallable());
        System.out.println("Future Task f3 :");
        System.out.println(f3.get());

        //approach 4
        Future<String> f4 =exs.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " - " + i);
                }
                return "Thread 4 Execution completed ";
            }
        });
        System.out.println("Future Task f4 :");
        System.out.println(f4.get());


        exs.shutdown();
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " - " + i);
        }
        return "Thread 3 Execution completed ";
    }
}