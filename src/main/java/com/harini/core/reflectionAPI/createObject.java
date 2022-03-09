package com.harini.core.reflectionAPI;

/*
Object creation is done using Class class and Constructor class


 */
// Creation of object without new keyword using Class.newInstance() method

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Sample {

    void show() {
        System.out.println("Method body of Sample class");
    }


}

public class createObject {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // using forName()
        Class c = Class.forName("com.harini.core.reflectionAPI.Sample");
        Sample sampleObject = (Sample) c.newInstance();
        sampleObject.show();

        // using only newInstance() with REflection API
        Class<Sample> c2 = Sample.class;
        Sample sampleObject2 = c2.newInstance();       //Using REflection API
        sampleObject2.show();
    }

}


// Creation of object without new keyword using Constructor.newInstance() method

class createObject2 {
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<SampleDemo> constructor = SampleDemo.class.getConstructor();
        SampleDemo sampleObject = (SampleDemo) constructor.newInstance();
        System.out.println(sampleObject);
        sampleObject.show();
    }
}