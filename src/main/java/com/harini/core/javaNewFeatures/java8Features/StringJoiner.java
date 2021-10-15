package com.harini.core.javaNewFeatures.java8Features;
/*
StringJoiner
Java added a new final class StringJoiner in java.util package.
It is used to construct a sequence of characters separated by a delimiter.
Now, you can create string by passing delimiters like comma(,), hyphen(-) etc. You can also pass prefix and suffix to the char sequence.
--Constructors:
StringJoiner(CharSequence delimiter)
StringJoiner(CharSequence delimiter,CharSequence prefix,CharSequence suffix)
--Methods
add()
merge()
length()
SetEmptyValue()
 */
// StringJoiner Example
/*
public class StringJoiner {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(); // passing comma(,) as delimiter
        joinNames.

        // Adding values to StringJoiner
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");
        joinNames.add("Raheem");

        System.out.println(joinNames);
    }
}

*/