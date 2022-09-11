package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContentPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]")
    public WebElement dynamicContent;

    public void verifyDynamicContent() {
        driver.get(baseUrl + "/dynamic_content");

        String textBeforeRefresh = dynamicContent.getText();
        driver.navigate().refresh();
        String textAfterRefresh = dynamicContent.getText();

        Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh, "Content is not changed");
    }
}
