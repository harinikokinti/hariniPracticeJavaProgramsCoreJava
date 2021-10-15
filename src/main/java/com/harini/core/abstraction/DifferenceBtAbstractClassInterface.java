package com.harini.core.abstraction;
/*
Abstract class and interface both are used to achieve abstraction where we can declare the abstract methods.
Abstract class and interface both can't be instantiated.

--DIFFERENCES:
ABSTRACT CLASS                                                                                  INTERFACE
Abstract class can have abstract and non-abstract methods.	                    Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
2) Abstract class doesn't support multiple inheritance.	                        Interface supports multiple inheritance.
3) Abstract class can have final, non-final, static and non-static variables.	Interface has only static and final variables.
4) Abstract class can provide the implementation of interface.	                Interface can't provide the implementation of abstract class.
5) The abstract keyword is used to declare abstract class.	                    The interface keyword is used to declare interface.
6) An abstract class can extend another Java class and implement                An interface can extend another Java interface only
multiple Java interfaces.	.
7) An abstract class can be extended using keyword "extends".	                An interface can be implemented using keyword "implements".
8) A Java abstract class can have class members like private, protected, etc.	Members of a Java interface are public by default.


Simply, abstract class achieves partial abstraction (0 to 100%) whereas interface achieves fully abstraction (100%).

 */

public class DifferenceBtAbstractClassInterface {
}
