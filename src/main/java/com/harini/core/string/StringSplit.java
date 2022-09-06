package com.harini.core.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplit {
    public static void main(String[] args) {
        String str1 = "jhonny@gmail.com";

        // create a string array and assign the splitted strings
        String str2[] = str1.split("@"); // split if @ is seen
        System.out.println(Arrays.toString(str2));

        StringTokenizer tokenizer = new StringTokenizer(str1, "@");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}


// pgm 2
class Student {
    private int studentID;
    private String studentName;
    private int age;
    private String department;
    private String designation;
    private String country;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class TestStudent {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("/Users/dhilli/codebase/lowes_javabootcamp-dih-batch2/labs/corejava/core-java-labs/src/com/labs/java/inputFile.txt"));
            out = new PrintWriter(new FileWriter("/Users/dhilli/codebase/lowes_javabootcamp-dih-batch2/labs/corejava/core-java-labs/src/com/labs/java/outputFile.txt"));

            String line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(",");
                Student st = new Student();
                st.setStudentID(Integer.parseInt(tokens[0]));
                st.setStudentName(tokens[1]);
                st.setAge(Integer.parseInt(tokens[2]));
                st.setDepartment(tokens[3]);
                st.setDesignation(tokens[4]);
                st.setCountry(tokens[5]);
                students.add(st);
                //    out.write(line);
                //  out.write("\n");
            }

            System.out.println("Students List ");
        students.forEach(p-> System.out.println(p.getStudentID() + " " + p.getStudentName() + " " + p.getAge() + " " +
                p.getDepartment() + " " + p.getDesignation() + " " + p.getCountry()));

        //    out.flush();

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }




    }
}
