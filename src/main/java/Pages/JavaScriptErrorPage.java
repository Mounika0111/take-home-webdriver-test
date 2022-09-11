package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptErrorPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public JavaScriptErrorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "/html/body/p")
    public WebElement errorText;

    public void verifyJavaScriptError() {
        driver.get(baseUrl + "/javascript_error");

        Assert.assertEquals(errorText.getText(), "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }
}
