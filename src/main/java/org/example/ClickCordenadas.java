package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

import java.util.HashMap;
import java.util.Map;

public class ClickCordenadas {

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

}
