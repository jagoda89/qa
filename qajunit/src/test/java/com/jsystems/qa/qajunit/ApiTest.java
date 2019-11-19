package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ApiTest")
public class ApiTest extends ConfigJunit {

    final String stringTestowy = "stringTestowy";

    @DisplayName("First junit tests")
//    @Disabled("bug: import , 1230")
//    @RepeatedTest(5)
    @Tag("first")
    @Test
    public void firstTest() {
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message for test result");
        assertFalse(stringTestowy.contains("z"));
//        assertThat(stringTestowy).contains("k");
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");

    }

    @Tag("second")
    @Test
    public void secondTest() {
        System.out.println(0.2 * 0.2);
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        System.out.println(result);
        assertTrue(result == 0.04);
        assertFalse( 0.2 * 0.2 == 0.04);
    }
}