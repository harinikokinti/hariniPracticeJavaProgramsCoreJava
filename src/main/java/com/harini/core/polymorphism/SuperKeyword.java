package com.harini.core.polymorphism;
/*
The super keyword in Java is a reference variable which is used to refer immediate parent class object.
Whenever you create the instance of subclass, an instance of parent class is created implicitly which is referred by super reference variable.

--Usage:
1. super can be used to refer immediate parent class instance variable. It is used if parent class and child class have same fields.
2. super can be used to invoke immediate parent class method.It should be used if subclass contains the same method as parent class.
   In other words, it is used if method is overridden.
3. super() can be used to invoke immediate parent class constructor. super() is added in each class constructor automatically by compiler if there is no super() or this().

 */

// super is used to refer immediate parent class instance variable, parent class method
class Animal
{
    String animalColor = "White";
    void eat()
    {
        System.out.println("Animal Eating");
    }
}

class Dog extends Animal {
    String animalColor = "Black";
    void bark()
    {
        System.out.println("Barking");
        System.out.println("The color of the animal is:" + super.animalColor); //  here super is used to access parent class instance varibale animalcolor.
        //Parent and child class must have same instance variable
    }
    void eat() {
        System.out.println("Dog Eating");
        super.eat(); // using super keyword, the parent class method is invoked. Here also both parent and child must have same method
        // and the method must be overriden in child class
    }


}

public class SuperKeyword {
    public static void main(String args[])
    {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

    }

}


// super can be used to invoke parent class constructor

class Animal2 {
    Animal2(){ System.out.println("Animal's constructor");
    }
}

class Dog2 extends Animal2
{
    Dog2()
    {
        super(); // super() invokes the parent class constructor. Reusing parent constructor
        // super() is added in each class constructor automatically by compiler if there is no super() or this().
        System.out.print("Dog's cnstructor");
    }
}

class Test {
    public static void main(String args[]) {
        Dog2 dog2 = new Dog2();
    }
}

// Real world Example which uses super keyword
class Person{
    int id;
    String name;
    Person(int id,String name){
        this.id=id;
        this.name=name;
    }
}
class Emp extends Person{
    float salary;
    Emp(int id,String name,float salary){
        super(id,name);//reusing parent constructor
        this.salary=salary;
    }
    void display(){System.out.println(id+" "+name+" "+salary);}
}
class TestSuper5{
    public static void main(String[] args){
        Emp e1=new Emp(1,"ankit",45000f);
        e1.display();
    }}
