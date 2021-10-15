package com.harini.core.collections.arrayListLinkedList;
/*
ArrayList class uses a dynamic array for storing the elements. It is like an array, but there is no size limit. We can add or remove elements anytime.
The important points about Java ArrayList class are:
    Java ArrayList class can contain duplicate elements.
    Java ArrayList class maintains insertion order.
    Java ArrayList class is non synchronized.
    Java ArrayList allows random access because array works at the index basis.
    In ArrayList, manipulation is little bit slower than the LinkedList in Java because a lot of shifting needs to occur if any element is removed from the array list.

--Hierarchy of ArrayList class
ITERABLE <-- COLLECTION <-- LIST<-- AbstractList <-- ArrayList

-- Constructors of ArrayList
Constructor	                                    Description
ArrayList()	                                    It is used to build an empty array list.
ArrayList(Collection<? extends E> c)	        It is used to build an array list that is initialized with the elements of the collection c.
ArrayList(int capacity)	                        It is used to build an array list that has the specified initial capacity.

--Use of forEach:
There are two forEach() method in Java 8, one defined inside Iterable, and the other inside java.util.stream.Stream class.
If the purpose of forEach() is just iteration then you can directly call it like list.forEach() or set.forEach() but
if you want to perform some operations like filter or map then it better first get the stream and then perform that operation and finally call forEach() method.


 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//ArrayList Example
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListExample{
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<>();//Creating arraylist
        list.add("Mango");//Adding object in arraylist
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        //Printing the arraylist object
        System.out.println(list);
        //accessing the element
        System.out.println(list.get(1)); //it will return the 2nd element, because index starts from 0
        //Changing the element
        list.set(1,"Fig");
        //Sorting the list
        Collections.sort(list);
        // traversing or printing using Iterator
        Iterator itr = list.iterator();
        while(itr.hasNext()) { System.out.println(itr.next()); }

    }
}

// ArrayList example 2
class Book {
    int id;
    String name;
    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

 class ArrayListExample1 {
    public static void main(String args[]) {
        //Creating list of Books
        ArrayList<Book> bookArrayList = new ArrayList(); //  it is a list of type book
        //Creating Books
        Book b1 = new Book(1, "Telugu");
        Book b2 = new Book(2, "english");
        Book b3 = new Book(3, "Telugu");
        //Adding Books to list
        bookArrayList.add(b1);
        bookArrayList.add(b2);
        bookArrayList.add(b3);
        //Traversing list method 1: By Iterator interface.
        System.out.println("Method 1 : Printing using Iterator interface");
        Iterator itr = bookArrayList.iterator();
        while (itr.hasNext()) {
            Book book = (Book) itr.next();
            System.out.println(book.id + " " + book.name);
        }
        //Traversing list method 2: Using for- each loop
        System.out.println("Method 2 : Printing using for-each loop");
        for (Book b : bookArrayList) {
            System.out.println(b.id + " " + b.name);
        }


        //Traversing list method 3: By ListIterator interface.
        System.out.println("Method 3 : By ListIterator interface");
        ListIterator<Book> listIterator = bookArrayList.listIterator(bookArrayList.size());  //Here, element iterates in reverse order
        while (listIterator.hasPrevious()) {
            Book book = (Book) listIterator.previous();
            System.out.println(book.id + " " + book.name);
        }

        //Traversing list method 4: By for loop.
        System.out.println("Method 4 : By for loop.");
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println(bookArrayList.get(i).id + " " + bookArrayList.get(i).name);
        }

        //Traversing list method 5: By forEach() method.   //The forEach() method is a new feature, introduced in Java 8.
        System.out.println("Method 5 : By forEach() method.");
        bookArrayList.forEach(book -> {  //Here, we are using lambda expression
            System.out.println(book.id + " " + book.name);
        });

        // Traversing list method 6: By forEachRemaining() method.
        System.out.println("Method 6 : By forEachRemaining() method.");
        Iterator<Book> itr2 = bookArrayList.iterator();
        itr2.forEachRemaining(book -> {  //Here, we are using lambda expression
            System.out.println(book.id + " " + book.name);
        });

        // Traversing list method 7: By lambda expression using foreach.
        System.out.println("Method 7 : Using Lambda Expression.");
        bookArrayList.forEach(f -> System.out.println(f.id + " " + f.name));

        // Filter the list
        System.out.println("Filter the Telugu Books ");
        // using lambda expression and Streams to filter data
        Stream<Book> filteredBooksStream = bookArrayList.stream()
                .filter(book -> book.name == "Telugu");
        filteredBooksStream.forEach(book -> System.out.println(book.id + " " + book.name)); // using lambda to iterate through collection


        // Traversing the list objects or the list using Method reference
        System.out.println("TRaversing the list using Method reference");
        bookArrayList.forEach(System.out::println); // // Iterate the book objects using method reference

        // Retreiving the list of books names using Function mapper of Streams (STream map)
        System.out.println("Retreiving the list of books names using Function mapper of Streams (STream map)");
        List<String> bookNames = bookArrayList.stream()
                .map(Book::getName)
                .collect(Collectors.toList());
        System.out.println(bookNames);

    }


}
