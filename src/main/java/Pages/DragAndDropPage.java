package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DragAndDropPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "column-a")
    public WebElement box_a;

    @FindBy(id = "column-b")
    public WebElement box_b;

    public void verifyDragAndDrop() {
        driver.get(baseUrl + "/drag_and_drop");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(box_a, box_b);
    }
}
