//package com.harini.core.fileHandling;
//
//
//import java.io.*;
//import java.util.Scanner;
//
//
//// Program to write and read file using Byte Stream classes
//public class FileOperations {
//    public static void main(String args[])  throws Exception
//    {
//        File f1 = new File("file1.txt");
//        FileOutputStream fos = new FileOutputStream(f1);
//        DataOutputStream dos = new DataOutputStream(fos);
//        dos.writeUTF("Hi Welcome");  //  write data into the file
//
//        FileInputStream fis = new FileInputStream(f1);
//        DataInputStream dis = new DataInputStream(fis);
//        String str = dis.readUTF();  //  to read the file
//
//        System.out.println("Read using FileInputStream " + str);
//
//    }
//}
//
//
//// Program to write and read file using Character Stream classes
//
//class FileOperationsCharStream  {
//    public static void main(String args[])  throws Exception
//    {
////        File f2 = new File("file1.txt");
////        FileWriter fw = new FileWriter(f2);
////        fw.write("Hi Hello how are you ");
////        fw.close();
//
//        FileReader fr = new FileReader(f2);
////        char[] array = new char[100];
////        fr.read(array);
////        System.out.println("Read using FileReader " );
////            System.out.println( array);
//
//        int c;
//        while ((c = fr.read()) != -1) {
//            System.out.println((char)c);
//            fw.write(c);
//        }
//
//        fr.close();
//
//       File f3 = new File("file2.txt");
//       Scanner sc = new Scanner(f3);
//
//       System.out.println("Read using Scanner");
//       while(sc.hasNext()) {
//           String str = sc.next();
//           System.out.println( str);
//       }
//       sc.close();
//
//
//    }
//}