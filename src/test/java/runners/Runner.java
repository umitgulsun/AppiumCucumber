package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {

                "pretty",//raporlarin daha ikunakli olmasi icin
                "html:target/default-cucumber-reports.html",
                "rerun:target/failed_scenarios.txt",

        },
        monochrome = true,
        features ="src/test/resources",
        glue = "stepdefinitions",
        tags = "@task8",
        dryRun = false

)

public class Runner {

}
