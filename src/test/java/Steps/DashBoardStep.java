package Steps;

import Utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashBoardStep extends CommonMethods {






  @Then("Verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {


        List<String> expectedTabs = dataTable.asList();


        List<String> actualTabs = new ArrayList<>();

        for(WebElement ele: dashBoardPage.TABLE){
            actualTabs.add(ele.getText());
        }
        System.out.println(expectedTabs);
        System.out.println(actualTabs);

        Assert.assertTrue(expectedTabs.equals(actualTabs));

        System.out.println("PASS");



    }





}
