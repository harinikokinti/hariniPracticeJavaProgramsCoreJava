package com.harini.core.javaNewFeatures.java4and5Features;
/*
Enums
The Enum in Java is a data type which contains a fixed set of constants.
It can be used for
days of the week (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY) ,
directions (NORTH, SOUTH, EAST, and WEST),
season (SPRING, SUMMER, WINTER, and AUTUMN or FALL),
colors (RED, YELLOW, BLUE, GREEN, WHITE, and BLACK) etc.
According to the Java naming conventions, we should have all constants in capital letters. So, we have enum constants in capital letters.

Points to remember for Java Enum

1. The Java enum constants are static and final implicitly.
2. The enum data type (also known as Enumerated Data Type) is used to define an enum in Java.
3. Enum improves type safety
4. Enum can be easily used in switch
5. Enum can be traversed
6. Enum can have fields, constructors(private) and methods
7. Enum may implement many interfaces but cannot extend any class because it internally extends Enum class.
8. We cannot create the instance of Enum by new keyword because it contains private constructors only.
9. we can have abstract methods and can provide the implementation of these methods.
10. Java compiler internally adds values(), valueOf() and ordinal() methods within the enum at compile time.
    It internally creates a static and final class for the enum.
     vaules() : returns an array containing all the values of the enum.
     valueOf() : returns the value of given constant enum.
     ordinal() : returns the index of the enum value
11. The enum can be defined within or outside the class because it is similar to a class. The semicolon (;) at the end of the enum constants are optional.

 */

// enum outside the class

enum Season{WINTER, SUMMER, SPRING, AUTUMN, FALL ;} // here semicolon is optional

public class EnumsExample {
    public static void main(String args[]) {
        for(Season s : Season.values())
        {
            System.out.println(s);
        }
    }
}


// enum inside the class


class EnumInsideClass {
    enum Season{WINTER, SUMMER, SPRING, AUTUMN, FALL ;} // here semicolon is optional
    public static void main(String args[]) {
        for(Season s : Season.values())
        {
            System.out.println(s);
        }

        System.out.println("Value of WINTER is  " + Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is  " + Season.valueOf("WINTER").ordinal());
        System.out.println("Index of FALL is  " + Season.valueOf("FALL").ordinal());
    }
}

// main method inside Enum
// If you put main() method inside the enum, you can run the enum directly.
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    public static void main(String[] args) {
        Day d=Day.FRIDAY;
        System.out.println(d);
    }
}

// Initializing specific values to the enum constants

class EnumWithIntialValues {
    enum Season {
        WINTER(3), SUMMER(3), SPRING(2), AUTUMN(2), FALL(2);

        private int value;

        private Season(int value) {
            this.value = value;
        }
        }

        public static void main(String args[]) {
            for(Season s : Season.values()) {
                System.out.println(s + " " + " Value is :" + s.value);
            }
        }
    }

// Enum in a switch statement

class EnumSwitchCaseExample {
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    public static void main(String args[]) {
        Day d = Day.MONDAY;
        switch (d) {
            case MONDAY:
                System.out.println("monday");
                break;
            case TUESDAY:
                System.out.println("tuesday");
                break;
            case WEDNESDAY:
                System.out.println("wednesday");
                break;
            default:
                System.out.println("other day");
        }
    }
}





