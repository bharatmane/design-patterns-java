package io.github.bharatmane.dp.singleton;

public class SingletonThreadSafe {
    private static SingletonThreadSafe singletonInstance;

    private SingletonThreadSafe(){}

    public static synchronized SingletonThreadSafe getInstance() throws InterruptedException {
        if(singletonInstance == null){
            Thread.sleep(10);
            singletonInstance = new SingletonThreadSafe();
        }
        return singletonInstance;
    }
}
