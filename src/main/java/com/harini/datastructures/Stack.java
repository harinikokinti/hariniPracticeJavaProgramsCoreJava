package com.harini.datastructures;
/*

Stack - (LIFO)
Last in First Out
the pile of plates or books on top of another
the logics for push, pop and peek make use of arrays logic to insert, delete

 */

public class Stack {

    int a[] = new int[2];
    int top = 0;
    public void push(int data) {
        if (size() == a.length) {
            System.out.println("The stack is full");
        } else {
            a[top++] = data;   // it adds the data and index is incremented by 1
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty");
        } else {
            top--;  //  since it is array, to get the current position, decrement top value
            a[top] = 0;
        }
    }

    public void display() {
        for(int n : a) {
            System.out.println(n);
        }


    }

    public boolean isEmpty() {
        return top<=0;  // returns true or false
    }

    public int size() {
        return top;
    }
}


class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.display();

        System.out.println("The size of the Stack is : " + stack.size());  // gives size of the stack
    }
}