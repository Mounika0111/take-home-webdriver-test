package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    public WebElement startBtn;

    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    public WebElement helloWorldText;

    public void verifyDynamicLoading() {
        driver.get(baseUrl + "/dynamic_loading/2");
        startBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        Assert.assertEquals(helloWorldText.getText(), "Hello World!");
    }
}
