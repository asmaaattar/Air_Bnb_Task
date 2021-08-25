package Project_Base.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    // Method to take screenshot when the test cases fail
    public static void captureScreenshot(WebDriver driver, String screenshot_name) {
        Path dest = Paths.get("./Screenshots", screenshot_name + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
    public static String select_specific_status(int index) {

        String[] status_names = {
                "غير مكتمل",
                "دعوى جديدة",
                "معاد للتصحيح",
                "اعداد المذكرة الجوابية",
                "تحت المراجعة-لجنة المراجعة",
                "تحت المراجعة-لجنة الاعتماد",
                "بانتظار الجلسة",
                "بانتظار الحكم",
                "تم اصدار حكم",
                "دعوى جديدة بانتظار نموذج الفحص",
                " تم إضافة استئناف"
        };

        String lawsuit_status_name = (status_names[index]);
        return lawsuit_status_name;
    }
}
