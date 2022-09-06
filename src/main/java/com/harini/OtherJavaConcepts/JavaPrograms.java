package com.harini.OtherJavaConcepts;

// Q. Write a Java program to get a number from the user and print whether it is positive or negative.

import java.util.Arrays;
import java.util.Scanner;

public class JavaPrograms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();

        if (number > 0)
            System.out.println("Positive Number");
        else if (number == 0)
            System.out.println("Comes under whole numbers");
        else
            System.out.println("Negative Number");
    }
}

// Q. Take three numbers from the user and print the greatest number.

class GreatestNumber {
    public static void main(String[] args) {
        System.out.println("Enter 3 numbers ");
        int arr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            arr[i] = number;
        }

        System.out.println("Print the numbers entered");
        for (int i : arr) {
            System.out.println(i);
        }

        int temp;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("The greatest number is : " + arr[arr.length - 1]);

    }
}

// Q. Write a Java program that keeps a number from the user and generates an integer between 1 and 7 and displays the name of the weekday.

class SwitchCase {
    public static void main(String[] args) {
        System.out.println("Enther the number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;

            default:
                System.out.println("Nothing to print");
        }

    }
}

// Q. Write a program to print the area of a rectangle by creating a class named 'Area' having two methods.
// First method named as 'setDim' takes length and breadth of rectangle as parameters and the second method named as
// 'getArea' returns the area of the rectangle. Length and breadth of rectangle are entered through keyboard.

// Q. Create a class named 'Student' with String variable 'name' and integer variable 'roll_no'. Assign the value of roll_no as '2' and that of

// Q. Write a Java program to sum values of an array

class ArraySum {
    public static void main(String[] args) {
        int arr[] = {5, 6, 2, 1, 9, 4};
        int sum = 0;

        for (int i : arr) {
            sum = sum + i;
        }

        System.out.println("The sum values of an array is :" + sum);
    }
}

// Q. Write a Java program to calculate the average value of array elements

class ArrayAverage {
    public static void main(String[] args) {
        double arr[] = {5, 6, 2, 1, 9, 4};
        double sum = 0;

        for (double i : arr) {
            sum = sum + i;
        }

        double average = sum / (arr.length);
        System.out.println("The average of an array is : " + average);

    }
}

// Q. Write a Java program to test if an array contains a specific value
class ArraySearch {
    public static void main(String[] args) {
        double arr[] = {5, 6, 2, 9, 7};
        System.out.println(Arrays.stream(arr).count());  //  to get total count
        System.out.println(Arrays.stream(arr).average());  // to get average
        Arrays.stream(arr).sorted().forEach(p -> System.out.println(p)); // print sorted output

        int key = 9;
        /*
        for(double i : arr) {
            if(i == key) {
                System.out.println("Number found : " + i);
                break;
            }
        }
        */


        // Arrays.stream(arr).filter();


    }
}

// Truncate Double value

class TruncateDoubleValue {
    public static void main(String[] args) {

        double value = 1212.12131131;
        System.out.println(value);

//        value = value * Math.pow(10, 2);
//        value = Math.floor(value);
//        value = value / Math.pow(10, 2);

        double value2 =Math.floor(value * Math.pow(10, 2)) / Math.pow(10, 2);

        System.out.println(value2);



    }

}