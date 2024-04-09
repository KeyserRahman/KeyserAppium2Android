package com.Demo.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //Start appium server automatically
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\rehem\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();
        //create android Driver object to automate android app
        //create iOS Driver object to automate iOS app
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RehemanEmulator");
        options.setApp(com.cydeo.utils.ConfigurationReader.getProperty("app1"));
        //options.setApp("\\Users\\rehem\\Appium\\src\\test\\java\\resources\\Google-Translate_Apkpure.apk");
        //options.setApp("\\Users\\rehem\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
    @AfterClass
    public void tearDown(){
        //Stop Driver
        driver.quit();
        //Stop appium server;
        service.stop();
    }
    public void longPressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                        "duration", 2000));
    }
    public void scrollAndFindElement(String selector){
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"+selector+\"));"));

    }
}
