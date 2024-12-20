package org.example;

import io.appium.java_client.AppiumDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumDriverConfig {
    public AppiumDriver driver;
    private static AppiumDriverConfig _instance;

    public static AppiumDriverConfig Instance() {
        if (_instance == null) {
            _instance = new AppiumDriverConfig();
        }
        return _instance;
    }

    public AppiumDriverConfig() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("platformName", "iOS");
        config.setCapability("automationName", "XCUITest");
        config.setCapability("udid", "502683C8-727A-44F6-97B1-3CB917F2A409");
        config.setCapability("platformVersion", "16.2");
        config.setCapability("bundleId", "br.com.autopass.top.builders.dev.hml"); // Substitua pelo Bundle ID correto
        config.setCapability("noReset", false); // Não mantém cache nem preferências
        config.setCapability("fullReset", false); // Não reinstala o app, mas limpa os dados
        URL urlConexao = null;

        try {
            urlConexao = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.driver = new AppiumDriver(urlConexao, config);
    }

    /**
     * Reinicia o aplicativo usando o bundleId.
     */
    public void restartApp() {
        String bundleId = "br.com.autopass.top.builders.dev.hml"; // BundleId correto do seu app
        try {
            driver.terminateApp(bundleId); // Fecha o app
            System.out.println("Aplicativo encerrado com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao encerrar o aplicativo: " + e.getMessage());
        }

        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("bundleId", bundleId);
            driver.executeScript("mobile: launchApp", params); // Relança o app
            System.out.println("Aplicativo relançado com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao relançar o aplicativo: " + e.getMessage());
        }
    }

    public static void biometriaEmulador(String deviceName, int estado) {
        if (estado != 1 && estado != 0) {
            System.out.println("Parâmetros: 1 para ativar biometria ou 0 para desativar biometria.");
        } else {
            try {
                String enableBiometricCommand = String.format("xcrun simctl spawn '%s' notifyutil -s com.apple.BiometricKit.enrollmentChanged '%d'", deviceName, estado);
                String checkBiometricCommand = String.format("xcrun simctl spawn '%s' notifyutil -p com.apple.BiometricKit.enrollmentChanged", deviceName);
                ProcessBuilder processBuilderEnable = new ProcessBuilder("/bin/bash", "-c", enableBiometricCommand);
                Process processEnable = processBuilderEnable.start();
                processEnable.waitFor();
                ProcessBuilder processBuilderCheck = new ProcessBuilder("/bin/bash", "-c", checkBiometricCommand);
                Process processCheck = processBuilderCheck.start();
                processCheck.waitFor();
                if (estado == 1) {
                    System.out.println("Biometria habilitada e verificada com sucesso.");
                } else {
                    System.out.println("Biometria desabilitada e verificada com sucesso.");
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("Erro ao executar o comando: " + e.getMessage());
            }
        }
    }
}
