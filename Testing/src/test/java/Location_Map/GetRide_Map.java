package Location_Map;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GetRide_Map {

    public AndroidDriver driver;


    @BeforeTest
    public void SetupAppium() throws Exception{

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "HUAWEI nova 2 lite");
        caps.setCapability("udid", "RBDBB18906501214");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.MainActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    @Test
    public void Test() throws Exception {

        Thread.sleep(8000);

        WebElement pin = driver.findElement(By.id("pinIcon"));

        new TouchAction(driver).press(pin).waitAction(Duration.ofSeconds(30))
                .moveTo(200,  0)
                .release()
                .perform();

        Thread.sleep(3000);
        driver.findElement(By.id("dropOffText")).click();
//        driver.findElement(By.xpath("//*[@text='SEARCH']")).click();
        Thread.sleep(2000);
        driver.pressKeyCode(61);
        driver.pressKeyCode(61);
        driver.pressKeyCode(61);
        driver.pressKeyCode(61);
        driver.pressKeyCode(66);

        WebElement pin1 = driver.findElement(By.id("pin"));

        new TouchAction(driver).press(pin1).waitAction(Duration.ofSeconds(30))
                .moveTo(200,  0)
                .release()
                .perform();

        Thread.sleep(5000);

        driver.findElement(By.id("pickUp")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("book")).click();
        Thread.sleep(100000);


    }

//    @AfterClass
//    public void teardown(){
//        if(driver!=null) driver.quit();
//
//    }
}
