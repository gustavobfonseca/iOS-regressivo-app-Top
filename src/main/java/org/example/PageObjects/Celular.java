package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;

public class Celular {
    private static String bundleId;

    public static void resetApp(AppiumDriver driver){
        bundleId = (String) driver.getCapabilities().getCapability("bundleId");
        driver.terminateApp(bundleId);
        driver.activateApp(bundleId);
    }
}
