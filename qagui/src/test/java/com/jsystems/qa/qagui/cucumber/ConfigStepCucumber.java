package com.jsystems.qa.qagui.cucumber;

import com.jsystems.qa.qagui.Configuration;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.sun.javafx.runtime.VersionInfo.setupSystemProperties;

public class ConfigStepCucumber {

    protected WebDriver driver;
    //    String chromePath;
    String fireFoxPath;
    {
        try {
//            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe")
                    .toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Before
    public  void setUpAll() {
        System.out.println("=====================@Before Cucumber test");
        WebDriverManager.chromedriver().setup();
        setupSystemProperties();
    }
    private void setupSystemProperties() {
//        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
    }
    public WebDriver setUp() {
        if(Configuration.BROWSER.equals("chrome")){
            driver = new ChromeDriver();
        } else if(Configuration.BROWSER.equals("firefox")){
            driver = new FirefoxDriver();
        }
        setDriver();
        return driver;
    }
    private void setDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.write("Scenario passed");
        } else {
            status = "(:heavy_multiplication_x:╭╮:heavy_multiplication_x:)";
//            status = "-------------";
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        driver.quit();
        driver = null;
    }
}
