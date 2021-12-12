
<h1>  
  <br />  
    Design Patterns Using Java  
  <hr />  

[![Sonar](https://github.com/sandeshkota/DesignPatterns/actions/workflows/sonar.yml/badge.svg)](https://github.com/bharatmane/design-patterns-java/actions/workflows/build.yml)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=ncloc)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=security_rating)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=coverage)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=sqale_index)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=code_smells)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=bugs)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bharatmane_design-patterns-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=bharatmane_design-patterns-java)
</h1>  

## Creational:

1. **Singleton**

These days, there are very rare situations where we need to design our own `Singleton Classes` Hence, Singleton is mostly considered an anti-Pattern, because it brings inherent complexity to the system in terms of testing. Only DI frameworks (Spring, Dagger, etc) should be allowed to create Singletons for you rather than you writing the singletons. However, if it is absolute essential to write your own Singleton, then you must write it correctly.

There are many ways this can be done in Java. All these ways differs in their implementation of the pattern, but in the end, they all achieve the same end result of a single instance.

1. **[Eager initialization:](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonEager.java)**  Object is created when it is loaded to the memory by JVM
2. **[Eager initialization Using static block:](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonEager2.java)** Only difference is object is created in a static block
3. **[Lazy initialization](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonLazy.java):** Object is created when it's required for first use
4. **[Thread Safe Singleton](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonThreadSafe.java):** Using synchronized
5. **[Lazy initialization with Double check locking](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonOptimizedThreadSafe.java):** Optimized version of thread safe where synchronized is moved closer to object creation
6. **[Bill Pugh Singleton Implementation](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonInnerClass.java):** Using inner static class

Typically, we don't see a need of serialization for static classes as there are no instances and hence no differeent states. However, in rare cases when we need to serialize them, we must implement a readResolve() otherwise we would end up having multiple instances of singleton class as we deserialize the object. [Refer example for more details](https://github.com/bharatmane/design-patterns-java/blob/main/src/main/java/io/github/bharatmane/dp/singleton/SingletonWithSerializationReadResolve.java)


## Structural:

## Behavioral:
