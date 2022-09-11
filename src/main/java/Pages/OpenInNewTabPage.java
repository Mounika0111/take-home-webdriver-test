package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class OpenInNewTabPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public OpenInNewTabPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement clickHereBtn;

    @FindBy(xpath = "/html/body/div/h3")
    public WebElement newWindowTxt;

    public void verifyOpenInNewTab() {
        driver.get(baseUrl + "/windows");

        clickHereBtn.click();
        String parentWindiow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for(String window: windows){
            if(!window.equalsIgnoreCase(parentWindiow)){
                driver.switchTo().window(window);
                Assert.assertEquals(newWindowTxt.getText(), "New Window");
            }
        }

    }
}


