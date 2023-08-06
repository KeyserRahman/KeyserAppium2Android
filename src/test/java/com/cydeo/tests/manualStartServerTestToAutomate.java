package com.cydeo.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class manualStartServerTestToAutomate {
    @Test
    public void mTest() throws MalformedURLException {
        //Start server automatically

        //Location of Node.js
        String nodeJsPath = "\\Program Files\\nodejs\\node.exe";
        //Location of main.js, Set the path to the Appium server executable
        String appiumJsPath = "\\Users\\rehem\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String ipAddress = "127.0.0.1";
        int portNumber = 4723;

        AppiumDriverLocalService service = new AppiumServiceBuilder()
        .withAppiumJS(new File(appiumJsPath))
        .withIPAddress(ipAddress)
        .usingPort(portNumber)
        .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RehemanEmulator");
        options.setApp("\\Users\\rehem\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.quit();

        //Stop server automatically
        service.stop();


    }
}
