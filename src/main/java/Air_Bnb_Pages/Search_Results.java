package Air_Bnb_Pages;
import Project_Base.Base.Page_Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search_Results extends Page_Base {
    public Search_Results(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div/div/span/div/div[2]/div/div[5]/button/span[1]")
    WebElement More_Filters;
    @FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/div[2]/div[1]/section/div/div[2]/div/div[2]/button[2]")
    WebElement Bed_Room;
    @FindBy(xpath = "/html/body/div[13]/section/div/div/div[2]/div/div[2]/div[1]/section/div/div[2]/div/div[2]/button[1]")
    WebElement Decrease_BedRoom;
    //@FindBy(xpath = "/html/body/div[13]/section/div/div/div[2]/div/div[2]/div[1]/section/div/div[2]/div/div[2]/button[2]/span/svg")
    //WebElement Bed_Room;
    @FindBy(id="filterItem-facilities-checkbox-amenities-7-row-checkbox")
   //@FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/div[2]/div[5]/section/div[1]/div[4]/div/div/label/div/div[1]/span/input")
    WebElement Pool;
    @FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/footer/button")
    WebElement Show_Stays;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[2]/aside/div/div[4]/div/div/div[2]/div[3]/div/div[4]/div[1]/div/button/div/div/div/span")
    WebElement Property_On_Map;
//@FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[5]/div[2]/div/div/div[1]/span")
  @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[5]/div[2]/div/div/div[1]")
        WebElement Price;
@FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[2]/aside/div/div[2]/span[2]/div/div/label/span/input")
        WebElement Price_On_Map;

   /* @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[2]/h1")
    WebElement Page_Title;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[1]")
    WebElement Result;*/
   // @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/a")

    //WebElement Properties;
    Actions action;
    public void Fill_More_Filters (WebDriver driver) throws InterruptedException, IOException, ParseException {

        Thread.sleep(1000);
        clickButton(More_Filters);
        Thread.sleep(2000);
       // clickButton(driver.findElement(By.xpath("/html/body/div[13]/section/div/div/div[2]/div/footer/div/button")));
        //Thread.sleep(1000);

        //clickButton(Decrease_BedRoom);
        for(int i=0;i<5;i++) {
            clickButton(Bed_Room);
            Thread.sleep(500);
        }
        action = new Actions(driver);
        action.moveToElement(Pool).click().build().perform();
        //clickButton(Pool);
        Thread.sleep(1000);
        clickButton(Show_Stays);
        Thread.sleep(1000);
    }
    public void Fill_Pool_Filters (WebDriver driver) throws InterruptedException, IOException, ParseException {

        Thread.sleep(1000);
        clickButton(More_Filters);
        Thread.sleep(2000);

        action = new Actions(driver);
        action.moveToElement(Pool).click().build().perform();
        //clickButton(Pool);
        Thread.sleep(1000);
        clickButton(Show_Stays);
        Thread.sleep(1000);
    }
/*
    public String VerifySearchResults_Location()
    {//Stays in Metropolitan City of Rome

        String Results_Verification_Location = Page_Title.getText();
        return Results_Verification_Location;
    }

    public String VerifySearchResults_ِAllData()
    {//300+ stays · Sep 24 - 30 · 3 guests


        String Results_Verification_Data = Result.getText();
        return Results_Verification_Data;
    }*/

    public String VerifyFirstProperty(WebDriver driver)
    {String First_Property_Data="";
        List<WebElement> Properties =  driver.findElements(By.className("_fhph4u"));
        if(Properties.size()!=0) {  First_Property_Data = Properties.get(0).getText();}
        return First_Property_Data;
    }
    List<WebElement> Properties;
    String PriceOnly;
    public void VerifyFirstProperty_Mouse(WebDriver driver)
    {//String First_Property_Data="";
       // List<WebElement> Properties =  driver.findElements(By.className("_fhph4u"));
       // if(Properties.size()!=0) {  First_Property_Data = Properties.get(0).getText();
        action = new Actions(driver);
       Properties =  driver.findElements(By.className("_fhph4u"));
       action.moveToElement(Properties.get(0));
       PriceOnly= Properties.get(0).getText();

        Assert.assertTrue(PriceOnly.contains(Price_On_Map.getText()));

    }
    public void Open_First_Property(WebDriver driver)
    {String First_Property="";
        List<WebElement> Properties =  driver.findElements(By.className("_fhph4u"));
        Properties.get(0).click();}
public  void Display_Property_On_Map(WebDriver driver) throws InterruptedException {
    Thread.sleep(1000);
  //  action.moveToElement(Price_On_Map).click().build().perform();
    String color = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[2]/aside/div/div[4]/div/div/div[2]/div[3]/div/div[4]/div[11]/div/button/div/div"))
            .getCssValue("color");
    Thread.sleep(3000);

    Assert.assertEquals(color,"rgba(34, 34, 34, 1)");
    Thread.sleep(1000);
action.moveToElement(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[2]/aside/div/div[4]/div/div/div[2]/div[3]/div/div[4]/div[11]/div/button/div/div")))
        .click().build().perform();
    Thread.sleep(1000);

}
//"/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[2]/aside/div/div[4]/div/div/div[2]/div[3]/div/div[4]/div[11]/div/button/div/div/div/span"
}
