package com.cydeo.tests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestMainMethod {
    /*This code will start the Appium server automatically before running the test and stop it after the test execution is complete.
    Please make sure to adjust the paths to the Node.js and Appium server executables accordingly.
    Additionally, ensure that you have the correct path to the "ApiDemos-debug.apk" file for the Android application.*/
    private static AppiumDriverLocalService service;

    public static void main(String[] args) {
        //startAppiumServer();
        startAppiumServer();
        AppiumTestMainMethod test = new AppiumTestMainMethod();
        test.executeTest();
        stopAppiumServer();
    }

    private static void startAppiumServer() {
        // Set the path to the Node.js executable
        String nodeJsPath = "\\Program Files\\nodejs\\node.exe";

        // Set the path to the Appium server executable
        String appiumJsPath = "\\Users\\rehem\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumJsPath))
                .usingDriverExecutable(new File(nodeJsPath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);

        service = builder.build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An Appium server node is not started!");
        }
    }

    public void executeTest() {
        try {
            // Configure desired capabilities for AndroidDriver
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("RehemanEmulator");
            options.setApp("\\Users\\rehem\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

            /*UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("RehemanEmulator");
            options.setApp("\\Users\\rehem\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);*/

            //System.out.println(driver.getBatteryInfo());
            driver.quit();

            // Your test steps here...

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
}
