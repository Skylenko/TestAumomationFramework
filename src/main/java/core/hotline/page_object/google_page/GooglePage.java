package core.hotline.page_object.google_page;

import core.common.AbstractPage;
import core.hotline.page_object.AV_page.AVPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends AbstractPage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div/div/h3/a")
    private WebElement hotlineLink;

    @FindBy(xpath = "//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input")
    private WebElement searchButton;

    protected WebDriver driver;

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public AVPage searchByText(String text) {

        searchField.clear();
        searchField.sendKeys(text);
        searchButton.click();
        hotlineLink.click();

        return new AVPage(driver);
    }
}


