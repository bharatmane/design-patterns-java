package io.github.bharatmane.dp.singleton;

public class SingletonOptimizedThreadSafe {
    private static SingletonOptimizedThreadSafe singletonInstance;

    private SingletonOptimizedThreadSafe(){}

    public static SingletonOptimizedThreadSafe getInstance() throws InterruptedException {
        SingletonOptimizedThreadSafe localRef = singletonInstance;
        if(singletonInstance == null){
            synchronized(SingletonOptimizedThreadSafe.class) {
                localRef = singletonInstance;
                if(localRef == null ) {
                    Thread.sleep(10);
                    singletonInstance = localRef = new SingletonOptimizedThreadSafe();
                }
            }
        }
        return localRef;
    }
}
