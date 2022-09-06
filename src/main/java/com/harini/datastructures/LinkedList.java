package com.harini.datastructures;

/*

Linked List :

inked List is a sequence of links which contains items.
Each link contains a connection to another link.
Linked list is the second most-used data structure after array.

It has nodes with data and pointer to next node
First node - head node
Last node - tail node with pointer as NULL


 */

class Node {
    int data;
    Node next;
}

public class LinkedList {
    Node head;
    void insertAtStart(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head==null) {
            head = newNode;
            System.out.println("The data is inserted at head node: " + head.data);
        } else {
            newNode.next = head;
            head = newNode;
            System.out.println("The data is inserted: " + newNode.data);
        }
    }

    void insertAtEnd(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head==null) {
            head = newNode;
            System.out.println("The data is inserted at head node: " + head.data);
        } else {
            // traverse from head to the last node using tempNode
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;  // to jump to the next node
            }
            tempNode.next = newNode;
        }
    }

    void insertAtIndex(int index, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        Node tempNode = head;
        for(int i=1; i<index; i++) {   // traverse till position -1
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    void show() {
        // traverse from head to the last node using tempNode
        Node tempNode = head;
        while(tempNode.next!=null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;  // to jump to the next node
        }
        System.out.println(tempNode.data);  // to print the last node which has tempNode.next = null
    }
}

class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtStart(20);
        list.insertAtStart(21);
        list.insertAtStart(22);
        list.insertAtStart(23);
        list.insertAtEnd(19);
        list.insertAtIndex(2,100);
        list.show();  // 23 -> 22 -> 100 -> 21 -> 20 ->19
    }
}
