package org.example;

import io.appium.java_client.AppiumDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        URL urlConexao;

        try {
            urlConexao = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.driver = new AppiumDriver(urlConexao, config);
    }
}
