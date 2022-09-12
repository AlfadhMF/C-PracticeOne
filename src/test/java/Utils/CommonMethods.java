package Utils;

import Steps.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigrationReader.ReadProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigrationReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigrationReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        InitializePageObject();
    }
    public static void SendText(WebElement Element, String TextToSend){
        Element.clear();
        Element.sendKeys(TextToSend);
    }
    public static WebDriverWait GetWait(){
        WebDriverWait Wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
            return Wait;
    }
    public static void WaitForClickability(WebElement Element){
        GetWait().until(ExpectedConditions.elementToBeClickable(Element));
    }
    public static void Click(WebElement Element){
        WaitForClickability(Element);
        Element.click();
    }
    public static void SelectDropdown(WebElement Element, String Text){
        Select select=new Select(Element);
        select.selectByVisibleText(Text);
    }
    public static byte[] TakeScreenshot(String FileName){
        TakesScreenshot TS = (TakesScreenshot) driver;
        byte[] PicBytes = TS.getScreenshotAs(OutputType.BYTES);
        File SourceFile = TS.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(SourceFile, new File(Constants.SCREENSHOT_FILEPATH + FileName + " " +
                    GetTimesStamp("yyyy-MM-dd-HH-mm-ss")+".png"
            ));
        }catch (IOException e){
            e.printStackTrace();
        }
        return PicBytes;
    }
    public static String GetTimesStamp(String Pattern){
        Date date=new Date();
        SimpleDateFormat SDF= new SimpleDateFormat(Pattern);
        return SDF.format(date);
    }
    public static void CloseBrowser(){
        driver.quit();
    }
}
