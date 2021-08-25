package Project_Base.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Page_Base {
    // create constructor
    public Page_Base(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton (WebElement button) {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement, String value) {
        textElement.clear();
        textElement.sendKeys(value);
    }

    protected static void select_from_dropdown_menu_by_index(WebElement select, String value)
    {
        Select authority = new Select(select);
        authority.selectByIndex(1);
    }

    protected static void select_from_dropdown_menu_by_visible_text(WebElement select, String value)
    {
        Select authority = new Select(select);
        authority.selectByVisibleText(value);
    }

    public static void upload_file() throws AWTException {

        String[] attachments_names = {
                "PDF.pdf",
                "Photo1.jpg",
                "Photo2.png",
        };

        int idx = new Random().nextInt(attachments_names.length);
        String lawsuit_attachment = (attachments_names[idx]);


        Robot robot = new Robot();
        robot.setAutoDelay(2000);
        StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\Uploads\\" + lawsuit_attachment);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.setAutoDelay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);


        robot.setAutoDelay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

}
