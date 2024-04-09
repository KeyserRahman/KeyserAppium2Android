package com.Demo.tests;

import com.Demo.utils.BaseTest;
import com.cydeo.utils.MobileUtils;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LongPressActionTest extends BaseTest{
    @Test
     public void LongPressTest() throws InterruptedException {
         driver.findElement(AppiumBy.accessibilityId("Views")).click();
         driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
         driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
         WebElement peopleNamesBtn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        /*((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) peopleNamesBtn).getId(),
                        "duration", 2000));*/
        longPressAction(peopleNamesBtn);
        String sampleMenuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(sampleMenuText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
     }
}
