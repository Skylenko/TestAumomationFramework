package core.hotline.page_object.pump_catalog_page;

import core.common.CommonTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PumpCatalogTesting extends CommonTest {

    public PumpCatalogTesting() throws IOException {
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

        PumpsCatalogPage pumpsCatalogPage = new PumpsCatalogPage(driver);
        pumpsCatalogPage.checkFilter();

        List<Integer> prices = pumpsCatalogPage.getItemPrice();

        int max = Collections.max(prices);
        int min = Collections.min(prices);

        int maxPriceInt = 5000;
        int minPriceInt = 0;

        assertTrue(max <= maxPriceInt || min >= minPriceInt);

    }
}
