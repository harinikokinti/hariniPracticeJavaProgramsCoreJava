package com.harini.javaPrograms.Basic;


// practice Thread creation 2 ways

public class ThreadExample {

        }

class Sample implements Runnable{
  public   void run() {
        System.out.println("thread is running in sample 1");
    }
}


class Sample2 extends Thread {
    public void run() {
        System.out.println("Thread running in Sample2");
    }
}

 class Test {
    public static void main(String args[])  {
        Sample sam = new Sample();
        Thread t1 = new Thread(sam) ;
        t1.start();
    }
}


// practice Thread creation without Runnnable interface and thread class
class Table {
   synchronized void table(int n) {
        for(int i=1; i<5; i++) {
            System.out.println(n*i);
        }

    }
}

class ThreadWithout {
    public static void main(String args[]) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                table.table(2);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                table.table(30);
            }
        };

        t1.start();
        t2.start();
    }
}


// synchronized example

class PrintNumbers {
   public void print(int n) {
        for(int i=1; i<5; i++) {
            System.out.println(n+10);
        }
    }


}


class TestSynchronization {
    public static void main(String args[]) {
        PrintNumbers p = new PrintNumbers() ;
        Thread t1 = new Thread() {
            public void run() {
                p.print(5);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                p.print(6);
            }
        };

        t1.start();
        t2.start();

    }
}