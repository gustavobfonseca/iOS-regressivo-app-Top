package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {

    public AppiumDriver driver;
    private static AppiumDriverConfig _instance;

    public static AppiumDriverConfig Instance() {
        if (AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instance;
    }

    public AppiumDriverConfig() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        config.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        config.setCapability(MobileCapabilityType.UDID, "502683C8-727A-44F6-97B1-3CB917F2A409"); // Simulador ou dispositivo real
        config.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.2");
        config.setCapability("bundleId", "br.com.autopass.top.builders.dev.hml");

        URL urlConexao = null;
        try {
            urlConexao = new URL("http://127.0.0.1:4723");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AppiumDriver<>(urlConexao, config);
    }
}