package com.harini.OtherJavaConcepts.employeeCRUD;

public class EmployeeService {
    private Employee[] employees = new Employee[10];
    private int index;

    public void addEmployee(Employee emp) {
        employees[index++] = emp;
    }

    public void viewEmployee(int empId) {
        System.out.println("  EmpId      Name        Age        Designation       Department        Country ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if(employees[i].getEmpId()==empId) {
                    System.out.println("    "  +  employees[i].getEmpId() + "       "  +  employees[i].getName() + "        " + employees[i].getAge() + "           " +
                            employees[i].getDesignation() + "           " + employees[i].getDepartment() + "                " +
                            employees[i].getCountry());
                }
            }
        }
    }

    public void viewallEmployees() {
        System.out.println("  EmpId     Name     Age        Designation         Department      Country ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("    "  +  employees[i].getEmpId() + "       "  +  employees[i].getName() + "        " + employees[i].getAge() + "           " +
                        employees[i].getDesignation() + "           " + employees[i].getDepartment() + "                " +
                        employees[i].getCountry());
            }
        }
    }

    public String deleteEmployee(int empId) {
        String status = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmpId() == empId) {
                    employees[i]=null;
                    status = "Deleted Succesfully";

                }
            }
        }

        return status;
    }


    public Employee findById(int empId) {
        Employee emp = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmpId() == empId) {
                     emp =  employees[i];
                }
            }
        }
        return emp;
    }
}
