package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenuPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "menu")
    public WebElement floatingMenu;

    public void verifyFloatingMenu() {
        driver.get(baseUrl + "/floating_menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Assert.assertTrue(floatingMenu.isDisplayed(), "Floating menu is not displaying");

    }
}
