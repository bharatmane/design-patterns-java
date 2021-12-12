package io.github.bharatmane.dp.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonWithSerializationTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonWithSerialization.class.getDeclaredConstructors();
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
        SingletonWithSerialization singletonWithSerialization1 = SingletonWithSerialization.getInstance();
        SingletonWithSerialization singletonWithSerialization2 = SingletonWithSerialization.getInstance();
        //When

        //Then
        assertThat(singletonWithSerialization1).hasSameHashCodeAs(singletonWithSerialization2);

    }

    @Test
    @DisplayName("Should have different instances when Deserialized")
    void  shouldHaveDifferentInstancesWhenDeserialized() throws IOException, ClassNotFoundException {

        //Given
        SingletonWithSerialization singletonWithSerialization1 = SingletonWithSerialization.getInstance();

        //When
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SingletonWithSerialization.ser"));
        out.writeObject(singletonWithSerialization1);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonWithSerialization.ser"));
        SingletonWithSerialization singletonWithSerialization2 = (SingletonWithSerialization) in .readObject();
        in .close();

        //Then
        assertThat(singletonWithSerialization1).doesNotHaveSameHashCodeAs(singletonWithSerialization2);

    }
}
