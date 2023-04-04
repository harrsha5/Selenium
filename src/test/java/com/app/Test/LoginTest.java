package com.app.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LoginTest {

    @Test
    public void launchBrowser() {
        //Using gecko driver .exe file
        System.setProperty("webdriver.gecko.driver", "C:/Projects/TestSelenium/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test
    public void launchBrowserByWebDriverManager() {
        //Using web driver manager
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        //System.out.println(driver.getTitle());
        WebElement e = driver.findElement(By.name("q"));
        e.sendKeys("Selenium");
        e.submit();
        driver.close();
    }

    @Test
    public void loginHeadlessBrowser(){
        //Loading headless browser
        System.setProperty("webdriver.gecko.driver", "C:/Projects/TestSelenium/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
