package core.hotline.page_object.garden_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import core.common.AbstractPage;

class GardenPage extends AbstractPage {

	@FindBy(xpath = "//li[@class='level-1 dacha_sad']")
	private WebElement gardenLink;

	@FindBy(xpath = "(//span[@class='item-scale'])[2]")
	private WebElement pump;

	public GardenPage(WebDriver webDriver) {
		super(webDriver);
	}

	public GardenPage avg() {
		Actions actions = new Actions(driver);

		gardenLink.click();
		actions.moveToElement(pump).click().perform();

		return new GardenPage(driver);
	}
}