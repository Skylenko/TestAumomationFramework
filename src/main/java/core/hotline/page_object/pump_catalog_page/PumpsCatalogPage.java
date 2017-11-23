package core.hotline.page_object.pump_catalog_page;

import core.common.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PumpsCatalogPage extends AbstractPage {


    @FindBy(xpath = "(//select[@class='field'])[1]")
    private WebElement sortFilter;

    @FindBy(xpath = "//a[@data-eventlabel='насос повышения давления[389584]']")
    private WebElement pushMax;

    @FindBy(xpath = "//input[@data-price-max]")
    private WebElement maxPrices;

    @FindBy(xpath = "(//input[@class='btn-graphite'])[1]")
    private WebElement buttonOk;

    @FindBy(xpath = "//*[@id='page-catalog']/div[1]/div[1]/div[1]/aside/div/div[3]/div[1]/div[1]/div[1]/span")
    private WebElement countFiltr;

    @FindAll({ @FindBy(xpath = "//div[@class='price-md']") })
    private List<WebElement> items;

    public PumpsCatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PumpsCatalogPage checkFilter() {
        sortFilter.click();
        Select dropdown = new Select(driver.findElement(By.xpath("(//select[@class='field'])[1]")));
        dropdown.selectByValue("0");

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,1000)", maxPrices);

        maxPrices.clear();
        maxPrices.clear();
        maxPrices.sendKeys("5000");
        maxPrices.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonOk));

        buttonOk.click();


        pushMax.click();

            return new PumpsCatalogPage(driver);
    }

    public List<Integer> getItemPrice() {

        List<Integer> resultsOfItemsPrices = new ArrayList<>();
        for (WebElement element : items) {
            String priceString = element.getText();
            String priceString2 = priceString.replaceAll(",", ".")
                    .substring(0, priceString.indexOf('г'))
                    .replaceAll(" ", "");
            double priceDouble = Double.parseDouble(priceString2);
            int price = (int) priceDouble;
            resultsOfItemsPrices.add(price);
        }
        return resultsOfItemsPrices;
    }
}


