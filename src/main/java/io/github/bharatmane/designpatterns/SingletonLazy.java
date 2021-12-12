package io.github.bharatmane.designpatterns;

public class SingletonLazy {
    private static SingletonLazy singletonInstance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance() throws InterruptedException {
        if(singletonInstance == null){
            Thread.sleep(10);
            singletonInstance = new SingletonLazy();
        }
        return singletonInstance;
    }

}
