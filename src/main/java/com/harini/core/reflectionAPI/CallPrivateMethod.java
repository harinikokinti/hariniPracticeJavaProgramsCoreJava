package com.harini.core.reflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sample2 {

    private void show() {
        System.out.println("Hi this is  a private method with no params ");
    }

    void showParam(String message) {
        System.out.println("Method body of Sample class: " +  message);
    }

}

public class CallPrivateMethod {

    public static void main(String args[]) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        //Class c = Class.forName("A");
        Class c = Sample2.class;
        Sample2 sample2 = (Sample2) c.newInstance();
        Method m =c.getDeclaredMethod("show", null);
        m.setAccessible(true);  // make it accessible since it is a private method
        m.invoke(sample2, null);

        Method m2 =c.getDeclaredMethod("showParam", String.class);
        m2.setAccessible(true);
        m2.invoke(sample2, "Hello");
    }
}
