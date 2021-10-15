package com.harini.core.javaNewFeatures.java4and5Features;
/*
4. static import
        The static import feature of Java 5 facilitate the java programmer to access any static member of a class directly.
        There is no need to qualify it by the class name.

        --Advantage of static import:
        Less coding is required if you have access any static member of a class oftenly.

        Disadvantage of static import:
        If you overuse the static import feature, it makes the program unreadable and unmaintainable.

        Difference between import and static import?
        The import allows the java programmer to access classes of a package without package qualification whereas the static import feature allows
        to access the static members of a class without the class qualification.
        The import provides accessibility to classes and interface whereas static import provides accessibility to static members of the class.

        */

import static java.lang.System.*;
class StaticImportExample {
    public static void main(String args[]) {
        out.println("hi");
        out.println("Welcome"); //Now no need of System.out
    }
}