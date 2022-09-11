package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MouseHoverPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public MouseHoverPage(WebDriver driver) {
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

    public void verifyMouseHover() {
        driver.get(baseUrl + "/hovers");
        List<WebElement> images = driver.findElements(By.xpath("//*[@id=\"content\"]/div//img"));
        Actions actions = new Actions(driver);
        for (int i = 1; i <= images.size(); i++) {
            WebElement image = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[" + i + "]/img"));
            actions.moveToElement(image).build().perform();
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[" + i + "]/div/h5")).isDisplayed();
        }
    }
}
