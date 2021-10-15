package com.harini.core.collections;
/*
-- Queue Interface:
Queue interface orders the element in FIFO(First In First Out) manner. In FIFO, first element is removed first and last element is removed at last.
-- Priority Queue:
A PriorityQueue is used when the objects are supposed to be processed based on the priority.
It is known that a Queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue are needed
to be processed according to the priority, that’s when the PriorityQueue comes into play.
The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering,
or by a Comparator provided at queue construction time, depending on which constructor is used.
The elements in PriorityQueue must be of Comparable type.
-- Deque Interface
Deque Interface is a linear collection that supports element insertion and removal at both ends. Deque is an acronym for "double ended queue".
-- ArrayDeque class
The ArrayDeque class provides the facility of using deque and resizable-array. It inherits AbstractCollection class and implements the Deque interface.
The important points about ArrayDeque class are:
    Unlike Queue, we can add or remove elements from both sides.
    Null elements are not allowed in the ArrayDeque.
    ArrayDeque is not thread safe, in the absence of external synchronization.
    ArrayDeque has no capacity restrictions.
    ArrayDeque is faster than LinkedList and Stack.
 */

public class QueuePriorityQueueDequeArrayDeque {
}
