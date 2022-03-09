package com.harini.core.thisKeywordExamples;
// this can be passed as an argument in the method call.It is mainly used in the event handling

// this as an argument in a method.
class Animal {
    String  animalName;
    String animaltype;

    void display(Animal animal)
    {
      System.out.println("Method is invoked or called");
    }

    Animal(){
        display(this);
    }
}

public class ThisAsArgument {
    public static void main(String args[])
    {

        Animal animal = new Animal();
    }
}



// this: to pass as argument in the constructor call. It is useful if we have to use one object in multiple classes.
// not understood well this concept


class Class1
{
    Class2 class2Object;

    Class1(Class2 class2Object)
    {
        this.class2Object = class2Object;
    }
    void display()
    {
        class2Object.printthis();
    }



}

class Class2
{
void printthis()
{
    System.out.println("hi all");
}
}

class Class3
{
    public static void main(String args[])
    {
        Class2 class2Object = new Class2();
        Class1 class1Object = new Class1(class2Object);
        class1Object.display();


    }
}




// this keyword can be used to return current class instance


class A
{
    void method1()
    {
        System.out.println(this); // return the current class object.  prints the reference ID
    }
}

class B
{
    public static void main(String args[])
    {
        A aObject  = new A();
        aObject.method1();

        System.out.println(aObject); // here also it should be same.  prints the reference ID
    }
}


// Example2 of this keyword that you return as a statement from the method
class Sample{
    Sample getSample(){
        return this;
    }
    void msg(){System.out.println("Hello java");}
}
class Test1{
    public static void main(String args[]){
        new Sample().getSample().msg();
    }
}