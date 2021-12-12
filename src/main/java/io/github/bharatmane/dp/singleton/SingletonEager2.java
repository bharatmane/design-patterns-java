package io.github.bharatmane.dp.singleton;

public class SingletonEager2 {
    private static final SingletonEager2 INSTANCE;
    private SingletonEager2(){}

    static{
        INSTANCE = new SingletonEager2();
    }

    public static SingletonEager2 getInstance() {
        return INSTANCE;
    }
}
