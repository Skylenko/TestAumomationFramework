package core.hotline.page_object.google_page;

import core.common.CommonTest;
import core.hotline.page_object.AV_page.AVPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GooglePageTest extends CommonTest {

    public GooglePageTest() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("main.site.url.google"));
    }

    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void searchBarTesting() throws IOException {

        GooglePage homePage = new GooglePage(getDriver());

        String searchCondition = "Hotline";
        AVPage searchResultPage = homePage.searchByText(searchCondition);

        String title1 = driver.getTitle();
        String title2 = "Hotline - сравнить цены в интернет-магазинах Украины";

        Assert.assertEquals(title1, title2);
    }
}








