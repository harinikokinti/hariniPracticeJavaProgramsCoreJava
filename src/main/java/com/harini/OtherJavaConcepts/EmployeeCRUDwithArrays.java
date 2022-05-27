package com.harini.OtherJavaConcepts;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String empId;
    private String name;
    private String age;
    private String designation;
    private String department;
    private String country;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


/*
    public  void addEmployee(Employee employee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee Name: ");
        String empName = sc.next();
        employee.setName(empName);

        System.out.println("Enter employee Age: ");
        String age = sc.next();
        employee.setAge(age);

        System.out.println("Enter employee Designation: ");
        String designation = sc.next();
        employee.setDesignation(designation);

        System.out.println("Enter employee Department: ");
        String department = sc.next();
        employee.setDepartment(department);

        System.out.println("Enter employee Country: ");
        String country = sc.next();
        employee.setCountry(country);
    }

    public  void getEmployee() {
        Employee employee = new Employee();
        System.out.println(" Name     Age      Designation          Department      Country");
        System.out.println(employee.getName() + "  " + employee.getAge() + "    " + employee.getDesignation() +
                "     " + employee.getDepartment() + "   " + employee.getCountry());
    } */



}




public class EmployeeCRUDwithArrays {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[6];

       // ArrayList<Employee> empList = new ArrayList<>();




        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

        int n = 0;
     do {

            System.out.println("Enter the option: ");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Exit");
            int number  = sc.nextInt();
            switch(number) {
                case 1:

                    //Scanner sc = new Scanner(System.in);
                    System.out.println("Enter employee Name: ");
                    String empName = sc.next();
                    employee.setName(empName);

                    System.out.println("Enter employee Age: ");
                    String age = sc.next();
                    employee.setAge(age);

                    System.out.println("Enter employee Designation: ");
                    String designation = sc.next();
                    employee.setDesignation(designation);

                    System.out.println("Enter employee Department: ");
                    String department = sc.next();
                    employee.setDepartment(department);

                    System.out.println("Enter employee Country: ");
                    String country = sc.next();
                    employee.setCountry(country);
                    empArray[0] = employee;



                    break;
                case 2:

                    System.out.println(" Name    Age  Designation       Department    Country");
                    System.out.println("  " + empArray[0].getName()+ "   " + empArray[0].getAge() + "    " + empArray[0].getDesignation() +
                            "     " + empArray[0].getDepartment() + "   " + empArray[0].getCountry());
                    break;
                case 3:
                    return;
            }

            n++;
        } while(n<3) ;




    }
}
