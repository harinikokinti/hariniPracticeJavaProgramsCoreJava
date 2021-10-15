package com.harini.core.synchronization;
/*
According to Sun Microsystems, Java monitors are reentrant means java thread can reuse the same monitor for
different synchronized methods if method is called from the method.



 */

public class ReEntrantmonitor {
    public synchronized void m() {
        n();
        System.out.println("this is m() method");
    }

    public synchronized void n(){
        System.out.println("this is n() method");
    }
}

 class ReentrantExample{
    public static void main(String args[]){
        final ReEntrantmonitor re=new ReEntrantmonitor();

        Thread t1=new Thread(){
            public void run(){
                re.m();//calling method of Reentrant class
            }
        };
        t1.start();
    }}