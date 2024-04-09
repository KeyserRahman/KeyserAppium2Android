package com.Demo.tests;

import com.Demo.utils.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SwipeActionTest extends BaseTest{
    @Test
     public void SwipeTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("(//android.widget.TextView)[@text='1. Photos']")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        String ActualFocusableB = firstImage.getAttribute("focusable");
        System.out.println(ActualFocusableB);
        //driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(ActualFocusableB,"true");
        //Swipe
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)firstImage).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        String ActualFocusableA = firstImage.getAttribute("focusable");
        Assert.assertEquals(ActualFocusableA,"false");
        System.out.println("after swiped   " + ActualFocusableA);

    }
}
