package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.example.AppiumDriverConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CacheAppConfig {
    private static final String BUNDLE_ID = "br.com.autopass.top.builders.dev.hml";
    private static final String DEVICE_ID = "502683C8-727A-44F6-97B1-3CB917F2A409";

    public static void limparArmazenamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        try {
            String appDataPath = getAppDataPath(DEVICE_ID, BUNDLE_ID);
            if (appDataPath == null || appDataPath.isEmpty()) {
                System.err.println("❌ Não foi possível encontrar o caminho do app.");
                return;
            }

            String targetPath = appDataPath + "/Library/Application Support/" + BUNDLE_ID + "/RCTAsyncLocalStorage_V1";
//            System.out.println("📂 Caminho do arquivo encontrado: " + targetPath);

            deleteFileWithSpaces(targetPath);

//            System.out.println("✅ cache apagado com sucesso.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao apagar o arquivo: " + e.getMessage());
        }
    }

    private static String getAppDataPath(String deviceId, String bundleId) throws Exception {
        String command = String.format("xcrun simctl get_app_container %s %s data", deviceId, bundleId);
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        process.waitFor();
        return output.toString().trim();
    }

    private static void deleteFileWithSpaces(String filePath) throws Exception {
        String command = String.format("rm -rf \"%s\"", filePath);
        System.out.println("Executando comando: " + command);

        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
        processBuilder.inheritIO();  // Para que a saída e erro sejam visíveis no console
        Process process = processBuilder.start();
        process.waitFor();

//        Thread.sleep(2000);
    }

    public static void restartAppWithCacheClear() {
        try {
            // Matar o app
            killApp();
            // Limpar o armazenamento (cache)
            limparArmazenamento();
            // Reiniciar o app
            relancarApp();
        } catch (Exception e) {
            System.err.println("Erro ao reiniciar o app com limpeza de cache: " + e.getMessage());
        }
    }

    private static void killApp() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.terminateApp(BUNDLE_ID);
//        System.out.println("✅ Aplicativo encerrado com sucesso.");
        //        Thread.sleep(3000);
    }

    private static void relancarApp() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        HashMap<String, Object> params = new HashMap<>();
        params.put("bundleId", BUNDLE_ID);
        driver.executeScript("mobile: launchApp", params);

//        System.out.println("✅ Aplicativo relançado com sucesso.");
    }
}
