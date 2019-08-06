package Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CleanSMS {

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
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", "com.android.mms.ui.ConversationList");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    @Test
    public void Test() throws Exception {

        driver.findElement(By.xpath("//*[@text='More']")).click();
        driver.findElement(By.xpath("//*[@text='Delete']")).click();
        driver.findElement(By.xpath("//*[@text='Select all']")).click();
        driver.findElement(By.xpath("//*[@text='Delete']")).click();
        driver.findElement(By.xpath("//*[@text='DELETE']")).click();

    }

}
