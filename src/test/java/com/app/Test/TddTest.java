package com.app.Test;

import com.app.utils.DataProviderTDD;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TddTest {

    @Test(dataProvider = "searchData", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWord(String SearchKey) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(SearchKey, Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test(dataProvider = "searchDataWithIterator", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWordWithIterator(String SearchKey) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        //driver = WEBDRIVER_THREADLOCAL.get();
        driver.findElement(By.name("q")).sendKeys(SearchKey, Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test(dataProvider = "searchDataWithObject", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWordWithObject(Object[] SearchKey) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        //driver = WEBDRIVER_THREADLOCAL.get();
        for (int i = 0; i < SearchKey.length; i++) {
            driver.findElement(By.name("q")).sendKeys(SearchKey[i].toString(), Keys.ENTER);
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
