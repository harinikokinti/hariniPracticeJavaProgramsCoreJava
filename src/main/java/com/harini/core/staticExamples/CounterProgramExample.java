package com.harini.core.staticExamples;
// Counter program without static variable

class Counter {
     int counter = 0;

    void getCounter() {
       counter++;
        System.out.println("counter value : " + counter);
    }

}
public class CounterProgramExample {
    public static void main(String args[])
    {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        counter1.getCounter(); // the output is 1
        counter2.getCounter(); // the output is 1
        counter3.getCounter(); // output is same as 1 . Here the instance variable counter gets memory each time when an object is created for the class
        // So each object will have the value 1 in the counter variable.

    }
}





// Counter program with static variable

class CounterWithStatic {
   static int counter = 0;

    void getCounter() {
        counter++;
        System.out.println("counter value : " + counter);
    }

}
 class CounterProgramExampleWithStatic {
    public static void main(String args[])
    {
        CounterWithStatic counter1 = new CounterWithStatic();
        CounterWithStatic counter2 = new CounterWithStatic();
        CounterWithStatic counter3 = new CounterWithStatic();
        counter1.getCounter(); //  it  gives value 1
        counter2.getCounter(); // it gives value 2
        counter3.getCounter(); //  it gives value 3  , since the counter is static abd it holds the value in the class area memory

    }
}
