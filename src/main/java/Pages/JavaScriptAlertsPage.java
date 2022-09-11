package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptAlertsPage  {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button")
    public WebElement alertBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button")
    public WebElement confirmBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button")
    public WebElement promptBtn;



    public void verifyJavaScriptAlert() throws InterruptedException {
        driver.get(baseUrl + "/javascript_alerts");
        alertBtn.click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
        driver.switchTo().alert().accept();

        confirmBtn.click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
        driver.switchTo().alert().accept();

        promptBtn.click();
        driver.switchTo().alert().accept();


    }
}
