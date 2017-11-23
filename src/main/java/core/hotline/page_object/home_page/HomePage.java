package core.hotline.page_object.home_page;

import core.common.AbstractPage;
import core.hotline.page_object.AV_page.AVPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "(//span[@class='js-change-language'])[1]")
    private WebElement changeLanguage;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public AVPage changeLanguage() {

        changeLanguage.click();
        return new AVPage(driver);
    }
}