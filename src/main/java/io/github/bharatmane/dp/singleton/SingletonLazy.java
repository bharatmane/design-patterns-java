package io.github.bharatmane.dp.singleton;

public class SingletonLazy {
    private static SingletonLazy singletonInstance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance() throws InterruptedException {
        if(singletonInstance == null){
            Thread.sleep(100);
            singletonInstance = new SingletonLazy();
        }
        return singletonInstance;
    }

}
