package com.jsystems.qa.qagui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFronted {


    @Test
    public void frontTest() {
        driver.get("https://wordpress.com/");
        WebElement textElement_1 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(1)"));
        String text1 = textElement_1.getText();
        assertTrue(text1.equals("WordPress powers"));

        WebElement textElement_2 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(2)"));
        String text2 = textElement_2.getText();
        assertTrue(text2.contains("% of the internet."));
        assertThat(text2).matches("\\d+(% of the internet.)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void loginTest() {
        driver.get("https://wordpress.com/");

        WebElement loginElement = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/header/nav/ul[2]/li[1]/a"));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(loginElement.isDisplayed());
        loginElement.click();

        WebElement login2  = driver.findElement(By.id("usernameOrEmail"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div[1]/div/form/div[1]/div[2]/button"));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(login2.isDisplayed());
        assertTrue(continueButton.isDisplayed());

    }


}
