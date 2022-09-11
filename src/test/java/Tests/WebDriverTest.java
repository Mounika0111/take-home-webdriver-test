package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;

public class WebDriverTest {
    Common common = new Common();
    WebDriver driver = common.setup();
    LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
    LoginFailurePage loginFailurePage = new LoginFailurePage(driver);
    CheckboxPage checkboxPage = new CheckboxPage(driver);
    ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
    DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
    DropdownPage dropdownPage = new DropdownPage(driver);
    DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
    FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
    FileUploadPage fileUploadPage = new FileUploadPage(driver);
    FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
    IframePage iframePage = new IframePage(driver);
    JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
    MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
    OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);

    @Test(priority = 1)
    public void successLoginTest() {
        loginSuccessPage.verifySuccessLogin();
    }

    @Test(priority = 2)
    public void failureLoginTest() {
        loginFailurePage.verifyFailureLogin();
    }

    @Test(priority = 3)
    public void checkboxTest() {
        checkboxPage.verifyCheckbox();
    }

    @Test(priority = 4)
    public void dragAndDropTest() {
        dragAndDropPage.verifyDragAndDrop();
    }

    @Test(priority = 5)
    public void dropDownTest() {
        dropdownPage.verifyDropDown();
    }

    @Test(priority = 6)
    public void dynamicContentTest() {
        dynamicContentPage.verifyDynamicContent();
    }

    @Test(priority = 7)
    public void dynamicControlTest() {
        dynamicControlsPage.verifyDynamicControl();
    }

    @Test(priority = 8)
    public void dynamicLoadingTest() {
        dynamicLoadingPage.verifyDynamicLoading();
    }

    @Test(priority = 9)
    public void fileDownloadTest() {
        fileDownloadPage.verifyFileDownload();
    }

    @Test(priority = 10)
    public void fileUploadTest() throws InterruptedException, AWTException {
        fileUploadPage.verifyFileUpload();
    }

    @Test(priority = 11)
    public void floatingMenuTest() {
        floatingMenuPage.verifyFloatingMenu();
    }

    @Test(priority = 12)
    public void iframeTest() {
        iframePage.verifyIframe();
    }

    @Test(priority = 13)
    public void mouseHoverTest() {
        mouseHoverPage.verifyMouseHover();
    }

    @Test(priority = 14)
    public void javaScriptAlertTest() throws InterruptedException {
        javaScriptAlertsPage.verifyJavaScriptAlert();
    }

    @Test(priority = 15)
    public void javaScriptErrorTest() {
        javaScriptErrorPage.verifyJavaScriptError();
    }

    @Test(priority = 16)
    public void openInNewTabTest() {
        openInNewTabPage.verifyOpenInNewTab();
    }

    @Test(priority = 17)
    public void notificationMessageTest() throws InterruptedException {
        notificationMessagePage.verifyNotificationMessage();
    }

    @Test(priority = 18)
    public void contextMenuTest() throws InterruptedException {
        contextMenuPage.verifyContextMenu();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
