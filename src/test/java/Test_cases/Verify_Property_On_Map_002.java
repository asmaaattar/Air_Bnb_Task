package Test_cases;

import Air_Bnb_Pages.Home_Page;
import Air_Bnb_Pages.Property_Details;
import Air_Bnb_Pages.Search_Results;
import Project_Base.Base.Test_Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.PublicKey;

public class Verify_Property_On_Map_002 extends Test_Base {
    Home_Page Home_Page_Object;
    Search_Results Search_Result_Object;
    @Test
    public void Verify_Search_Filters() throws InterruptedException, IOException, ParseException {
        Home_Page_Object = new Home_Page(driver);
        Home_Page_Object.Fill_Search_Criteria();
        wait.until(ExpectedConditions.urlContains("Rome--Italy"));
        Thread.sleep(1000);
        String Location=Home_Page_Object.VerifySearchResults_Location();
        Assert.assertEquals(Location , "Stays in Metropolitan City of Rome");
        Thread.sleep(1000);
        String ResultsData=Home_Page_Object.VerifySearchResults_ِAllData();
//300+ stays · Sep 24 - 30 · 3 guests
        Assert.assertTrue(ResultsData.contains("Sep 24 - 30 · 3 guests"));

    }
    @Test(dependsOnMethods = "Verify_Search_Filters")

    public void Verify_More_Filters() throws InterruptedException, IOException, ParseException {
        Thread.sleep(2000);
        Search_Result_Object=new Search_Results(driver);
        Thread.sleep(2000);

        Search_Result_Object.Fill_More_Filters(driver);
        Thread.sleep(2000);

        String First_Property_Data = Search_Result_Object.VerifyFirstProperty(driver);
        Assert.assertTrue(First_Property_Data.contains("5 bedrooms"));
        Thread.sleep(2000);



    }
    @Test(dependsOnMethods = "Verify_More_Filters")

    public void Display_On_Map() throws InterruptedException, IOException, ParseException {

        Search_Result_Object.VerifyFirstProperty_Mouse(driver);
        Thread.sleep(2000);

        Search_Result_Object.Display_Property_On_Map(driver);
        Thread.sleep(2000);
        //Search_Result_Object.Open_First_Property(driver);
        Thread.sleep(2000);


    }

}
