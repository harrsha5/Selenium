package com.app.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsTest {

    @Test
    public void testExplicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        driver.close();

    }

    @Test
    public void testImplicitWaitIfAppliesToAllElements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("selenium waits", Keys.ENTER);
        System.out.println("The time stamp of find the search element " + new Timestamp(System.currentTimeMillis()));
        driver.findElement(By.xpath("//h3[contains(text(),'Selenium Wait commands - Implicit, Explicit and Fluent Wait')]")).click();
        System.out.println("The time stamp of find the search element " + new Timestamp(System.currentTimeMillis()));
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void testThreadSleepEWaitCondition() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("selenium waits", Keys.ENTER);
        driver.close();
    }

    @Test
    public void testExplicitEWaitCondition() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

/*        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
        {
            public Boolean apply(WebDriver arg0) {
                WebElement element = null;
                LocalTime t = LocalTime.now();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LocalTime tt = LocalTime.now();
                if(LocalTime.now().minusSeconds(5) == t)
                {
                    return true;
                }
                return false;
            }
        };

        wait.until(function);*/
        WebElement txtBox = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.elementToBeClickable(txtBox));
        txtBox.sendKeys("selenium waits", Keys.ENTER);
        Thread.sleep(2000);
        System.out.println("Closing the Browser");
        driver.close();
    }


}
