package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DynamicControlsPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button")
    public WebElement addRemoveBtn;

    @FindBy(xpath = "//*[@id=\"input-example\"]/button")
    public WebElement enableDisableBtn;

    @FindBy(xpath = "//*[@id=\"input-example\"]/input")
    public WebElement textBox;

    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement message;

    public void verifyDynamicControl() {
        driver.get(baseUrl + "/dynamic_controls");

        addRemoveBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(message));
        List<WebElement> checkbox = driver.findElements(By.id("checkbox"));
        Assert.assertEquals(checkbox.size(), 0);

        addRemoveBtn.click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.visibilityOf(message));
        List<WebElement> checkbox2 = driver.findElements(By.id("checkbox"));
        Assert.assertEquals(checkbox2.size(), 1);

        enableDisableBtn.click();
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(textBox.isEnabled(), "Textbox is not enabled");

        enableDisableBtn.click();
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait4.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(!textBox.isEnabled(), "Textbox is enabled");
    }
}
