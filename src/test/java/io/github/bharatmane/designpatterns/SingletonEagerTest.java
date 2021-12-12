package io.github.bharatmane.designpatterns;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SingletonEagerTest {

    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonEager.class.getDeclaredConstructors();
        //Given

        //When

        //Then
        for (Constructor<?> constructor : constructors) {
            assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
        }
    }

    @Test
    @DisplayName("Should be able to have only one instance")
    void  shouldBeAbleToHaveOnlyOneInstance() {
        //Given
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();
        //When

        //Then
        assertThat(singletonEager1).hasSameHashCodeAs(singletonEager2);

    }

    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClassForEager2() {

        final Constructor<?>[] constructors = SingletonEager2.class.getDeclaredConstructors();
        //Given

        //When

        //Then
        for (Constructor<?> constructor : constructors) {
            assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
        }
    }

    @Test
    @DisplayName("Should be able to have only one instance")
    void  shouldBeAbleToHaveOnlyOneInstancesForEager2() {
        //Given
        SingletonEager2 singletonEager1 = SingletonEager2.getInstance();
        SingletonEager2 singletonEager2 = SingletonEager2.getInstance();
        //When

        //Then
        assertThat(singletonEager1).hasSameHashCodeAs(singletonEager2);

    }

    @Test
    @DisplayName("Should demonstrate that this is not thread safe")
    void  shouldDemonstrateThatThisIsNotThreadSafe() {
        //Given
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();
        //When

        //Then
        assertThat(singletonEager1).hasSameHashCodeAs(singletonEager2);

    }

}
