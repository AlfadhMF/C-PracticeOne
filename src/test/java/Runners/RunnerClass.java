package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Flight.feature",
        glue = "Steps",
        dryRun = false,
        monochrome = true,
        tags = "@Flight",
        plugin = {"pretty", "html:target/cucumber.html"}
)







public class RunnerClass{
}
