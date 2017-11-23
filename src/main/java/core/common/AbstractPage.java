package core.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

}
