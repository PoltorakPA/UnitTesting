package ru.poltorak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    public void createCar() {
        car = new Car("Skoda",
                "ASDFG1234", 2015, "Dmitriy Finachkin");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ASDFG1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("QWERTY12345");
        assertEquals("QWERTY12345", car.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC-123", "DEF-456", "DFH-454"})
    @NullSource
    @EmptySource
    void testSetNumberMultiplyValue(String number) {
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'ABC-123', 'ABC-123'", "'DEF-456', 'DEF-456'"})
    void testSetNumberMultiplyValue2(String number, String x) {
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2015, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Dmitriy Finachkin", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Pavel Poltorak");
        assertEquals("Pavel Poltorak", car.getOwner());
    }

    @Test
    void getListOwners() {
        assertArrayEquals(new String[]{"Dmitriy Finachkin"}, car.getOwners().toArray());
    }


    @Test
    void getListOfTwoOwners() {
        car.setOwner("Pavel Poltorak");
        assertArrayEquals(new String[]{"Dmitriy Finachkin", "Pavel Poltorak"}, car.getOwners().toArray());
    }


    @Test
    public void testPrivateMethode() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);
            method.setAccessible(true);
            assertEquals("abc", method.invoke(car).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testPrivateMethodeWithArgument() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);
            method.setAccessible(true);
            assertEquals("abc", method.invoke(car, "abc").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    @ParameterizedTest
//    @DisplayName("Test Demonstrates how test data could be loader from file")
//    @CsvFileSource(resources = "/src/main/resource/test-data.csv", delimiter = '|', numLinesToSkip = 1)
//    public void testNumbers (String input, String expected  ){
//        car.setNumber(input);
//        assertEquals(expected,car.getNumber());
//    }

}
