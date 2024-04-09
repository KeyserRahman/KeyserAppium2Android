package com.Demo.tests;
import com.Demo.utils.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumTestTestNG extends BaseTest {
    @Test
    public void AppiumTest() throws MalformedURLException {
        //Start execute test here
        //Set wifi name
        WebElement preferenceBtn = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preferenceBtn.click();
        WebElement preferenceDependenciesBtn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        preferenceDependenciesBtn.click();
        WebElement wifiCheckBox = driver.findElement(AppiumBy.id("android:id/checkbox"));
        wifiCheckBox.click();
        WebElement wifiSettingsBtn = driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]"));
        wifiSettingsBtn.click();
        WebElement wifiSettingsEditor = driver.findElement(AppiumBy.id("android:id/edit"));
        String ActialTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        wifiSettingsEditor.sendKeys("Reheman");
        WebElement okBtn = driver.findElement(AppiumBy.id("android:id/button1"));
        okBtn.click();
        System.out.println(ActialTitle);
        String ExpectedTitle = "WiFi settings";
        Assert.assertEquals(ActialTitle,ExpectedTitle);

    }
}
