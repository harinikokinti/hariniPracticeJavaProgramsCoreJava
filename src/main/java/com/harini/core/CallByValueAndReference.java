package com.harini.core;
/*
There is only call by value in java, not call by reference. If we call a method passing a value, it is known as call by value.
The changes being done in the called method, is not affected in the calling method.

However from Java The Complete Reference by Herbert Shildt 9th edition:
"When you pass an object to a method, the situation changes dramatically, because objects are passed by what is effectively call-by-reference.
Keep in mind that when you create a variable of a class type, you are only creating a reference to an object.
Thus, when you pass this reference to a method, the parameter that receives it will refer to the same object as that referred to by the argument.
This effectively means that objects act as if they are passed to methods by use of call-by-reference.
Changes to the object inside the method do affect the object used as an argument.

Java doesn't pass method arguments by reference; it passes them by value.
 */

// call by value
class Test {
   int a = 10;
   int b = 20;
    void swap(int a, int b) {
        System.out.println("Before Swapping inside the method: " + a + " " + b ) ;
        int temp;
       temp = a;
       a = b;
       b = temp;
       System.out.println("After Swapping inside the method : " +  a + " " + b) ; //  changes will be in the local

    }
}

public class CallByValueAndReference {
    public static void main(String args[]) {
        Test test = new Test();
        System.out.println("Before Swapping outside the method: " + test.a + " " + test.b ) ;
        test.swap(10,20);
        System.out.println("After Swapping outside the method: " + test.a + " " + test.b ) ;
    }
}


// call by reference
// In case of call by reference original value is changed if we made changes in the called method.
// If we pass object in place of any primitive value, original value will be changed. In this example we are passing object as a value.
class TestReference {
    int a = 10;
    int b = 20;
    void swap(TestReference a, TestReference b) {
        System.out.println("Before Swapping inside the method: " + a.a + " " + b.b ) ;
        TestReference temp = new TestReference();
        temp.a = a.a;
        a.a = b.b; //  changes will be in the instance variable
        b.b = temp.a; // changes will be in the instance variable
        System.out.println("After Swapping inside the method : " +  a.a + " " + b.b) ;

    }
}

 class CallByReference {
    public static void main(String args[]) {
        TestReference test1 = new TestReference();
        TestReference test2 = new TestReference();
        test1.a = 10;
        test2.b = 20;
        System.out.println("Before Swapping outside the method: " + test1.a + " " + test2.b ) ;

        test1.swap(test1,test2);
        System.out.println("After Swapping outside the method: " + test1.a + " " + test2.b) ;
    }
}

// Call by Reference Example 2

class Operation2{
    int data=50;

    void change(Operation2 op){

        op.data=op.data+100;//changes will be in the instance variable
    }


    public static void main(String args[]){
        Operation2 op=new Operation2();

        System.out.println("before change "+op.data);
        op.change(op);//passing object
        System.out.println("after change "+op.data);

    }
}