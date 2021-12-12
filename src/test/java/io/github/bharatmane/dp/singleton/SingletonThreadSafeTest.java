package io.github.bharatmane.dp.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonThreadSafeTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonThreadSafe.class.getDeclaredConstructors();
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
        SingletonThreadSafe singletonThreadSafe1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe singletonThreadSafe2 = SingletonThreadSafe.getInstance();
        //When

        //Then
        assertThat(singletonThreadSafe1).hasSameHashCodeAs(singletonThreadSafe2);
    }
    @Test
    @DisplayName("Should demonstrate that this is thread safe")
    void  shouldDemonstrateThatThisIsNotThreadSafe() throws InterruptedException {

        //Given
        final SingletonThreadSafe[] singletonThreadSafeArray = new SingletonThreadSafe[2];
        //When
        Thread thread1 =
                new Thread(() -> {
                    try {
                        singletonThreadSafeArray[0] = SingletonThreadSafe.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        Thread thread2 =
                new Thread(() -> {
                    try {
                        singletonThreadSafeArray[1] = SingletonThreadSafe.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        //Then
        assertThat(singletonThreadSafeArray[0]).hasSameHashCodeAs(singletonThreadSafeArray[1]);
    }
}
