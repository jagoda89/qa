package com.jsystems.qa.qajunit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertTrue;

public class QaParameterizedTest extends ConfigJunit {

    // @Test
    @ParameterizedTest(name = "Parameter test with value {0}") // name zmienia nam sposób wyświeltania wyników
    @ValueSource(ints = {5, 15, 25})  //przekazania parametrow na ktorych chcemy wykonac test
    public void firstParameterizedTest(int number) {

        assertTrue(number % 5 == 0);

        //    int[] ints = {5,15,25};
        //   for (int i = 0; i < ints.length; i++){
        //      assertTrue(ints[i] % 5 == 0);
        //    }
    }


    @ParameterizedTest(name = "Parameter test with value {0}") // name zmienia nam sposób wyświeltania wyników
    @ValueSource(strings = {"hello", "hello junit", "hello students"})  //przekazania parametrow na ktorych chcemy wykonac test
    public void secondParameterizedTest(String text) {

        assertTrue(text.contains("hello"));

    }

    //Dobry test do testów wartości brzegowych
    @ParameterizedTest(name = "Parameter test with value {0} and {1}") // name zmienia nam sposób wyświeltania wyników
    @CsvSource(value = {"hello, 5", "hello junit 5, 15", "'hello 5!', 25"})  //przekazania zestawów parametrow na ktorych chcemy wykonac test
    public void nextParameterizedTest(String text, int number) {

        assertTrue(text.contains("hello"));
        assertTrue(number % 5 == 0);

    }


    @ParameterizedTest(name = "Parameter test with value {0} and {1}") // name zmienia nam sposób wyświeltania wyników
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')  //przekazania zestawów parametrow z PLIKU na ktorych chcemy wykonac test.Plik ten musi byc w folderze resources
    public void csvFileParameterizedTest(String text, int number) {

        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 == 0);

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}") // name zmienia nam sposób wyświeltania wyników
    @EnumSource(value = ParamEnum.class)  //przekazania zestawów parametrow z PLIKU na ktorych chcemy wykonac test.Plik ten musi byc w folderze resources
    public void enumParameterizedTest(ParamEnum enumtype) {

        assertTrue(enumtype.toString().contains("ENUM"));

    }

    enum ParamEnum {
        ENUM_ONE,
        ENUM_TWO
    }
}
