package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"summary", "pretty", "html:target/cucumer-reports.html",
        "json:target/cucumber-reports",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunCucumberTest {
}
