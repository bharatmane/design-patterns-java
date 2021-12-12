package io.github.bharatmane.dp.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SingletonWithSerializationReadResolveTest {
    @Test
    @DisplayName("Should not be able to create instance from outside the class")
    void  shouldNotBeAbleToCreateInstanceFromOutsideTheClass() {

        final Constructor<?>[] constructors = SingletonWithSerializationReadResolve.class.getDeclaredConstructors();
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
        SingletonWithSerializationReadResolve instance1 = SingletonWithSerializationReadResolve.getInstance("Singleton");
        SingletonWithSerializationReadResolve instance2 = SingletonWithSerializationReadResolve.getInstance("Singleton");
        //When

        //Then
        assertThat(instance1).hasSameHashCodeAs(instance2);

    }

    @Test
    @DisplayName("Should have same instances when Deserialized")
    void  shouldHaveSameInstancesWhenDeserialized() throws IOException, ClassNotFoundException {

        //Given
        SingletonWithSerializationReadResolve instance1 = SingletonWithSerializationReadResolve.getInstance("Singleton1");

        //When
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SingletonWithSerializationReadResolve.ser"));
        out.writeObject(instance1);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonWithSerializationReadResolve.ser"));
        SingletonWithSerializationReadResolve instance2 = (SingletonWithSerializationReadResolve) in .readObject();
        in .close();

        //Then
        assertThat(instance1).hasSameHashCodeAs(instance2);

    }
}
