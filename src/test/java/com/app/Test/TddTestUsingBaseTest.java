package com.app.Test;
import com.app.BaseTest;
import com.app.utils.DataProviderTDD;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TddTestUsingBaseTest extends BaseTest {

    @Test(dataProvider = "searchData", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWord(String SearchKey) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("https://www.google.com");
        getDriver().findElement(By.name("q")).sendKeys(SearchKey, Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test(dataProvider = "searchDataWithIterator", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWordWithIterator(String SearchKey) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("https://www.google.com");
        getDriver().findElement(By.name("q")).sendKeys(SearchKey, Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test(dataProvider = "searchDataWithObject", dataProviderClass = DataProviderTDD.class)
    public void searchForKeyWordWithObject(Object[] SearchKey) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("https://www.google.com");
        for (int i = 0; i < SearchKey.length; i++) {
            getDriver().findElement(By.name("q")).sendKeys(SearchKey[i].toString(), Keys.ENTER);
        }
        Thread.sleep(5000);
    }
}
