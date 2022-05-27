package com.harini.OtherJavaConcepts;
/*
-- Class.forName()
It loads the class dynamically where we doesn't know the class name before hand.
Once the class is loaded we will use newInstance() method to create the object dynamically.
It also executes static block after loading the class

-- In JDBC, class.forName() method is used to register the Driver class. It loads the driver class dynamically

 */
class Demo {
    static {
        System.out.println("This is static block");
    }

    // instance block
    {
        System.out.println("This is instance block");
    }
}


public class ClassForName {

    public static void main(String args[]) throws ClassNotFoundException {
       Class.forName("com.harini.OtherJavaConcepts.Demo");  // it runs the static block automatically
    }
}


/*
class jdbcexample{
public static void main(String args[])
{
Class.forName("org.postgresql.Driver");  // forName() method used to register the Driver class. It loads the driver class dynamically
Connection con = DriverManager.getConnection(url, root, password); // connect to the database using getConnection() method of Driver Maanger class which returns a connection object
Statement stmt = con.createStatement(); // create statement object using createStatement() method  present in the Connection interface , statement object is used to execute the queries
ResultSet rs = stmt.executeQuery(sql); // executeQuery() method of Statement interface to create ResultSet object, which is used to pull the records from the database(execute the query)
while(rs.next()) {
System.oout.println(rs.getInt(1) + “ “ + rs.getString(2));
    con.Close() ; //. By closing connection object statement and ResultSet will be closed automatically.
}
}


 */