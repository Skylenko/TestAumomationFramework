package core.hotline.page_object.AV_page;

import core.common.CommonTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AVPageTesting extends CommonTest {
    public AVPageTesting() throws IOException {
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

        AVPage avPage = new AVPage(driver);
        avPage.avg();

        String title2 = "Объективы. Купить объективы по выгодной цене";
        String title1 = driver.getTitle();

        Assert.assertEquals(title1, title2);
    }
}

