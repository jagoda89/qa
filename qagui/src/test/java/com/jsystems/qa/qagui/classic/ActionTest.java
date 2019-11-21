package com.jsystems.qa.qagui.classic;

import com.jsystems.qa.qagui.Configuration;
import com.jsystems.qa.qagui.classic.page.LoginPage;
import com.jsystems.qa.qagui.classic.page.MainWordpressPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTest extends ConfigFrontend{



    @Tag("FrontTest")
    @Test
    public void actionTest() {

        driver.get(Configuration.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();

        Actions action = new Actions(driver);
        action.moveToElement(
                mainPage.loginIcon,
                5, 5); //przeniesc sie do elementu o pozycje 5, 5
        action.clickAndHold();
//        action.moveByOffset(xOffset, yOffset);
        action.release();
        action.build().perform(); //zbuduj i wykonaj akcję
    }

    @Test
    public void actionNextTest() {

        driver.get(Configuration.BASE_URL);
        MainWordpressPage mainPage= new MainWordpressPage(driver);
        mainPage.loginIcon.click();
        LoginPage loginPage = new LoginPage(driver);

        // akcje możemy budować wielo-etapowe
        Actions action = new Actions(driver);
        action.moveToElement(loginPage.usernameInput)
                .sendKeys(Configuration.LOGIN)
                .moveToElement(loginPage.usernameButton)
                // jak po . klikniecie Ctrl + space to rozwinie wam się lista dostępnych metod z klasy Actions
                .click()
                .build().perform();

        loginPage.waitForElementToBeVisibility(loginPage.inputPassword, 15);
        assertTrue(loginPage.inputPassword.isDisplayed());
    }
//
//
    @Test
    public void testBasicRInteraction() {
        Actions do42 = new Actions(driver);
        do42.sendKeys(Keys.chord(Keys.CONTROL, "l"));
        do42.sendKeys(Keys.ESCAPE);
        do42.sendKeys("41 + 1");
        do42.sendKeys(Keys.ENTER);
        do42.perform();
    }
}
