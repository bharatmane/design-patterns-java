package io.github.bharatmane.designpatterns;

public class SingletonEager {
    private static final SingletonEager INSTANCE = new SingletonEager();
    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}
