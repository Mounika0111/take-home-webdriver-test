package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FileUploadPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(id = "file-submit")
    public WebElement uploadBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    public WebElement uploadMsg;

    public void verifyFileUpload() throws AWTException, InterruptedException {
        driver.get(baseUrl + "/upload");

        chooseFileBtn.sendKeys("/Users/jaydeephansaliya/Downloads/some-file (1).txt");
        uploadBtn.click();

        Assert.assertEquals(uploadMsg.getText(), "File Uploaded!");
    }
}
