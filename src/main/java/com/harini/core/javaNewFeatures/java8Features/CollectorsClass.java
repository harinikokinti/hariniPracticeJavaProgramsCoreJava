package com.harini.core.javaNewFeatures.java8Features;
/*
Collectors is a final class that extends Object class.
It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// The following are examples of using the predefined collectors to perform common mutable reduction tasks:
public class CollectorsClass {
    public static void main(String args[]) {

    }
}


class Employee {
    String empName;
    int empId;
    String departmentName;
    int departmentId;
    Float salary;

    Employee(int empId, String empName, String departmentName, int departmentId, Float salary) {
        this.empId = empId;
        this.empName = empName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}

class TestCollectors {

    public static void main(String args[]) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Ravi", "Consultant", 102, 80000f));
        employeeList.add(new Employee(2, "Kumar", "HR", 203, 50000f));
        employeeList.add(new Employee(3, "Anil", "Consultant", 102, 80000f));
        employeeList.add(new Employee(4, "Supriya", "Managing", 304, 90000f));
        System.out.println("Accumulate emp names into a list");
        List<String> empNamesList = employeeList.stream()
                .map(Employee::getEmpName)
                .collect(Collectors.toList());
        System.out.println(empNamesList);

        System.out.println("Accumulate emp names into a Tree Set");
        Set<String> empNamesSet = employeeList.stream()
                .map(Employee::getEmpName)
                .collect(Collectors.toSet());
        System.out.println(empNamesSet);

        System.out.println("Employee names separated by commas");
        String empName = employeeList.stream()
                .map(Employee::getEmpName)
                .map(Object::toString)
                .collect(Collectors.joining(","))

                ;
        System.out.println(empName);

        System.out.println("Sum of Salries of Employees");
        Double totalSumOfSalaries = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(totalSumOfSalaries);

        System.out.println("Employees grouped by department");
        Map<String, List<Employee>> employeesByDeptMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentName));
        employeesByDeptMap.forEach((String key, List<Employee> empList) ->
                {
                    List<String> empNames = empList.stream()
                            .map(Employee::getEmpName)
                            .collect(Collectors.toList());
                    System.out.println(key + "->" + empNames);
                }

        );

         System.out.println("Sum of employees Salary grouped by department");
         Map<String, Double> empSalarybyDept = employeeList.stream()
                 .collect(Collectors.groupingBy(Employee::getDepartmentName,Collectors.summingDouble(Employee::getSalary)));
        empSalarybyDept.forEach((String key, Double salary) -> System.out.println(key + "->" + salary)
                );


    }
}


