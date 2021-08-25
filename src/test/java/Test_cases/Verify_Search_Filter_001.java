package Test_cases;

import Air_Bnb_Pages.Home_Page;
import Air_Bnb_Pages.Property_Details;
import Air_Bnb_Pages.Search_Results;
import Project_Base.Base.Test_Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Verify_Search_Filter_001 extends Test_Base {
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

        Search_Result_Object.Open_First_Property(driver);
        Thread.sleep(2000);

    }
Property_Details Property_Details_Object;
    String Amenties_pool;
    @Test(dependsOnMethods = "Verify_More_Filters")

    public void Verify_Facilities() throws InterruptedException, IOException, ParseException {
        Thread.sleep(2000);
        Search_Result_Object=new Search_Results(driver);
        Thread.sleep(2000);

       // Search_Result_Object.Open_First_Property(driver);
        Thread.sleep(2000);
        Property_Details_Object = new Property_Details(driver);
        Thread.sleep(2000);
        String url =driver.getCurrentUrl();
        Thread.sleep(2000);

        //   Assert.assertEquals(url,"https://www.airbnb.com/rooms/22137442?adults=2&children=1&check_in=2021-09-24&check_out=2021-09-30&translate_ugc=false&federated_search_id=54d3f7f8-830f-40af-b58c-4f104cd51935&source_impression_id=p3_1629836700_uCBJmryhqehjC7WO&guests=1");
        Property_Details_Object.Check_Amenties_Property_Details(driver,wait);
        Thread.sleep(2000);
       // Assert.assertTrue(Pool_Flag);
        driver.navigate().to("https://www.airbnb.com/");
    }
}
