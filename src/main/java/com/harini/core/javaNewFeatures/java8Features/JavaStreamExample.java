package com.harini.core.javaNewFeatures.java8Features;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import java.util.stream.Collectors;

/*
Java provides a new additional package in Java 8 called java.util.stream.
This package consists of classes, interfaces and enum which allows functional-style operations on the elements.
Streams can be used to filter, collect, print, and convert from one data structure to other.
Streams can be used to iterate any number of times
Stream provides predefined methods to deal with the logic you implement.

Note: Streams don't change the original data structure, they only provide the result as per the pipelined methods.
 */

// Stream Iterating Example
class StreamIterate {
    public static void main(String[] args) {
       // we are iterating, filtering and passing a limit to fix the iteration.
       /* Stream.iterate(1, x -> x + 1) // here seed is an initial value
                .limit(5)
                .forEach(System.out::println); */

        Stream.iterate(10,x->x+10)
                .filter(x->x<50 && x > 10)
                .limit(5)
                .forEach(System.out::println);

    }
}

// Filtering and Iterating Collection by using Stream
class FilterCollectionWithStreams{
    public static void main(String args[]) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Laptop", 30000f));
        list.add(new Product(2,"Tab", 20000f));
        list.add(new Product(3,"SmartPhone", 10000f));
        list.add(new Product(4,"BluetoothDevice", 5000f));
        list.add(new Product(5,"BluetoothDevice", 5000f));
        // Filtering the printing the filtered element
        List<Float> newProductPriceList = list.stream().filter(p->p.price>5000f) // filtering the data
                .map(p->p.price) // fetching the results
                .collect(Collectors.toList()); // collecting as list
            System.out.println(newProductPriceList); // printing only filtered product price

        //Filtering and Iterating Collection
        list.stream().filter(p->p.price > 10000f)
        .forEach(p->System.out.println(p.id + " " + p.name + " " + p.price));  // printing the product details with filtered price



        //Filtering and Iterating Collection
        list.stream().filter(p->p.price > 10000f)
                .forEach(p->System.out.println(p.id + " " + p.name + " " + p.price));
    }
}

//  Stream Example with different methods usage
/*
stream.forEach()
stream.filter()
stream.count()
stream.collect(Collectors.summingInt()
stream.min()
stream.max()
stream.collect(Collectors.toSet())
stream.collect(Collectors.toMap())


 */
class Product implements Comparable<Product>{
    int id;
    String name;
    Float price;
    Product(int id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(Product p) {
        return this.name.compareTo(p.name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}

public class JavaStreamExample {
    public static void main(String args[]) {
        var list = new ArrayList<Product>();
        //List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Laptop", 30000f));
        list.add(new Product(2,"Tab", 20000f));
        list.add(new Product(3,"SmartPhone", 10000f));
        list.add(new Product(4,"BluetoothDevice", 5000f));
        list.add(new Product(5,"BluetoothDevice", 5000f));

        // Print the list using streams
        System.out.println("All products");
        list.stream().forEach(product->System.out.println(product.id + " " + product.name + " " + product.price));


        //Filter the products with price < 20000
        System.out.println("Filtered products");
        list.stream()
                .filter(product->product.price<20000f)
                .forEach(product -> System.out.println(product.id + " " + product.name + " " + product.price));
        //count of all products
        System.out.println("Total count");
        long totalCount = list.stream().count();
        System.out.println(totalCount);
        // sum of all the products price
        System.out.println("Sum of all products price");
        Double sumOfAllProducts =  list.stream().collect(Collectors.summingDouble(p-> p.price)); // Sum by using Collectors Methods
        System.out.println(sumOfAllProducts);
        // Max and Min Product Price
        System.out.println("Max and Min Product Price");
        Product minPrice = list.stream().min((p1,p2) -> p1.price>p2.price ? 1 : -1).get(); //  min() is a terminal operation which combines stream elements and returns a summary result.
        Product maxPrice = list.stream().max((p1,p2) -> p1.price>p2.price ? 1 : -1).get();
        System.out.println("Minimum Price : " + minPrice.price);
        System.out.println("Maximum Price : " + maxPrice.price);
        // Convert list to set
        System.out.println("Convert list to Set");
        Set<Product> productSet = list.stream()
                .collect(Collectors.toSet()) ;// here it removes duplicates since it is a set
        System.out.println(productSet);
        // Convert list to map
        System.out.println("Convert list to Set");
        Map<Integer,String> productMap = list.stream()
                .collect(Collectors.toMap(p->p.id,p->p.name));
        System.out.println(productMap);

    }
    }


// reduce() Method in Collection
//This method takes a sequence of input elements and combines them into a single summary result by repeated operation.
// For example, finding the sum of numbers, or accumulating elements into a list.

// Example using reduce() method, which is used to sum of all the product prices.
class ReduceMethod{
    public static void main(String args[]) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Laptop", 30000f));
        list.add(new Product(2, "Tab", 20000f));
        list.add(new Product(3, "SmartPhone", 10000f));
        list.add(new Product(4, "BluetoothDevice", 5000f));
        // This is more compact approach for filtering data
        Float totalPrice = list.stream().map(p -> p.price)
                .reduce(0.0f, (sum, price) -> sum + price); //  accumulating price
        System.out.println(totalPrice);
        // More precise code
        Float totalPrice2 = list.stream().map(p -> p.price)
                .reduce(0.0f, Float::sum); //  accumulating price by referring the method of Flost class
        System.out.println(totalPrice2);
    }


}

// Method Reference in stream
class MethodReferenceInStream {
    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<Product>();

        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        List<Float> productPriceList =
                productsList.stream()
                        .filter(p -> p.price > 30000) // filtering data
                        .map(Product::getPrice)
                        //.map(Product::getPrice)         // fetching price by referring getPrice method
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList);
    }
}


