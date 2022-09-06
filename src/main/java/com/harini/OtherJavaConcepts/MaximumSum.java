package com.harini.OtherJavaConcepts;

//  To get pair elements whose sun is maximum in the array
// which two nos give max sum in array

public class MaximumSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5};
        int num1 = 0, num2 = 0;

        int sum = 0, sumNew;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                sumNew = a[i] + a[j];
                if (sumNew > sum) {
                    num1 = a[i];
                    num2 = a[j];
                    sum = sumNew;
                }
            }
        }

        System.out.println("the number pair with max sum: ");
        System.out.println(num1 + " " + num2);
    }
}

// return maximum number from the given  digit Ex:  296, return 962

class MaxNumberFromDigit {
    public static void main(String[] args) {
        int number = 216;


        int[] digits = new int[3];

        digits[0] = number / 100; // 216/100 = 2
        int digit1 = number % 100;  // 16
        digits[1] = digit1 / 10; // 16/10 = 1
        digits[2] = number % 10; // 6

        System.out.println("Print the number as a single digit: " + number);
        System.out.println("Print the number as an array");
        for (int i : digits) {
            System.out.print(i + " ");
        }

        int temp;
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] > digits[j]) {
                    temp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("After sorting in desending order");
        for (int i : digits) {
            System.out.print(i + " ");
        }

//        int sum = 0;
//        int x = 0, y = 0, z = 0;
//        for (int i = 0; i < digits.length; i++) {
//
//            if (i == 0) {
//                x = digits[i] * 100;
//            }
//            if (i == 1) {
//                y = digits[i] * 10;
//            }
//            if (i == 2) {
//                z = digits[i];
//            }
//        }

//        int i,j, sum = 0;
//        for( i=digits.length-1, j=1; i>=0; i--, j=j*10 ) {
//            sum = sum + (digits[i] * j);
//        }

        int i,j, sum = 0;
        for( i=0; i<digits.length; i++) {
            sum = (int) (sum + (digits[i] * Math.pow(10,i)));
           // System.out.println("print " + Math.pow(10,i));
        }

        System.out.println();
        System.out.println("The largest number from 216  is : " + sum);
    }
}