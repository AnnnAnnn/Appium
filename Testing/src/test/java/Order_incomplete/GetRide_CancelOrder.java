package Order_incomplete;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetRide_CancelOrder {

    public AndroidDriver driver;

    @BeforeTest
    public void SetupAppium() throws Exception {

// Appium Setup
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy A20");
        caps.setCapability("udid", "R58M35NT0WY");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("noReset", "true");
        caps.setCapability("skipServerInstallation", "ture");
        caps.setCapability("newCommandTimeout", "300");
        caps.setCapability("appPackage", "com.getride.customer.debug");
        caps.setCapability("appActivity", "com.htk.getride.ui.activities.WelcomeActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }
//

    @Test
    public void Test() throws Exception{

        Thread.sleep(40000);
        driver.findElement(By.id("dropOffText")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("inputSearch")).sendKeys("Myan");
        driver.findElement(By.xpath("//*[@text='Myanmar Plaza']")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("book")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("cancelOrder")).click();

    }

//    @AfterClass
//    public void teardown(){
//        if(driver!=null) driver.quit();
//
//    }
}

