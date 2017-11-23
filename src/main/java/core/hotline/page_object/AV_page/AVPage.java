package core.hotline.page_object.AV_page;

import core.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AVPage extends AbstractPage {

    @FindBy(xpath = "//li[@class='level-1 av']")
    private WebElement avLink;

    @FindBy(xpath = "(//span[@class='item-scale'])[3]")
    private WebElement lens;

    public AVPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AVPage avg() {
        Actions actions = new Actions(driver);

        avLink.click();
        actions.moveToElement(lens).click().perform();

        return new AVPage(driver);
    }
}

