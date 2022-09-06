package com.harini.datastructures;
/*
Here, the stack size is increased or decreased(Explanded/shrinked) with the logics implemented
 */
public class DynamicStack {
    int capacity = 2 ;
    int stack[] = new int[capacity];
    int top = 0;
    public void push(int data) {
        if (size() == capacity) {
            expand();
        }
        stack[top++] = data;   // it adds the data and index is incremented by 1
    }

    private void expand() {
        int stackSize = size();
        int newStack[] = new int[capacity*2];
        System.arraycopy(stack,0,newStack,0,stackSize);
        stack = newStack;
        capacity*=2;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty");
        } else {
            top--;  //  since it is array, to get the current position, decrement top value
            stack[top] = 0;
        }
    }

    public void display() {
        for(int n : stack) {
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



class TestDynamicStack {
    public static void main(String[] args) {
        DynamicStack dStack = new DynamicStack();
        dStack.push(1);
        dStack.push(2);
        dStack.push(3);
        dStack.pop();
        dStack.pop();
        dStack.display();

        System.out.println("The size of the Stack is : " + dStack.size());  // gives size of the stack
    }
}

