package Steps;

import Pages.RegisterPage;
import Utils.CommonMethods;
import Utils.ConfigrationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterStep extends CommonMethods {


    @When("The user start is fill the contact information.")
    public void the_user_start_is_fill_the_contact_information() {

        SendText(RegisterPage.registerPage.FirstName, ConfigrationReader.getPropertyValue("FirstName"));
        SendText(RegisterPage.registerPage.LastName, ConfigrationReader.getPropertyValue("LastName"));
        SendText(RegisterPage.registerPage.Phone, ConfigrationReader.getPropertyValue("Phone"));
        SendText(RegisterPage.registerPage.Email, ConfigrationReader.getPropertyValue("Email"));


    }

    @Then("The user filling mailing information.")
    public void the_user_filling_mailing_information() {
        SendText(RegisterPage.registerPage.Address, ConfigrationReader.getPropertyValue("Address"));
        SendText(RegisterPage.registerPage.City, ConfigrationReader.getPropertyValue("City"));
        SendText(RegisterPage.registerPage.State, ConfigrationReader.getPropertyValue("State"));
        SendText(RegisterPage.registerPage.PostalCode, ConfigrationReader.getPropertyValue("PostalCode"));
        SelectDropdown(RegisterPage.registerPage.Country, ConfigrationReader.getPropertyValue("Country"));


    }
    @Then("The user filling user information.")
    public void the_user_filling_user_information() {
        SendText(RegisterPage.registerPage.UserName, ConfigrationReader.getPropertyValue("UserName"));
        SendText(RegisterPage.registerPage.Password, ConfigrationReader.getPropertyValue("Password"));
        SendText(RegisterPage.registerPage.ConFirmPassword, ConfigrationReader.getPropertyValue("ConFirmPassword"));


    }
    @When("The user click Submit.")
    public void the_user_click_submit() {
        Click(RegisterPage.registerPage.Submit);


    }
    @Then("The user have been registered.")
    public void the_user_have_been_registered() {

WebElement UserNameMatch = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
Assert.assertEquals(true,UserNameMatch.isDisplayed());
System.out.println("The user has successfully registered!");


    }

}
