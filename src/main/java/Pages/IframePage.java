package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframePage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public IframePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement textArea;

    public void verifyIframe() {
        driver.get(baseUrl + "/iframe");
        driver.switchTo().frame("mce_0_ifr");
        textArea.clear();
        textArea.sendKeys("Hello World!");
        Assert.assertEquals(textArea.getText(), "Hello World!");
    }
}
