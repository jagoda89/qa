package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")  //Do wyświetlania w raporcie
@Tag("unit") //można puszczac testy tylko z danym tagiem. Mozna to zrobic na poziomie klasy lub na poziomie metody

public class JunitTest  extends ConfigJunit{


    @BeforeEach //przed każdym testem
    public void setupEach(TestInfo testInfo){
        System.out.println("Before each");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }

    @AfterEach
    public void tearDownEach(){
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

    @Nested // adnotacja do korzystania z testów zagnieżdżonych
    public class NestedTest {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);

        @Test
        public void firstNestedTest() {

            assertTrue(list1.containsAll(list2));
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1,2,3);
        }

        @Test
        public void secondNestedTest() {

        }
    }

}
