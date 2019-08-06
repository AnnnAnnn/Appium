import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Example_1 {

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
        caps.setCapability("newCommandTimeout","180");
        caps.setCapability("newCommandTimeout","180");
        caps.setCapability("appPackage", "com.getride.getdriver.debug");
        caps.setCapability("appActivity", "com.htk.getride.driver.activities.SplashActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    @Test
    public void Test() {

//        driver.findElement(By.id("btnSubmit")).click();
//
//        driver.findElement(By.id("positiveBtn")).click();
//
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "I agree terms and conditions" + "\").instance(0))").click();
//
//        driver.findElement(By.id("btnSubmit")).click();
////
////        WebElement Phone = driver.findElement(By.id("edtPhone"));
////        Phone.click();
////        Phone.sendKeys("09770933123");
////
//        driver.findElement(By.id("edtPhone")).sendKeys("09770933123");
//
//        driver.findElement(By.id("edtPassword")).sendKeys("222222");
//
////        WebElement Password = driver.findElement(By.id("edtPassword"));
////        Password.click();
////        Password.sendKeys("222222");
////
//        driver.findElement(By.id("btnLogin")).click();

    }
}
