package com.harini.core.encapsulation;
/*
A java package is a group of similar types of classes, interfaces and sub-packages.
1. Builtin Packages: java, lang, awt, javax, swing, net, io, util, sql etc.
2. Userdefined Packages:

--Usage:
1) Java package is used to categorize the classes and interfaces so that they can be easily maintained.
2) Java package provides access protection.
3) Java package removes naming collision.

--There are three ways to access the package from outside the package.
import package.*;
import package.classname;
fully qualified name.

 If you import a package, subpackages will not be imported.
 The standard of defining package is domain.company.package e.g. com.javatpoint.bean or org.sssit.dao.
 There can be only one public class in a java source file and it must be saved by the public class name.

How to put two public classes in a package?
If you want to put two public classes in a package, have two java source files containing one public class, but keep the package name same.


What is the difference between import and static import?
The import provides accessibility to classes and interface whereas static import provides accessibility to static members of the class.
Ex of static import:
import static java.lang.System.*;
out.println("Hello");//Now no need of System.out

 */

// Package class
public class PackageClass {
    public static void main(String args[]){
        Package[] p = Package.getPackages();
        p.getClass();
        System.out.println(p.getClass());

    }
    }
