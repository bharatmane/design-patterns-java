package io.github.bharatmane.dp.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonOptimizedThreadSafeTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonOptimizedThreadSafe.class.getDeclaredConstructors();
        //Given

        //When

        //Then
        for (Constructor<?> constructor : constructors) {
            assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
        }
    }

    @Test
    @DisplayName("Should be able to have only one instance")
    void  shouldBeAbleToHaveOnlyOneInstance() throws InterruptedException {
        //Given
        SingletonOptimizedThreadSafe singletonOptimizedThreadSafe1 = SingletonOptimizedThreadSafe.getInstance();
        SingletonOptimizedThreadSafe singletonOptimizedThreadSafe2 = SingletonOptimizedThreadSafe.getInstance();
        //When

        //Then
        assertThat(singletonOptimizedThreadSafe1).hasSameHashCodeAs(singletonOptimizedThreadSafe2);
    }
    @Test
    @DisplayName("Should demonstrate that this is thread safe")
    void  shouldDemonstrateThatThisIsNotThreadSafe() throws InterruptedException {

        //Given
        final SingletonOptimizedThreadSafe[] singletonOptimizedThreadSafeArray = new SingletonOptimizedThreadSafe[2];
        //When
        Thread thread1 =
                new Thread(() -> {
                    try {
                        singletonOptimizedThreadSafeArray[0] = SingletonOptimizedThreadSafe.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        Thread thread2 =
                new Thread(() -> {
                    try {
                        singletonOptimizedThreadSafeArray[1] = SingletonOptimizedThreadSafe.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        //Then
        assertThat(singletonOptimizedThreadSafeArray[0]).hasSameHashCodeAs(singletonOptimizedThreadSafeArray[1]);
    }
}
