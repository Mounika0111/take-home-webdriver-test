package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSuccessPage {
    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public LoginSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(className = "radius")
    public WebElement loginBtn;

    @FindBy(id = "flash-messages")
    public WebElement successMsg;

    public void verifySuccessLogin() {
        driver.get(baseUrl + "/login");
        userName.sendKeys("tomsmith");
        passWord.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        String successMessage = successMsg.getText();
        Assert.assertEquals(successMessage, "You logged into a secure area!\n" +
                "×");
    }
}
