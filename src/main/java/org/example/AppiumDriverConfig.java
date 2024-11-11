
package org.example;

import io.appium.java_client.AppiumDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        config.setCapability("bundleId", "br.com.autopass.top.builders.dev.hml");
        URL urlConexao = null;

        try {
            urlConexao = new URL("http://127.0.0.1:4723/");
//            biometriaEmulador("Iphone 14", 1);
        } catch (MalformedURLException var4) {
            MalformedURLException e = var4;
            throw new RuntimeException(e);
        }

        this.driver = new AppiumDriver(urlConexao, config);
    }

    public static void biometriaEmulador(String deviceName, int estado) {
        if (estado != 1 && estado != 0) {
            System.out.println("Parâmetros: 1 para ativar biometria ou 0 para desativar biometria.");
        } else {
            try {
                String enableBiometricCommand = String.format("xcrun simctl spawn '%s' notifyutil -s com.apple.BiometricKit.enrollmentChanged '%d'", deviceName, estado);
                String checkBiometricCommand = String.format("xcrun simctl spawn '%s' notifyutil -p com.apple.BiometricKit.enrollmentChanged", deviceName);
                ProcessBuilder processBuilderEnable = new ProcessBuilder(new String[]{"/bin/bash", "-c", enableBiometricCommand});
                Process processEnable = processBuilderEnable.start();
                processEnable.waitFor();
                ProcessBuilder processBuilderCheck = new ProcessBuilder(new String[]{"/bin/bash", "-c", checkBiometricCommand});
                Process processCheck = processBuilderCheck.start();
                processCheck.waitFor();
                if (estado == 1) {
                    System.out.println("Biometria habilitada e verificada com sucesso.");
                } else {
                    System.out.println("Biometria desabilitada e verificada com sucesso.");
                }
            } catch (IOException var8) {
                IOException e = var8;
                System.err.println("Erro de entrada/saída ao executar o comando: " + e.getMessage());
            } catch (InterruptedException var9) {
                InterruptedException e = var9;
                Thread.currentThread().interrupt();
                System.err.println("Execução do comando foi interrompida: " + e.getMessage());
            }
        }

    }
}
