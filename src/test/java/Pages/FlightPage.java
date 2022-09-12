package Pages;
import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FlightPage extends CommonMethods {
    @FindBy(xpath = "//a[text()='Flights']")
    public WebElement ClickFlight;
    @FindBy (xpath = "//input[@value='oneway']")
    public WebElement OneWay;
    @FindBy (xpath = "//select[@name='passCount']")
    public WebElement PassCount;
    @FindBy (xpath = "//select[@name='fromPort']")
    public WebElement FromPort;
    @FindBy(xpath = "//select[@name='fromMonth']")
    public WebElement FromMonth;
    @FindBy (xpath = "//select[@name='fromDay']")
    public WebElement FromDay;
    @FindBy (xpath = "//select[@name='toPort']")
    public WebElement ToPort;
    @FindBy (xpath = "//select[@name='toMonth']")
    public WebElement ToMonth;
    @FindBy(xpath = "//select[@name='toDay']")
    public WebElement ToDay;
    @FindBy(xpath = "//input[@value='First']")
    public WebElement FirstClass;
    @FindBy(xpath = "//select[@name='airline']")
    public WebElement Airline;
    @FindBy(xpath = "//input[@name='findFlights']")
    public WebElement FindFlight;
    @FindBy(xpath = "//img[@width='118']")
    public WebElement Result;

    public FlightPage(){

        PageFactory.initElements(driver,this);
    }

}