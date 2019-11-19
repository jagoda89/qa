package com.jsystems.qa.qajunit;

import junit.framework.TestCase;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")  //Do wyświetlania w raporcie
@Tag("unit") //można puszczac testy tylko z danym tagiem. Mozna to zrobic na poziomie klasy lub na poziomie metody

public class JunitTest extends ConfigJunit {


    @BeforeEach //przed każdym testem
    public void setupEach(TestInfo testInfo) {
        System.out.println("Before each");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("After each");
    }


    final String stringTestowy = "stringTestowy";

    //kolejność adnotacji ma znaczenie!!!

    @DisplayName("Junit tests")  //Do wyświetlania w raporcie
    @Test
    @RepeatedTest(5) //wykona nam test 5 razy
    @Tag("first")
    @Disabled("bug: import , 1230") //tego testu nie będzie uruchamiał
    public void firstTest() {

        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message for test result");
        assertFalse(stringTestowy.matches("^s")); //powinien zacząć się od s
        assertFalse(stringTestowy.contains("z"));
        assertThat(stringTestowy).contains("g"); //pierwszy zapis
        assertThat(stringTestowy.contains("z")); //drugi zapis. Tutaj po kropce można dodać kolejne warunki
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");
    }

    @Tag("second")
    @Test
    public void secondTest() {

        System.out.println(0.2 * 0.2);
        //assertTrue(0.2 * 0.2 == 0.04); //zwróci false
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue(); //przy testach liczb zmiennoprzecinkowych korzystamy ze stringów i bigDecimal
        System.out.println(result);
        assertTrue(result == 0.04);
    }

    @Test
    public void stringTest() {


        String simpleString = "simpleString";
        String simple = "simpleString";
        String simpleString_2 = new String("simpleString");
        String simpleString_3 = new String("simpleString");

        assertTrue(simpleString == "simpleString"); //porównywanie zmiennych poprzez ==
        assertTrue(simpleString == simple);
        assertFalse(simpleString == simpleString_2); // nie możemy użyć znaku == przy porównywaniu zmiennej do obiektu
        assertFalse(simpleString_2 == simpleString_3);
        assertTrue(simpleString.equals(simple));
        assertTrue(simpleString_2.equals(simpleString_3));


        int a = 1;
        Integer a_1 = 1;
    }

    @Test
    public void zadanie1(){

        String resultString = "Wordpress powers 1233333333% of the Internet";
        String expectedResult = "Wordpress powers [number]% of the Internet";

        //sprawdzic czy zwracany resultstring jest taki jak expected string z wyjatkiem zmieniajacego sie numeru
        //czy numer jest zwracany poprawnie (liczba całkowita) i czy jest wiekszy od 0

        assertTrue(resultString.startsWith("Wordpress powers "));
        assertTrue(resultString.endsWith("% of the Internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the Internet)"); // d+ cyfra 0-9 + 1 lub więcej cyfr

        String result = resultString.replace("Wordpress powers ", "").replace("% of the Internet", "");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber >0);
    }

    @Nested // adnotacja do korzystania z testów zagnieżdżonych
    public class NestedTest {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5);

        @Test
        public void firstNestedTest() {

            assertTrue(list1.containsAll(list2));
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1, 2, 3);
        }

        @Test
        public void secondNestedTest() {

        }
    }

}
