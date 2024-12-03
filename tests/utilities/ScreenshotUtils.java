import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        File destination = new File("tests/screenshots/" + screenshotName);

        try {
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved at: " + destination.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
