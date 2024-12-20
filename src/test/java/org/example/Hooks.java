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
import java.util.HashMap;
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

    @Before
    public void beforeScenario() {
        System.out.println("Reiniciando o aplicativo antes do cenário...");
        try {
            AppiumDriverConfig.Instance().restartApp();
//            clearAppCache();

        } catch (Exception e) {
            System.err.println("Erro ao reiniciar o app: " + e.getMessage());
        }
    }

    @After
    public void afterScenario() {
        System.out.println("Cenário finalizado.");
        // Se precisar finalizar o driver ao final de todos os testes, descomente abaixo.
        // AppiumDriverConfig.Instance().driver.quit();
        // AppiumDriverConfig._instance = null;
    }
//    public void clearAppCache() {
//        String bundleId = "br.com.autopass.top.builders.dev.hml";
//        try {
//            // Passo 1: Localizar o caminho correto do app no simulador
//            HashMap<String, Object> paramsPath = new HashMap<>();
//            paramsPath.put("command", "xcrun");
//            paramsPath.put("args", new String[]{"simctl", "get_app_container", "502683C8-727A-44F6-97B1-3CB917F2A409", bundleId, "data"});
//            String appDataPath = (String) driver.executeScript("mobile: shell", paramsPath);
//
//            // Passo 2: Limpar arquivos de cache na pasta Library/Caches
//            if (appDataPath != null && !appDataPath.isEmpty()) {
//                System.out.println("📂 Caminho do app encontrado: " + appDataPath);
//
//                // Montar o caminho completo para a pasta de Caches
//                String cachePath = appDataPath.trim() + "/Library/Caches/*";
//
//                // Passo 3: Deletar arquivos de cache
//                HashMap<String, Object> paramsClear = new HashMap<>();
//                paramsClear.put("command", "rm");
//                paramsClear.put("args", new String[]{"-rf", cachePath});
//                driver.executeScript("mobile: shell", paramsClear);
//
//                System.out.println("✅ Cache do aplicativo limpo com sucesso.");
//            } else {
//                System.err.println("❌ Não foi possível encontrar o caminho do app.");
//            }
//        } catch (Exception e) {
//            System.err.println("❌ Erro ao limpar o cache: " + e.getMessage());
//        }
//    }

}
