package Air_Bnb_Pages;

import Project_Base.Base.Page_Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class Property_Details extends Page_Base {
    public Property_Details(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div/div/div/div[1]/main/div/div[1]/div[3]/div/div[1]/div/div/div[6]/div/div[2]/section/div[4]/a")
    WebElement Show_All_Amenties;
    @FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/div[3]/div/div/div/section/div[2]/div[9]/div[1]/h3")
    WebElement Parking_And_Facilities;
   @FindBy(id = "pdp_v3_parking_facilities_7_37701630-0-row-title")
    WebElement Pool_Option1;
    @FindBy(id = "pdp_v3_parking_facilities_7_22137442-0-row-title")
    WebElement Pool_Option2;


    Actions action;
    public void Check_Amenties_Property_Details (WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException, ParseException {
        action = new Actions(driver);
        Thread.sleep(1000);
        String currentTab = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (String tab : driver.getWindowHandles()) {

            if (!tab.equals(currentTab)) {

                driver.switchTo().window(tab);
                Thread.sleep(1000);
                js.executeScript("window.scrollBy(0,1000)");

                js.executeScript("window.scrollBy(0,800)");
                // Perform operation on new Tab
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfAllElements(Show_All_Amenties));
             /*  action.moveToElement(Show_All_Amenties).click().build().perform();
                Thread.sleep(1000);
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfAllElements(Parking_And_Facilities));
                action.moveToElement(Parking_And_Facilities).click().build().perform();
                /* if(Pool_Option1.isDisplayed())
                    wait.until(ExpectedConditions.visibilityOfAllElements(Pool_Option1));
                else if (Pool_Option2.isDisplayed())
                    wait.until(ExpectedConditions.visibilityOfAllElements(Pool_Option2));
              Thread.sleep(1000);
                js.executeScript("window.scrollBy(0,2000)");
*/
                   }

        }

    }


}
