package io.github.bharatmane.dp.singleton;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonLazyTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonLazy.class.getDeclaredConstructors();
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
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        //When

        //Then
        assertThat(singletonLazy1).hasSameHashCodeAs(singletonLazy2);
    }

    @Test
    @DisplayName("Should demonstrate that this is not thread safe")
    void  shouldDemonstrateThatThisIsNotThreadSafe() throws InterruptedException {

        //Given
        final SingletonLazy[] singletonLazyArray = new SingletonLazy[2];
        //When
        Thread thread1 =
               new Thread(() -> {
                    try {
                        singletonLazyArray[0] = SingletonLazy.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        Thread thread2 =
                new Thread(() -> {
                    try {
                        singletonLazyArray[1] = SingletonLazy.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
       thread1.start();
        thread2.start();
       Thread.sleep(2000);
        //Then
        assertThat(singletonLazyArray[0]).doesNotHaveSameHashCodeAs(singletonLazyArray[1]);

    }
}
