package Steps;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightStep extends CommonMethods {


    @Given("The user clicks the flights button.")
    public void the_user_clicks_the_flights_button() {

        Click(flightPage.ClickFlight);


    }


    @Then("The user has select option. such as {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void the_user_has_select_option_such_as(String Type, String Passengers, String DepartingFrom, String On, String Day1, String ArrivingIn, String Returning, String Day2, String ServiceClass, String Airline) {

        Click(flightPage.OneWay);
        SelectDropdown(flightPage.PassCount, Passengers);
        SelectDropdown(flightPage.FromPort, DepartingFrom);
        SelectDropdown(flightPage.FromMonth, On);
        SelectDropdown(flightPage.FromDay, Day1);
        SelectDropdown(flightPage.ToPort, ArrivingIn);
        SelectDropdown(flightPage.ToMonth, Returning);
        SelectDropdown(flightPage.ToDay, Day2);
        Click(flightPage.FirstClass);
        SelectDropdown(flightPage.Airline, Airline);



    }
    @Then("The user clicks Continue.")
    public void the_user_clicks_continue() {
        Click(flightPage.FindFlight);



    }
    @Then("Confirm the user found the seats.")
    public void confirm_the_user_found_the_seats() {

        WebElement Avalibility =  driver.findElement(By.xpath("//img[@width='118']"));

        Assert.assertEquals(true,Avalibility.isDisplayed());
        System.out.println("There's no results");

    }



}
