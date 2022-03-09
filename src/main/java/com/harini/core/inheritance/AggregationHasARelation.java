package com.harini.core.inheritance;
/*
If a class have an entity reference, it is known as Aggregation. Aggregation represents HAS-A relationship.
Example
Consider a situation, Employee object contains many informations such as id, name, emailId etc.
It contains one more object named address, which contains its own informations such as city, state, country, zipcode etc.

-- Usage of Aggregation
For Code Reusability.

--When use Aggregation?
Code reuse is also best achieved by aggregation when there is no is-a relationship.
Inheritance should be used only if the relationship is-a is maintained throughout the lifetime of the objects involved;
otherwise, aggregation is the best choice.

 */

class Employee
{
    int id;
    String name;
    Address address; // Here Address is a class

    Employee(int id,String name, Address address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display()
    {
        System.out.println("Employee details:" + id + " " + name );
        System.out.println("Address Details:" + address.city + " "  + address.state);
    }
}

class Address
{
    String city,state;
    Address(String city, String state)
    {
        this.city = city;
        this.state = state;
    }
}

public class AggregationHasARelation {
    public static void main(String args[])
    {

        Address address = new Address("Tirupathi","AP");

        Employee employee = new Employee(101, "XYZ", address);
        employee.display();
    }
}
