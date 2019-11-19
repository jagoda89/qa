package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@Tag("UnitTest")
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

    @ParameterizedTest(name="Test of wordpress powers with value {0}")
    @ValueSource(strings = {"1", "10000", "1000000"})
    public void zadanie1(String text){

        String resultString = "Wordpress powers " + text + "% of the Internet";
        String expectedResult = "Wordpress powers [number]% of the Internet";

        //sprawdzic czy zwracany resultstring jest taki jak expected string z wyjatkiem zmieniajacego sie numeru
        //czy numer jest zwracany poprawnie (liczba całkowita) i czy jest wiekszy od 0

        Assertions.assertTrue(resultString.startsWith("Wordpress powers "));
        Assertions.assertTrue(resultString.endsWith("% of the Internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the Internet)"); // d+ cyfra 0-9 + 1 lub więcej cyfr

        String result = resultString.replace("Wordpress powers ", "").replace("% of the Internet", "");
        int resultNumber = Integer.parseInt(result);
        Assertions.assertTrue(resultNumber >0);
    }

    @ParameterizedTest(name="Test of wordpress powers with value {0}")
    @ValueSource(strings = {"f1", "f", "-9"})
    public void zadanie1False(String text){

        String resultString = "Wordpress powers " + text + "% of the Internet";
        String expectedResult = "Wordpress powers [number]% of the Internet";

        //Test negatywny, sprawdzamy, czy tekst zawiera niedozwolone znaki

       assertFalse(resultString.matches("\"(Wordpress powers ) \\d + (% of the Internet)\""));

    }

    enum ParamEnum {
        ENUM_ONE,
        ENUM_TWO
    }
}
