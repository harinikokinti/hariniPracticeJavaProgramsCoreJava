package com.harini.core.synchronization;
/*
Synchronized Method
If you declare any method as synchronized, it is known as synchronized method.

Synchronized method is used to lock an object for any shared resource.
 */
// Understanding the problem without Synchronization

// Program without synchronization :  so output is inconsistent.
public class SynchronizationMethod {
}

class Table {
  synchronized void  printTable(int n){ // synchronized method
      // If no synchronized, then the output will be not in sequence (inconsistent) because of no synchronization
        for(int i = 1; i<=5; i++) {
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

class TestNosynchronizedData {
    public static void main(String args[]) {
        Table table = new Table(); //only one object
        MyThread1 t1 = new MyThread1(table);
        MyThread2 t2 = new MyThread2(table);
        t1.start();
        t2.start();
    }

}

// Example of synchronized method by using annonymous class


 class TestSynchronization3{
    public static void main(String args[]){
        final Table obj = new Table();//only one object

        Thread t1=new Thread(){
            public void run(){
                obj.printTable(5);
            }
        };
        Thread t2=new Thread(){
            public void run(){
                obj.printTable(100);
            }
        };

        t1.start();
        t2.start();
    }
}