package core.hotline.page_object.garden_page;

import core.common.CommonTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GardenPageTesting extends CommonTest {
    public GardenPageTesting() throws IOException {
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

        GardenPage gardenPage = new GardenPage(driver);
        gardenPage.avg();

        String title2 = "≡ Насосы для воды | купить в интернет-магазине, цены, отзывы | Hotline";
        String title1 = driver.getTitle();

        Assert.assertEquals(title1, title2);
    }
}

