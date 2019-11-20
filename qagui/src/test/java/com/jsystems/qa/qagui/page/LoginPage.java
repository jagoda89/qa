package com.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String usernameOrEmailSelector = "usernameOrEmail";
    @FindBy(id = usernameOrEmailSelector)
    public WebElement usernameInput;
//    WebElement usernameInput = driver.findElement(By.id(usernameOrEmailSelector));

    public static final String primaryButtonSelector = ".button.form-button.is-primary";
    @FindBy(css = primaryButtonSelector)
    public WebElement usernameButton;
//    WebElement usernameButton = driver.findElement(By.cssSelector(primaryButtonSelector));

    public static final String passwordInputSelector = "password";
    @FindBy(id = passwordInputSelector)
    public WebElement inputPassword;
//    WebElement inputPassword = driver.findElement(By.id("password"));

    @FindBy(css = primaryButtonSelector)
    public WebElement buttonPassword;
//    public WebElement buttonPassword = driver.findElement(By.cssSelector(primaryButtonSelector));


}