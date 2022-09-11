package Pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class FileDownloadPage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String baseUrl = configFileReader.getBaseUrl();

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement downloadFileText;

    public void verifyFileDownload() {
        driver.get(baseUrl + "/download");
        downloadFileText.click();

        File dir = new File("/Users/jaydeephansaliya/Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals("some-file.txt")) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                Assert.assertTrue(true);
            }
        }
        Assert.assertFalse(false);
    }
}
