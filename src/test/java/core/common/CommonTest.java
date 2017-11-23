package core.common;


import core.common.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonTest {
    protected WebDriver driver;
    protected PropertyUtils propertyUtils = null;

    public CommonTest() throws IOException {
        this.propertyUtils = new PropertyUtils();
        driver = new ChromeDriver();
        driverSetUp();
    }

    protected void driverSetUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void tearDown() {
        driver.close();
    }
}
