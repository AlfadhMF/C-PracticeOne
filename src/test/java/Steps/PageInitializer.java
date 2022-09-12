package Steps;

import Pages.DashBoardPage;
import Pages.FlightPage;
import Pages.RegisterPage;

public class PageInitializer {

    public static RegisterPage registerPage;
    public static DashBoardPage dashBoardPage;
    public static FlightPage flightPage;

    public static void InitializePageObject() {
        registerPage = new RegisterPage();
        dashBoardPage = new DashBoardPage();
        flightPage = new FlightPage();

    }

}
