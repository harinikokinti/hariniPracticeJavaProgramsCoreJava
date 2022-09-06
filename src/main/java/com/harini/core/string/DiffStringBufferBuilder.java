package com.harini.core.string;
/*
# StringBuffer and StringBuilder

StringBuffer  (thread safe)
> it is synchorinized ie thread safe
> it is less efficient

StringBuilder  (notthread safe)
> it is non-synchorinized ie not thread safe
> it is more efficient
 */

public class DiffStringBufferBuilder {
    public static void main(String[] args) {
        System.out.println("Performance Test");
        long startTime = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer("Hello");
        for(int i=0; i<100000; i++) {
            stringBuffer.append("World");
        }
        System.out.println("Time taken by String Buffer: " + (System.currentTimeMillis()-startTime) + "ms");

        startTime = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder("Hello");
        for(int i=0; i<100000; i++) {
            stringBuilder.append("World");
        }
        System.out.println("Time taken by String Builder: " + (System.currentTimeMillis()-startTime) + "ms");


    }
}
