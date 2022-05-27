package com.harini.core.multithreading;

/*
-- Callable interface
To return an object after completing its execution
It has call()  method like run() method in Runnable
Using Executors class, can create a thread pool and create Future tasks and submit the tasks to the threads which
implement Callable interface

Advantage: Using thread pool, hte threads can be reused once they finish their task.

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
        System.out.println(f1.get());

        // approach 2
        Future<String> f2 = exs.submit(new SampleThread());
        System.out.println(f2.get());

        //approach 3
        Future<String> f3 =exs.submit(new CreateThreadCallable());
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
        System.out.println(f4.get());
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " - " + i);
        }
        return "Thread 3 Execution completed ";
    }
}