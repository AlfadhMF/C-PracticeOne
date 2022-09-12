package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage extends CommonMethods {



    @FindBy(xpath = "//*[@border='1']/tbody/tr/td")
    public List<WebElement> TABLE;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }


}
