package io.github.bharatmane.dp.singleton;

public class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    private static class HelperHolder {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return HelperHolder.instance;
    }
}
