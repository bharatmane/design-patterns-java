package io.github.bharatmane.dp.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonInnerClassTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonInnerClass.class.getDeclaredConstructors();
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
        SingletonInnerClass singletonInnerClass1 = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass2 = SingletonInnerClass.getInstance();
        //When

        //Then
        assertThat(singletonInnerClass1).hasSameHashCodeAs(singletonInnerClass2);

    }
}
