package core.hotline.page_object.home_page;

import core.common.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "(//span[@class='js-change-language'])[1]")
    private WebElement changeLanguage;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage changeLanguage() {

        changeLanguage.click();
        return new HomePage(driver);
    }
}