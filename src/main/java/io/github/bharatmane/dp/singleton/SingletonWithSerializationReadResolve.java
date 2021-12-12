package io.github.bharatmane.dp.singleton;

import java.io.Serializable;

public class SingletonWithSerializationReadResolve implements Serializable {
    private static SingletonWithSerializationReadResolve singletonInstance;
    private static String name;
    private SingletonWithSerializationReadResolve(){}

    public static SingletonWithSerializationReadResolve getInstance(String name){
        if(singletonInstance == null){
            SingletonWithSerializationReadResolve.name = name;
            singletonInstance = new SingletonWithSerializationReadResolve();
        }
        return singletonInstance;
    }
    protected Object readResolve() {
        return getInstance("differentName");
    }
}
