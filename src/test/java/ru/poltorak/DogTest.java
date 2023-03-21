package ru.poltorak;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    static Dog dog;


    //    @BeforeEach
//    void prepareData() {
//        dog = new Dog("Albert", 2);
//    }
    @BeforeAll
    static void prepareData() {
        dog = new Dog("Albert", 2);
    }

    @Test
    void testDogGetNameMethod() {
        assertEquals("Albert", dog.getName());
    }

    @Test
    void testSetDogNameMethod() {
        dog.setName("Roman");
        assertEquals("Albert", dog.getName());
    }

    @Test
    void testSetDogNameMethodIfEmpty() {
        Dog dog = new Dog("", 2);
        dog.setName("Roman");
        assertEquals("Roman", dog.getName());
    }
    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }

}