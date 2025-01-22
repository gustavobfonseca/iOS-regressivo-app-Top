package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "summary",
                "pretty", // Resumo na saída do console
                "html:target/cucumber-reports.html", // Relatório HTML
                "json:target/cucumber-reports.json", // Relatório JSON
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/extent-report.html"
        },
        features = "src/test/resources/features", // Caminho para as suas features
        glue = "org.example.stepdefinitions" // Pacote com suas definições de passos
//        monochrome = true, // Para melhorar a legibilidade da saída
//        tags = "@regression" // Filtragem de cenários por tags
)
public class RunCucumberTest {
}