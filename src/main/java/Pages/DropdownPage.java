package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "dropdown")
    public WebElement dropdown;

    @FindBy(xpath = "//option[@selected]")
    public WebElement selectedOption;

    public void verifyDropDown() {
        driver.get(baseUrl + "/dropdown");
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Assert.assertEquals(selectedOption.getText(), "Option 1");

        select.selectByIndex(2);
        Assert.assertEquals(selectedOption.getText(), "Option 2");
    }
}
