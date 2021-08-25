package Air_Bnb_Pages;

import Project_Base.Base.Page_Base;
import net.bytebuddy.asm.Advice;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Data_Provider.JsonDataReader;

import java.io.IOException;

public class Home_Page extends Page_Base {
    public Home_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[1]/div/label/div/input")
    WebElement Location;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[1]/div/div[2]/div/section/div/ul/li[1]/div[2]/div")
    WebElement Rome_Italy_Select;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div/div/div/div[1]/div[1]/div/div/div/header/div/div[2]/div/div/div/div[2]/div/div/div/form/div[2]/div/div[3]/div[1]/div/div/div[2]")
    WebElement Checkin;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[3]/div[2]/div/div/section/div/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[4]/td[6]/div/div/div")
    WebElement first_Day;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[3]/div[4]/div/div/section/div/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[5]/td[5]/div/div/div")
    WebElement Last_Day;


    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[5]/div[1]/div/div[1]")
    WebElement Guests;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[5]/div[2]/div/section/div/div/div[1]/div[2]/button[2]/span")
    WebElement Adults_Plus;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[5]/div[3]/div/section/div/div/div[1]/div[2]/button[2]/span")
    WebElement Adults_Plus2;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[5]/div[3]/div/section/div/div/div[2]/div[2]/button[2]/span")
    WebElement Child_Plus;


    @FindBy(xpath="/html/body/div[5]/div/div/div[1]/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div/div[5]/div[4]/button/span[1]/span")
    WebElement Search_Button;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[2]/h1")
    WebElement Page_Title;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[1]")
    WebElement Result;


    public void Fill_Search_Criteria () throws InterruptedException, IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        Thread.sleep(800);
        clickButton(Location);
        Thread.sleep(800);
        setTextElementText(Location,jsonReader.Location);
        Thread.sleep(800);
        clickButton(Rome_Italy_Select);
        Thread.sleep(800);
        clickButton(first_Day);
        Thread.sleep(800);
        clickButton(Last_Day);
        Thread.sleep(800);
        clickButton(Guests);
        Thread.sleep(800);
        clickButton(Adults_Plus);
        Thread.sleep(800);
        clickButton(Adults_Plus2);
        Thread.sleep(800);
        clickButton(Child_Plus);
        Thread.sleep(800);
        clickButton(Search_Button);
    }

public String VerifySearchResults_Location()
{//Stays in Metropolitan City of Rome


    String Results_Verification_Location = Page_Title.getText();
    return Results_Verification_Location;
}

    public String VerifySearchResults_ِAllData()
    {//300+ stays · Sep 24 - 30 · 3 guests


        String Results_Verification_Data = Result.getText();
        return Results_Verification_Data;
    }


}
