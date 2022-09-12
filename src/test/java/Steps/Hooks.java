package Steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void Start(){
        openBrowserAndLaunchApplication();
    }
    @After
    public void End(Scenario scenario){
        byte[] Pic;
        if (scenario.isFailed()){
            Pic = TakeScreenshot("Failed/"+ scenario.getName());
        }else{
            Pic = TakeScreenshot("passed/"+ scenario.getName());
        }
        scenario.attach(Pic,"image/png", scenario.getName());
        CloseBrowser();
    }
}
