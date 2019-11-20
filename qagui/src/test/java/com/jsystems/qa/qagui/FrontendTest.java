package com.jsystems.qa.qagui;

import com.jsystems.qa.qagui.page.LoginPage;
import com.jsystems.qa.qagui.page.MainWordpressPage;
import com.jsystems.qa.qagui.page.UserPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.google.common.truth.Truth.assertThat;
import static com.jsystems.qa.qagui.page.LoginPage.*;
import static com.jsystems.qa.qagui.page.LoginPage.primaryButtonSelector;
import static com.jsystems.qa.qagui.page.MainWordpressPage.loginIconSelector;
import static com.jsystems.qa.qagui.page.UserPage.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("FrontTest")
public class FrontendTest extends ConfigFrontend {

    @Test
    public void frontTest() {
        driver.get(Configuration.BASE_URL);
//        WebElement textElement_1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
        String text1 = mainWordpressPage.textElement_1.getText();
        assertTrue(text1.equals("WordPress powers"));

//        WebElement textElement_2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));
        String text2 = mainWordpressPage.textElement_2.getText();
        assertTrue(text2.contains("% of the internet."));
        assertThat(text2).matches("\\d+(% of the internet.)");

    }

    @Test
    public void loginTest() {

        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

//        String loginIconSelector = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in";
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginIconSelector)));

//        WebElement loginIcon = driver.findElement(By.cssSelector(loginIconSelector));
        wait.until(ExpectedConditions.elementToBeClickable(mainWordpressPage.loginIcon));

        mainWordpressPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(driver);
//        String usernameOrEmailSelector = "usernameOrEmail";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));

//        WebElement usernameInput = driver.findElement(By.id(usernameOrEmailSelector));

        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);

//        String primaryButtonSelector = ".button.form-button.is-primary";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));

//        WebElement usernameButton = driver.findElement(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(passwordInputSelector)));
//        WebElement inputPassword = driver.findElement(By.id("password"));

        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
//        WebElement buttonPassword = driver.findElement(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();

        UserPage userPage = new UserPage(driver);

//        String userAvatarSelector = ".masterbar__item.masterbar__item-me";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));

//        WebElement userAvatar = driver.findElement(By.cssSelector(userAvatarSelector));
        userPage.userAvatar.click();

//        String userDisplayNameSelector = ".profile-gravatar__user-display-name";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

//        WebElement userDisplayName = driver.findElement(By.cssSelector(userDisplayNameSelector));
        String userDisplayNameText = userPage.userDisplayName.getText();

        assertThat(userDisplayNameText).isEqualTo("tutifruti89");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UserPage.primaryButtonSelector)));
//        WebElement saveUserDetailsButton = driver.findElement(By.cssSelector(primaryButtonSelector));

        assertTrue(userPage.saveUserDetailsButton.isDisplayed());
        assertFalse(userPage.saveUserDetailsButton.isEnabled());


//        assertTrue(userDisplayName.isDisplayed());
//        assertTrue(userDisplayName.isEnabled());
//        assertThat(userDisplayName.isSelected());
    }

    @Test
    public void notificationTest() {

        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginIconSelector)));

        wait.until(ExpectedConditions.elementToBeClickable(mainWordpressPage.loginIcon));
        mainWordpressPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(passwordInputSelector)));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        UserPage userPage = new UserPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));
        userPage.userAvatar.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

        userPage.notificationSideLine.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(commentSelector)));
        userPage.commentTopLine.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertTrue(userPage.firstCheckbox.isSelected());

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        userPage.firstCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertFalse(userPage.firstCheckbox.isSelected());
        userPage.firstCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertTrue(userPage.firstCheckbox.isSelected());

    }

}