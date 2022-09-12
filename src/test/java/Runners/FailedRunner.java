package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/Failed.txt",
        glue = "Steps",
        monochrome = true,
        plugin = {"pretty"}

)
public class FailedRunner {
}
