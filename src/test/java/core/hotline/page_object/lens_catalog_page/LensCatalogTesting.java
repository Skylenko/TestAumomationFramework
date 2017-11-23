package core.hotline.page_object.lens_catalog_page;

import core.common.CommonTest;
import core.hotline.page_object.google_page.GooglePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LensCatalogTesting extends CommonTest {

    public LensCatalogTesting() throws IOException {
    }

    @Before()
    public void webDriverSetUp() {
        driverSetUp();
        driver.get(propertyUtils.getProperty("url.lens.page"));
    }

    @After
    public void webDriverTearDown() {
        tearDown();
    }

    @Test
    public void checkPricesTesting() {

        LensCatalogPage lensCatalogPage = new LensCatalogPage(driver);
        lensCatalogPage.checkFilter();

        List<Integer> prices = lensCatalogPage.getItemPrice();

        int max = Collections.max(prices);
        int min = Collections.min(prices);

        int maxPriceInt = 10000;
        int minPriceInt = 0;

        assertTrue(max <= maxPriceInt || min >= minPriceInt);

    }
}
