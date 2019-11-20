package com.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {
    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1.lpc-headline-title.lp-headline-title span:nth-child(1)")
    public WebElement textElement_1;
   // public WebElement textElement_1 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(1)"));

    @FindBy(css = "h1.lpc-headline-title.lp-headline-title span:nth-child(2)")
    public WebElement textElement_2;
    //public WebElement textElement_2 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(2)"));

}
