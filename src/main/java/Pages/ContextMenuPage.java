package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ContextMenuPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "hot-spot")
    public WebElement contextMenu;

    public void verifyContextMenu() throws InterruptedException {
        driver.get(baseUrl + "/context_menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(contextMenu, 50, 0).contextClick().build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String alertPopupText = driver.switchTo().alert().getText();

        Assert.assertTrue(alertPopupText.contains("You selected a context menu"), "Context menu is not selected");
        driver.switchTo().alert().dismiss();
    }
}
