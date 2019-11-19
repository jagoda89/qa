package com.jsystems.qa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConfigFronted {

    protected WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDownEach() {
        driver.quit();
    }
}
