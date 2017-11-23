package core.hotline.page_object.home_page;

import core.common.CommonTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class HomePageTesting extends CommonTest {


    public HomePageTesting() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.ulr"));

    }
    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void checkLanguageTesting() {

        HomePage homePage = new HomePage(driver);
        homePage.changeLanguage();

        String buttonTextColor = driver.findElement(By.xpath("(//span[@class='js-change-language'])[1]"))
                .getCssValue("color");

       String uaWord1 = "Каталог товарів".toUpperCase();
       String uaWord2 = driver.findElement(By.xpath("//span[@class = 'uppercase']")).getText();

        Assert.assertEquals("rgba(142, 180, 240, 1)", buttonTextColor);
        Assert.assertEquals(uaWord2, uaWord1);
    }
}
