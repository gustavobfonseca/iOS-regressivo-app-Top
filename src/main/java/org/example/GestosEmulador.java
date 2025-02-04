package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
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

    public static void rolarScrollViewHorizontalmente(String xpathScrollView) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement scrollView =(MobileElement) driver.findElementByXPath(xpathScrollView);

        // Rolar da direita para a esquerda
        driver.executeScript("mobile: swipe", ImmutableMap.of(
                "element", ((RemoteWebElement) scrollView).getId(),
                "direction", "left"
        ));

        Thread.sleep(500);
    }
    public static void rolarTelaVertical() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");  // Direção do scroll (down ou up)
        scrollObject.put("percent", 0.05);      // Percentual da distância

        driver.executeScript("mobile: scroll", scrollObject);
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


    public static void segurarEArrastar(String xpathOrigem, String xpathDestino) {
        System.out.println("Segurar e arrastar");

        AppiumDriver<MobileElement> driver = AppiumDriverConfig.Instance().driver;
        WebDriverWait espera = new WebDriverWait(driver, 20);

        // Esperar pelos elementos de origem e destino
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOrigem)));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathDestino)));

        MobileElement origem = driver.findElementByXPath(xpathOrigem);
        MobileElement destino = driver.findElementByXPath(xpathDestino);

        // Configurar o gesto com coordenadas dos elementos
        HashMap<String, Object> dragParams = new HashMap<>();
        dragParams.put("duration", 1.0);  // Duração do gesto em segundos
        dragParams.put("fromX", origem.getLocation().getX());
        dragParams.put("fromY", origem.getLocation().getY());
        dragParams.put("toX", destino.getLocation().getX());
        dragParams.put("toY", destino.getLocation().getY());

        // Executar o gesto
        driver.executeScript("mobile: dragFromToForDuration", dragParams);
    }


}
