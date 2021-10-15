package com.harini.core.arrays;
/*
Java array is an object which contains elements of a similar data type which has contiguos memory location.
Java array is an index based with fixed size.
It inherits the Object class, and implements the Serializable as well as Cloneable interfaces.

--There are two types of array.
Single Dimensional Array
Multidimensional Array

--Advantages
Code Optimization: It makes the code optimized, we can retrieve or sort the data efficiently.
Random access: We can get any data located at an index position.

--Disadvantages
Size Limit: We can store only the fixed size of elements in the array.
It doesn't grow its size at runtime. To solve this problem, collection framework is used in Java which grows automatically.

-- Multidimensional Array in Java
Data is stored in row and column based index (also known as matrix form).

Example to instantiate Multidimensional Array in Java
int[][] arr=new int[3][3]; //3 row and 3 column

Example to initialize :
arr[0][0]=1;
arr[0][1]=2;
arr[0][2]=3;
arr[1][0]=4;
arr[1][1]=5;
arr[1][2]=6;
arr[2][0]=7;
arr[2][1]=8;
arr[2][2]=9;

-- Jagged Array:
 If we are creating odd number of columns in a 2D array, it is known as a jagged array.
 In other words, it is an array of arrays with different number of columns.

-- What is the class name of Java array?
In Java, an array is an object. For array object, a proxy class is created whose name can be obtained by getClass().getName() method on the object.

-- Cloning an Array in Java
        Since, Java array implements the Cloneable interface,
        we can create the clone of the Java array.
         If we create the clone of a single-dimensional array, it creates the deep copy of the Java array.
         It means, it will copy the actual value. But, if we create the clone of a multidimensional array, it creates the shallow
         copy of the Java array which means it copies the references.

-- Copying a Java Array
    We can copy an array to another by the arraycopy() method of System class.
    Syntax of arraycopy method
    public static void arraycopy(
        Object src, int srcPos,Object dest, int destPos, int length
        )
 */
// Single Dimensional Array
public class ArrayExample {
    public static void main(String args[]) {
        //declare and initialize 2 arrays in 2 ways
        int a[] = {1,2,3,4};
        int b[] = new int[3];
        b[0] = 1;
        b[1] = 2;
        b[2] = 3;
        // retrieve the 2 arrays using for loop and for each loop
        for(int i = 0; i<=3; i++){
            System.out.println("First Array : " + a[i]);
        }
        for(int i : b) {
            System.out.println("Second Array: " + i);
        }
    }
}

// Passing Array to a method
class Sample {
    void min(int a[]) {
        int min = a[0];
        for(int i = 1; i<4 ; i++) {  //  Find the minimum of the array elements
            if(min > a[i]) {
                min = a[i];
            }
        }
        System.out.println("The minimum number in the array is : " + min);
    }
}

class TestMin {
    public static void main(String args[]) {
        Sample sample = new Sample();
        int a[] = {3,5,1,8}; //declaring and initializing an array
        sample.min(a); //passing array to method

        sample.min(new int[]{10,22,30,8}); ;//passing anonymous array to method
    }
}

//Java Program to illustrate the use of multidimensional array
class Testarray3{
public static void main(String args[]){
//declaring and initializing 2D array
int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
//printing 2D array
for(int i=0;i<3;i++){   //  for rows
 for(int j=0;j<3;j++){   // for columns
   System.out.print(arr[i][j]+" ");
 }
 System.out.println();
}
}}


//Java Program to illustrate the jagged array
class TestJaggedArray{
    public static void main(String[] args){
        //declaring a 2D array with odd columns
        int a[][] = new int[3][]; //  here we are not giving  the coloumn size
        a[0] = new int[3];
        a[1] = new int[4];
        a[2] = new int[2];
        // initialize the array elements
        int count = 0;
        for(int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[i].length; j++){
                a[i][j] = count++;
            }
        }

        //printing the data of a jagged array
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[i].length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();//new line
        }
    }
}



//Java Program to get the class name of array in Java
class Testarray4{
    public static void main(String args[]){
//declaration and initialization of array
        int arr[]={4,4,5};
//getting the class name of Java array
        Class c=arr.getClass();
        String name=c.getName();
//printing the class name of Java array
        System.out.println(name);

    }}



//  Example of Copying an Array in Java
//Java Program to copy a source array into a destination array in Java
class TestArrayCopyDemo {
    public static void main(String[] args) {
        //declaring a source array
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        //declaring a destination array
        char[] copyTo = new char[7];
        //copying array using System.arraycopy() method
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        //printing the destination array
        System.out.println(String.valueOf(copyTo));
    }
}


//Java Program to clone the array
class Testarray1{
    public static void main(String args[]){
        int arr[]={33,3,4,5};
        System.out.println("Printing original array:");
        for(int i:arr)
            System.out.println(i);

        System.out.println("Printing clone of the array:");
        int carr[]=arr.clone();
        for(int i:carr)
            System.out.println(i);

        System.out.println("Are both equal?");
        System.out.println(arr==carr);

    }
}