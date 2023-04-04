package com.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
