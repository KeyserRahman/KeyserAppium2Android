package com.Demo.tests;

import com.Demo.utils.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class ScrollActionTest extends BaseTest{
    @Test
     public void ScrollTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        String selector = "WebView";
        //scrollAndFindElement(selector);
        /*driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"WebView\"));"));*/
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
            Thread.sleep(2000);
        }while (canScrollMore);

        System.out.println(canScrollMore);
        //Thread.sleep(3000);
    }
}
