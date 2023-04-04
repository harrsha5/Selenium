package com.app.Test;

import com.app.utils.DataProviderExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TddExcelTest {

    @Test(dataProvider = "excelData", dataProviderClass = DataProviderExcel.class)
    public void excelTddTesting(String username, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
/*         we are using try catch block around the assertions is: If the assertion is false, it will not execute the next lines of code and hence the browser
         will not quit for failed assertion cases*/
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//header/div[1]/div[1]/span[1]/h6[1]")).isDisplayed());
        }catch(Throwable e){
            System.out.println("Error is: " + e);
            Thread.sleep(5000);
            driver.quit();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
