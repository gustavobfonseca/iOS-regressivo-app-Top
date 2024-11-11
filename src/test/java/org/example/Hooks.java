package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hooks {
    private static AppiumDriver driver;
    private static List<Scenario> scenariosErro = new ArrayList<>();
    private static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    private static List<Scenario> scenariosOK = new ArrayList<>();
    private static Integer contadorFail = 0;
    private static Integer contadorOK = 0;
    private static StringBuilder relatorio = new StringBuilder();


    @AfterStep
    public void verificarErro(Scenario scenario) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        // Verifica se o driver foi inicializado corretamente
        scenariosErro.add(scenario);
        // Captura o screenshot
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Cria um diretório específico para cada cenário
        String scenarioDirectoryName = "target/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String screenshotName = timestamp + ".png";
        String screenshotPath = scenarioDirectoryName + "/" + screenshotName;

        // Cria o diretório de destino se não existir
        try {
            Files.createDirectories(Paths.get(scenarioDirectoryName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Salva o screenshot no sistema de arquivos
        try {
//            System.out.println("Teste falhou");
            Files.write(Paths.get(screenshotPath), screenshotBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Anexa o caminho do screenshot ao cenário do Cucumber
        scenario.attach(screenshotBytes, "image/png", screenshotName);

    }

}
