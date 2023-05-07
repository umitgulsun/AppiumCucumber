package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Driver {
    //create a driver instance
    private static AndroidDriver<MobileElement> driver;
    private static TouchAction touchAction;

    private Driver() {
        //we don't want to create another abject. Singleton pattern
    }

    public static AndroidDriver<MobileElement> getDriver() {
        //create the driver if and only if it is null
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            //  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            capabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("app"));
            capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
            capabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));
            capabilities.setCapability("noReset", "true");

            try {
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            return driver;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//if the driver is pointing chrome
            driver.closeApp();
        }
    }

    public static void elementClickWithText(String text) throws InterruptedException {

        try {
            Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
        } catch (Exception e) {
            Driver.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
            Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
        }

    }

    public static void elementClickWithButton(String text) throws InterruptedException {
        // Thread.sleep(3000);
        Driver.getDriver().findElementByXPath("//android.widget.Button[@text='" + text + "']").click();
    }

    public static void withTextRightScroll(String text) throws InterruptedException {
        boolean isFound = false;
        while (!isFound) {
            try {
                Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
                isFound = true;
            } catch (Exception e) {
                // Öğe bulunamazsa, scroll yapın
                Dimension size = Driver.getDriver().manage().window().getSize();
                int starty = (int) (size.height * 0.2);
                int endy = (int) (size.height * 0.2);
                int startx = (int) (size.width * 0.8);
                int endx = (int) (size.width * 0.2);
                TouchAction touchAction = new TouchAction(Driver.getDriver());
                touchAction.press(PointOption.point(startx, starty))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(startx, endy))
                        .release().perform();
            }
        }

    }

    public static void elementClickWithText2(String text) throws InterruptedException {
        boolean isFound = false;
        while (!isFound) {
            try {
                // Belirtilen metin değerine sahip bir öğe bulmaya çalışın
                Driver.getDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
                isFound = true;
            } catch (Exception e) {
                // Öğe bulunamazsa, scroll yapın
                Dimension size = Driver.getDriver().manage().window().getSize();
                int starty = (int) (size.height * 0.8);
                int endy = (int) (size.height * 0.2);
                int startx = (int) (size.width * 0.2);
                int endx = (int) (size.width * 0.2);
                TouchAction touchAction = new TouchAction(Driver.getDriver());
                touchAction.press(PointOption.point(startx, starty))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(startx, endy))
                        .release().perform();
            }
        }
    }


}
