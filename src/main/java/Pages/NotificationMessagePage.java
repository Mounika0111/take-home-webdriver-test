package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NotificationMessagePage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
    public WebElement clickHereTxt;

    @FindBy(id = "flash")
    public WebElement notificationMsg;

    public void verifyNotificationMessage() throws InterruptedException {
        driver.get(baseUrl + "/notification_message_rendered");
        WebDriverWait wait = new WebDriverWait(driver,10);
        do{
            clickHereTxt.click();
            wait.until(ExpectedConditions.visibilityOf(notificationMsg));
        }while (notificationMsg.getText().equals("Action unsuccesful, please try again"));
        Thread.sleep(2000);
        Assert.assertEquals(notificationMsg.getText(), "Action unsuccesful, please try again\n" +
                "×");

        do{
            clickHereTxt.click();
            wait.until(ExpectedConditions.visibilityOf(notificationMsg));
        }while (notificationMsg.getText().equals("Action successful"));
        Thread.sleep(2000);
        Assert.assertEquals(notificationMsg.getText(), "Action successful\n" +
                "×");
    }
}
