package Pages;

import Utils.CommonMethods;
import Utils.ConfigrationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonMethods {

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement Phone;

    @FindBy(xpath = "//input[@name='userName']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='address1']")
    public WebElement Address;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement City;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement State;

    @FindBy(xpath = "//input[@name='postalCode']")
    public WebElement PostalCode;

    @FindBy(xpath = "//select[@name='country']")
    public WebElement Country;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement UserName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement Password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement ConFirmPassword;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement Submit;

    public RegisterPage(){
        PageFactory.initElements(driver,this);

    }

    public void RegisterConfig(String FirstName, String LastName,
                               String Phone, String Email, String Address,
                               String City, String State, String  PostalCode,
                               String Country, String UserName, String Password,
                               String ConFirmPassword){
        SendText(registerPage.FirstName, ConfigrationReader.getPropertyValue("FirstName"));
        SendText(registerPage.LastName, ConfigrationReader.getPropertyValue("LastName"));
        SendText(registerPage.Phone, ConfigrationReader.getPropertyValue("Phone"));
        SendText(registerPage.Email, ConfigrationReader.getPropertyValue("Email"));
        SendText(registerPage.Address, ConfigrationReader.getPropertyValue("Address"));
        SendText(registerPage.City, ConfigrationReader.getPropertyValue("City"));
        SendText(registerPage.State, ConfigrationReader.getPropertyValue("State"));
        SendText(registerPage.PostalCode, ConfigrationReader.getPropertyValue("PostalCode"));
        SelectDropdown(registerPage.Country, ConfigrationReader.getPropertyValue("Country"));
        SendText(registerPage.UserName, ConfigrationReader.getPropertyValue("UserName"));
        SendText(registerPage.Password, ConfigrationReader.getPropertyValue("Password"));
        SendText(registerPage.ConFirmPassword, ConfigrationReader.getPropertyValue("ConFirmPassword"));
        Click(Submit);

    }



}
