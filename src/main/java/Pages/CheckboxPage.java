package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckboxPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement checkBox2;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkBox1;

    public void verifyCheckbox() {
        driver.get(baseUrl + "/checkboxes");
        checkBox1.click();
        checkBox2.click();

        Assert.assertTrue(checkBox1.isSelected(), "Checkbox 1 is not selected");
        Assert.assertTrue(!checkBox2.isSelected(), "Checkbox 2 is selected");
    }
}
