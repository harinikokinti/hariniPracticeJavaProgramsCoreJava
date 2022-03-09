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


/*
collect

java.util.stream.Stream<T> public abstract <R, A> R collect(java.util.stream.Collector<? super T, A, R> collector)
Performs a mutable reduction operation on the elements of this stream using a Collector. A Collector encapsulates the functions used as arguments to collect(Supplier, BiConsumer, BiConsumer), allowing for reuse of collection strategies and composition of collect operations such as multiple-level grouping or partitioning.
If the stream is parallel, and the Collector is concurrent, and either the stream is unordered or the collector is unordered, then a concurrent reduction will be performed (see Collector for details on concurrent reduction.)
This is a terminal operation.
When executed in parallel, multiple intermediate results may be instantiated, populated, and merged so as to maintain isolation of mutable data structures. Therefore, even when executed in parallel with non-thread-safe data structures (such as ArrayList), no additional synchronization is needed for a parallel reduction.

Params:
collector – the Collector describing the reduction
Type parameters:
<R> – the type of the result
<A> – the intermediate accumulation type of the Collector
Returns:
the result of the reduction
API Note:
The following will accumulate strings into an ArrayList:

     List<String> asList = stringStream.collect(Collectors.toList());

The following will classify Person objects by city:

     Map<String, List<Person>> peopleByCity
         = personStream.collect(Collectors.groupingBy(Person::getCity));

The following will classify Person objects by state and city, cascading two Collectors together:

     Map<String, Map<String, List<Person>>> peopleByStateAndCity
         = personStream.collect(Collectors.groupingBy(Person::getState,
                                                      Collectors.groupingBy(Person::getCity)));

See Also:
collect(Supplier, BiConsumer, BiConsumer), Collectors
  < 11 >



 */