/*
-- map()
Stream map() is an intermediate operation used to apply one given function to the elements of a stream.
It takes one function as its argument and applies it to each value of the stream and returns one fresh stream.
 */
// Example 1
class StreamsWithMap {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hi","hello","whatsup");
        System.out.println("Concat using For loop");
        for(String s : strings) {
            System.out.println("Say " + s);
        }

        System.out.println("Concat using Streams ");
        strings.stream().map(p->"Say " + p).forEach(System.out::println);
    }

}
// Example 2
class StreamsWithMap2 {
    private static Employee printExtraDetails(Employee emp) {
        return emp;

    }
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Ravi", "Consultant", 102, 80000f));
        employeeList.add(new Employee(2, "Kumar", "HR", 203, 50000f));
        employeeList.add(new Employee(3, "Anil", "Consultant", 102, 80000f));
        employeeList.add(new Employee(4, "Supriya", "Managing", 304, 90000f));
        System.out.println("Get emp names using streams with map");
        employeeList.stream()
               // .map(Employee::getEmpName)
                .map(StreamsWithMap2::printExtraDetails)
                .forEach(System.out::println);
    }

}

/*
class Main {
    private static UserLocation formatLocations(UserLocation location) {
        location.setLatitude(Double.parseDouble(String.format("%.3f", location.getLatitude())));
        location.setLongitude(Double.parseDouble(String.format("%.3f", location.getLongitude())));
        return location;
    }

    public static void main(String[] args) {
        UserLocation loc_1 = new UserLocation("user-1", 18.31142, 18.43345);
        UserLocation loc_2 = new UserLocation("user-2", 17.345603, 18.433456);
        UserLocation loc_3 = new UserLocation("user-1", 16.455453, 16.32212345);
        UserLocation loc_4 = new UserLocation("user-1", 16.3559894, 16.233456);
        UserLocation loc_5 = new UserLocation("user-2", 18.290876, 18.2234598);

        List < UserLocation > userLocations = Arrays.asList(loc_1, loc_2, loc_3, loc_4, loc_5);

        userLocations.stream().
                filter(loc -> loc.getUserName().equals("user-1"))
                .map(Main::formatLocations)
                .forEach(UserLocation::printDetails);
    }
}


class UserLocation {
    private final String userName;
    private Double latitude;
    private Double longitude;

    UserLocation(String name, Double lat, Double lon) {
        this.latitude = lat;
        this.longitude = lon;
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    void printDetails() {
        System.out.println("Latitude: " + latitude + " Longitude: " + longitude);
    }

*/




//  Practice Examples of Streams  1

class StreamEx {

    static Integer staticNumbers(Integer i) {
        return i +10;
    }
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("Hari", "Ravi", "chintu","HariKrishna","Thammanah");
        for (String s : strings) {
            System.out.println(s);
        }

        strings.forEach((n)->System.out.println(n));

        System.out.println();
        strings.stream().map(p->p.toLowerCase()).collect(Collectors.toList()).forEach(System.out::println); // converting to lowecase using map() and iterating
        strings.stream().filter(p->p.equals(p.toLowerCase())).forEach(System.out::println); // fiktereting only lowecase and iterating

        System.out.println();

        List<Integer> numbers = Arrays.asList(100,200,50,40,60);
        numbers.stream().filter(p->p>50).forEach(System.out::println); // filterting numbers and iterating
        System.out.println();

        Integer minValue = numbers.stream().min((p1,p2)->p1>p2?1:-1).get();
        System.out.println(minValue);

        System.out.println();

        numbers.stream().map(StreamEx::staticNumbers).forEach(System.out::println);  // Method Reference in stream


    }
}


//  Practice Examples of Streams  2


class StreamExample2 {
    public static void main(String args[]) {
        List<String> stringList = Arrays.asList("Ram","Seetha","","Lakshman");

        stringList.stream().filter(p->p.isEmpty());// uding lamda

       Long count =  stringList.stream().filter(String::isEmpty).count(); // using method reference
       System.out.println(count);

        Long count2 =  stringList.stream().filter(p->p.length()>3).count(); //  count of strings with length more than 3
        System.out.println(count2);

       String string = stringList.stream().map(p->p.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println(string);



    }
}