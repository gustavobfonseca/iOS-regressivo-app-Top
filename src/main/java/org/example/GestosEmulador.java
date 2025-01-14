package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestosEmulador {

    public static void clickCoordenada(int x, int y) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        System.out.println("Clicar no ponto: (" + x + ", " + y + ")");
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);
        driver.executeScript("mobile: tap", params);
    }

    public void rolarScrollViewHorizontalmente() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement scrollView =(MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\" Bilhetes\nQR Code  Cartão\nTOP  Bilhete\nÚnico  Mapa das\nEstações  Mobilidade Barra de rolagem vertical, 2 páginas\"]/XCUIElementTypeScrollView");

        // Rolar da direita para a esquerda
        driver.executeScript("mobile: swipe", ImmutableMap.of(
                "element", ((RemoteWebElement) scrollView).getId(),
                "direction", "left"
        ));

        Thread.sleep(500);
    }

    public static void rolarTelaVertical(String xpath) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        HashMap<String, Object> swipeObject = new HashMap<>();
        swipeObject.put("direction", "down");
        swipeObject.put("element", driver.findElementByXPath(xpath));

        driver.executeScript("mobile: swipe", swipeObject);
    }

    public static void desligarWifi() {
        try {
            // Executa o comando para desativar o Wi-Fi
            Process process = Runtime.getRuntime().exec("networksetup -setairportpower en0 off");
            process.waitFor(); // Aguarda a execução do comando terminar

            // Verifica se houve algum erro na execução
            if (process.exitValue() != 0) {
                throw new RuntimeException("Falha ao desativar o Wi-Fi.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar o comando para desativar o Wi-Fi: " + e.getMessage(), e);
        }
    }

    public static void ligarWifi(){
        try {
            // Executa o comando para ativar o Wi-Fi
            Process process = Runtime.getRuntime().exec("networksetup -setairportpower en0 on");
            process.waitFor(); // Aguarda a execução do comando terminar

            // Verifica se houve algum erro na execução
            if (process.exitValue() != 0) {
                throw new RuntimeException("Falha ao reativar o Wi-Fi.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar o comando para reativar o Wi-Fi: " + e.getMessage(), e);
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
