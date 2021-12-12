package io.github.bharatmane.dp.singleton;

import java.io.Serializable;

public class SingletonWithSerialization implements Serializable {
    private static SingletonWithSerialization singletonInstance;

    private SingletonWithSerialization(){}

    public static SingletonWithSerialization getInstance(){
        if(singletonInstance == null){
            singletonInstance = new SingletonWithSerialization();
        }
        return singletonInstance;
    }
}
