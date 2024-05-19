package org.Runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = "src/main/java/org/StepDefinitions"
)
public class TesteRunner {
}
