package core.hotline.page_object.lens_catalog_page;

import core.common.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LensCatalogPage extends AbstractPage {

    @FindBy(xpath = "(//select[@class='field'])[1]")
    private WebElement sortFilter;

    @FindBy(xpath = "//input[@data-price-max]")
    private WebElement maxPrices;
    @FindBy(xpath = "//input[@data-price-max-default]")
    private WebElement maxPricesDefault;

    @FindBy(xpath = "(//input[@class='btn-graphite'])[1]")
    private WebElement buttonOk;

    @FindBy(xpath = "//*[@id='page-catalog']/div[1]/div[1]/div[1]/aside/div/div[3]/div[1]/div[3]/div[2]/ul/li[2]/label/a")
    private WebElement fullScreen;

    @FindAll({@FindBy(xpath = "//span[@class='value']")})
    private List<WebElement> items;

    public LensCatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LensCatalogPage checkFilter() {

        sortFilter.click();
        Select dropdown = new Select(driver.findElement(By.xpath("(//select[@class='field'])[1]")));
        dropdown.selectByValue("0");

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,1000)", maxPrices);

        maxPrices.clear();
        maxPrices.clear();

        maxPrices.sendKeys("10000");
        maxPrices.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(buttonOk));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttonOk.click();

        fullScreen.click();

        return new LensCatalogPage(driver);
    }

    public List<Integer> getItemPrice() {

        List<Integer> resultsOfItemsPrices = new ArrayList<>();
        for (WebElement element : items) {
            String priceString = element.getText();
            String priceString2 = priceString.replaceAll(",", ".")
                    .replaceAll(" ", "");
            double priceDouble = Double.parseDouble(priceString2);
            int price = (int) priceDouble;
            resultsOfItemsPrices.add(price);
        }
        return resultsOfItemsPrices;
    }
}


