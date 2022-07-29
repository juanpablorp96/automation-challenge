package challenge;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Run",
        plugin = {"pretty"},
        features = {"./src/test/resources/challenge/features"})
public class RunCucumberTest {

}
